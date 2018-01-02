package com.ty.controller;
import org.springframework.web.multipart.MultipartFile;

import com.ty.entity.Dept;
import com.ty.entity.DownLoad;
import com.ty.entity.User;
import com.ty.service.imp.DownLoadService;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilesController {
	@Autowired
	private DownLoadService downLoadService;
	
	
	@RequestMapping("queryAllFiles")
	public String queryAllFiles(Model model){
		List<DownLoad> downLoads = downLoadService.findAllFiles();
		model.addAttribute("documents", downLoads);
		return "/WEB-INF/jsp/document/document.jsp";
	}
	
	@RequestMapping("UpFile")
	public String upFile(@RequestParam("file") MultipartFile file,String downloadTitle,String downloadDes,HttpServletRequest request,Model model) throws IllegalStateException, IOException{
		System.out.println("文件的名字："+downloadTitle+"---------"+"文件的描述："+downloadDes);
		System.out.println("文件的对象："+file);
		//---------------获取文件的名字---------------
		String fileName = file.getOriginalFilename();
		//---------------获取文件的上传的绝对路径--------------
		String filePath = request.getServletContext().getRealPath("/upLoad"+File.separator+fileName);
		//获取文件的对象
		File file2 = new File(filePath);
		if (file2!=null) {
			//上传文件到指定的地方
			file.transferTo(file2);
			//保存文件到数据库中
			DownLoad downLoad = new DownLoad();
			downLoad.setDownloadCreateTime(new Date());
			downLoad.setDownloadDes(downloadDes);
			downLoad.setDownloadTitle(downloadTitle);
			//获取当前的用户
			User user = (User) request.getSession().getAttribute("user");
			downLoad.setUser(user);
			downLoad.setDownPath(filePath);
			downLoadService.saveFileToSQL(downLoad);
			model.addAttribute("documents", downLoad);
		}
		return "redirect:/queryAllFiles";
	}
	
	@RequestMapping("FindOneDownLoadFile")
	public String findOneDept(String downloadId, Model model) throws Exception {
		int id1 = Integer.parseInt(downloadId);
		DownLoad downLoad = downLoadService.findDownLoadById(id1);
		model.addAttribute("document", downLoad);
		return "/WEB-INF/jsp/document/showUpdateDocument.jsp";
	}
	
	@RequestMapping("/updateOneFile")
	public String updateOneDept(DownLoad downLoad,HttpServletRequest request) throws Exception {
		System.out.println(downLoad);
		downLoad.setDownloadCreateTime(new Date());
		User user = (User) request.getSession().getAttribute("user");
		downLoad.setUser(user);
		downLoadService.updateDownLoad(downLoad);
		return "redirect:/queryAllFiles";
	}
	
	@RequestMapping("/findFilesByTitle")
	public String findFilesByTitle(String downloadTitle, Model model) throws Exception {
		System.out.println(downloadTitle);
		List<DownLoad> downLoads = downLoadService.findFilesByTil(downloadTitle);
		System.out.println("downLoads-----------"+downLoads);
		model.addAttribute("documents", downLoads);
		return "/WEB-INF/jsp/document/document.jsp";
	}
	
	/**
	 * 1.下载文件思路：通过id发现路径
	 * 2.所以路径需要保存到数据库中
	 * 3.通过路径能下载文件，并且能删除文件
	 * @throws Exception 
	 */
	@RequestMapping("/downOneFile")
	public ResponseEntity<byte[]> filesDownLoad(String downloadId) throws Exception {
			int id = Integer.parseInt(downloadId);
			System.out.println("文件下载的id："+id);
			String path = downLoadService.findDownPath(id);
			System.out.println("文件的路径："+path);
		    File file = new File(path);
		    String fileName=file.getName();
		    System.out.println("文件名字：============"+fileName);
		    fileName=new String(fileName.getBytes("gbk"),"ISO-8859-1");
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Disposition", "attachment;filename=" + fileName);
		    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		    return entity;
	}
	
	@RequestMapping("deleteOneFile")
	public String deleteOneFile(String downloadId) throws Exception {
		System.out.println("dId.length()" + downloadId.length());
		
		// 字符串中是否包含逗號，不包含就刪除一個，包含就刪除多個
		if (!downloadId.contains(",")) {
			System.out.println(downloadId);
			int downloadId1 = Integer.parseInt(downloadId);
			String path = downLoadService.findDownPath(downloadId1);
			File file = new File(path);
			if (file!=null) {
				file.delete();
			}
			downLoadService.deleteFileById(downloadId1);
		} else if (downloadId.contains(",")) {
			String[] ids = downloadId.split(",");
			int[] id2 = new int[ids.length];
			int i = 0;
			for (String id1 : ids) {
				id2[i++] = Integer.parseInt(id1);
				
			}
			for (int j = 0; j < id2.length; j++) {
					String path = downLoadService.findDownPath(id2[j]);
					File file = new File(path);
					if (file!=null) {
						file.delete();
					}
			}
			downLoadService.deleteDeptByIds(id2);
		}
		return "redirect:/queryAllFiles";
	}
}

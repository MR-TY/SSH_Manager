package com.ty.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.entity.Dept;
import com.ty.entity.Employee;
import com.ty.entity.Notice;
import com.ty.entity.Staff;
import com.ty.entity.User;
import com.ty.service.imp.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/findAllNotice")
	public String queryAllDept(Model model) throws Exception {
		List<Notice> notices = noticeService.findNoticeAll();
		System.out.println(notices);
		model.addAttribute("notices", notices);
		return "/WEB-INF/jsp/notice/notice.jsp";
	}
	
	@RequestMapping("insertOneNotice")
	public String insertOneNotice(Notice notice,HttpServletRequest request) throws Exception {
		notice.setNoticeCreateTime(new Date());
		getUser(notice,request);
		noticeService.saveNotice(notice);
		return "redirect:/findAllNotice";
	}
	
	@RequestMapping("findOneNotice")
	public String findOneNotice(String nitoceId,String nitoceId1, Model model) throws Exception {
		System.out.println("nitoceId------"+nitoceId+"---------nitoced1------"+nitoceId1);
		if (nitoceId!=null) {
			int id1 = Integer.parseInt(nitoceId);
			Notice notice = noticeService.findNoticeById(id1);
			model.addAttribute("notice", notice);
			return "/WEB-INF/jsp/notice/previewNotice.jsp";
		}
		//修改与展示都通过判断是否为空来区别
		if (nitoceId1!=null) {
			System.out.println("进到修改");
			int id1 = Integer.parseInt(nitoceId1);
			Notice notice = noticeService.findNoticeById(id1);
			model.addAttribute("notice", notice);
			return "/WEB-INF/jsp/notice/showUpdateNotice.jsp";
		}
		return null;
	}
	
	@RequestMapping("/updateOneNotice")
	public String updateOneNotice(Notice notice,HttpServletRequest request) throws Exception {
		notice.setNoticeCreateTime(new Date());
		getUser(notice,request);
		noticeService.updateNotice(notice);
		return "redirect:/findAllNotice";
	}
	
	@RequestMapping("deleteOneNotice")
	public String deleteDept(String nitoceId) throws Exception {
		System.out.println("nitoceId.length()" + nitoceId.length());
		// 字符串中是否包含逗號，不包含就刪除一個，包含就刪除多個
		if (!nitoceId.contains(",")) {
			System.out.println(nitoceId);
			int nitoceId1 = Integer.parseInt(nitoceId);
			noticeService.deleteNoticeById(nitoceId1);
		} else if (nitoceId.contains(",")) {
			String[] ids = nitoceId.split(",");
			int[] id2 = new int[ids.length];
			int i = 0;
			for (String id1 : ids) {
				id2[i++] = Integer.parseInt(id1);
			}
			noticeService.deleteNoticeByIds(id2);
		}
		return "redirect:/findAllNotice";
	}
	
	@RequestMapping("/findNotceLikeByNameAndContent")
	public String findNotceLikeByNameAndContent(String noticeName,String noticeContent,Model model) throws Exception {
		List<Notice> notices = noticeService.findNotceLikeByNameAndContent(noticeName, noticeContent);
		model.addAttribute("notices", notices);
		return "/WEB-INF/jsp/notice/notice.jsp";
	}

	private void getUser(Notice notice, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		notice.setUser(user);
	}
}

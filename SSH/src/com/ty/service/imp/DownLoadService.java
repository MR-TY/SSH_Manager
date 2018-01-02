package com.ty.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.dao.imp.DownLoadDao;
import com.ty.entity.DownLoad;
import com.ty.service1.IDownLoadService;
@Service
@Transactional
public class DownLoadService implements IDownLoadService{
	@Autowired
	private DownLoadDao downLoadDao;
	public void saveFileToSQL(DownLoad downLoad){
		downLoadDao.saveObject(downLoad);
	}
	
	public List<DownLoad> findAllFiles(){
		List<DownLoad> downLoads = downLoadDao.findObjectAll();
		return downLoads;
	}
	
	public DownLoad findDownLoadById(int id) throws Exception{
		DownLoad downLoad = downLoadDao.findObject(id);
		return downLoad;
	}

	public void updateDownLoad(DownLoad downLoad) {
		downLoadDao.updateObject(downLoad);
	}

	public List<DownLoad> findFilesByTil(String downloadTitle) throws Exception {
		if (downloadTitle == null || downloadTitle.equals("")) {
			new RuntimeException("名字为空");
		}
		return downLoadDao.findTByNameLike("downloadTitle", downloadTitle);
	}
	
	public String findDownPath(int id){
		String path = downLoadDao.findPathById(id);
		return path;
	}

	public void deleteFileById(int id) throws Exception {
		deleteDeptByIds(new int[] { id });
	}
	

	public void deleteDeptByIds(int... ids) throws Exception {
		if (null == ids) {
			throw new RuntimeException("不对");
		}
		downLoadDao.deleteTByIds("tbl_doenload", "downloadId", ids);
	}
}

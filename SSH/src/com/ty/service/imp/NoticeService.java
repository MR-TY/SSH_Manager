package com.ty.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ty.dao.imp.NoticeDao;
import com.ty.entity.Notice;
import com.ty.service1.INoticeService;
@Service
@Transactional
public class NoticeService implements INoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> findNoticeAll() throws Exception {
		return noticeDao.findObjectAll();
	}

	@Override
	public List<Notice> findNoticeByNameLike(String name) throws Exception {
		
		return null;
	}

	@Override
	public void deleteNoticeById(int id) throws Exception {
		deleteNoticeByIds(new int[] { id });		
	}

	@Override
	public void deleteNoticeByIds(int... ids) throws Exception {
		if (null == ids) {
			throw new RuntimeException("不对");
		}
		noticeDao.deleteTByIds("tbl_notice", "nitoceId", ids);
	}

	@Override
	public void updateNotice(Notice Notice) throws Exception {
		noticeDao.updateObject(Notice);
	}

	@Override
	public void deleteNoticeByObj(Notice Notice) throws Exception {
		
		
	}

	@Override
	public void saveNotice(Notice Notice) throws Exception {
		noticeDao.saveObject(Notice);
		
	}

	@Override
	public Notice findNoticeById(int dId) throws Exception {
		return noticeDao.findNoticeById(dId);
	}

	@Override
	public List<Notice> findNotceLikeByNameAndContent(String noticeName, String noticeContent) throws Exception {
		System.out.println(noticeName+"==========="+noticeContent);
		if (!noticeName.equals("")&&noticeContent.equals("")) {
			return noticeDao.findNotceLikeByName(noticeName);
		}else if (noticeName.equals("")&&!noticeContent.equals("")) {
			return noticeDao.findNotceLikeByContent(noticeContent);
		}else if (!noticeName.equals("")&&!noticeContent.equals("")) {
			return noticeDao.findNotceLikeByNameAndContent(noticeName, noticeContent);
		}
		return null;
	}

	
}

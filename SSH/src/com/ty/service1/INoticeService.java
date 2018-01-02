package com.ty.service1;

import java.util.List;

import org.springframework.ui.Model;

import com.ty.entity.Notice;
import com.ty.entity.Notice;

public interface INoticeService {
	/**
	 *发现全部的公告
	 */
	List<Notice> findNoticeAll() throws Exception;
	
	/**
	 *通过名字模糊查找公告
	 */
	List<Notice> findNoticeByNameLike(String name)throws Exception ;
	/**
	 * 通过id删除公告
	 */
	void deleteNoticeById(int id)throws Exception ;
	/**
	 * 通过多个id删除公告
	 */
	void deleteNoticeByIds(int... ids)throws Exception ;
	/**
	 * 更新公告
	 */
	void updateNotice(Notice Notice)throws Exception ;
	/**
	 *删除公告
	 */
	void deleteNoticeByObj(Notice Notice)throws Exception ;
	
	/**
	 *保存公告
	 */
	void saveNotice(Notice Notice) throws Exception;
    /**
     * 通过id发现公告
     */
	Notice findNoticeById(int dId) throws Exception;
	 /**
     * 通过noticeName和noticeContent查询公告
     */
	public List<Notice> findNotceLikeByNameAndContent(String noticeName,String noticeContent) throws Exception;
}

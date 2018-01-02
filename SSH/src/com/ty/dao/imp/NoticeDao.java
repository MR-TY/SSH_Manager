package com.ty.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ty.BaseDao.BaseDao;
import com.ty.IBaseDao.IBaseDao;
import com.ty.dao1.INoticeDAO;
import com.ty.entity.Dept;
import com.ty.entity.Notice;

@Repository
public class NoticeDao extends BaseDao<Notice> implements INoticeDAO{

	@Override
	public Notice findNoticeByName(String noticeName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice findNoticeById(int id) throws Exception {
		System.out.println("nitoceId收到的："+id);
		Notice notice = (Notice) getSession().get(Notice.class,id);
		System.out.println("notice:..............."+notice);
		return notice;
	}

	public List<Notice> findNotceLikeByName(String noticeName) {
		String sql = "from Notice n where n.noticeName like :noticeName";//or n.noticeContent like :noticeContent
		Query q=getSession().createQuery(sql);
		q.setParameter("noticeName","%"+noticeName+"%");
		List<Notice> notices = q.list();
		return notices;
	}
	
	public List<Notice> findNotceLikeByContent(String noticeContent) {
		String sql = "from Notice n where n.noticeContent like :noticeContent";
		Query q=getSession().createQuery(sql);
		q.setParameter("noticeContent","%"+noticeContent+"%");
		List<Notice> notices = q.list();
		return notices;
	}
	
	public List<Notice> findNotceLikeByNameAndContent(String noticeName,String noticeContent) {
		String sql = "from Notice n where n.noticeName like :noticeName and n.noticeContent like :noticeContent";
		Query q=getSession().createQuery(sql);
		q.setParameter("noticeName","%"+noticeName+"%");
		q.setParameter("noticeContent","%"+noticeContent+"%");
		List<Notice> notices = q.list();
		return notices;
	}
	
}

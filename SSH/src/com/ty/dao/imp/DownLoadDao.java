package com.ty.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ty.BaseDao.BaseDao;
import com.ty.dao1.IDownLoadDao;
import com.ty.entity.DownLoad;
@Repository
public class DownLoadDao extends BaseDao<DownLoad> implements IDownLoadDao{
	
	public List<DownLoad> findTByNameLikeNew(String name, String nameVal) throws Exception {
		
			System.out.println("进入模糊查询");
			String sql="from tbl_doenload d where d."+name+" like ?";
			Query q=getSession().createQuery(sql);
			q.setString(0,"%"+nameVal+"%");
			List<DownLoad> t=q.list();
			return t;
	}

	public String findPathById(int id) {
		String sql="select d.downPath from com.ty.entity.DownLoad d where d.downloadId=?";
		Query q=getSession().createQuery(sql);
		q.setInteger(0, id);
		String path = (String) q.uniqueResult();
		return path;
	}
}

package com.ty.dao.imp;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ty.BaseDao.BaseDao;
import com.ty.dao1.IDeptDAO;
import com.ty.entity.Dept;

@Repository
public class DeptDao extends BaseDao<Dept> implements IDeptDAO{

	@Override
	public Dept findDeptByName(String dName) throws Exception {
		Query q = getSession().createQuery("from Dept d where d.dName=:dName");
		q.setParameter("dName",dName);
		Dept dept=(Dept) q.uniqueResult();
		return dept;
	}

	@Override
	public Dept findDeptById(int id) throws Exception {
		Dept dept = (Dept) getSession().get(Dept.class,id);
		return dept;
	}
}

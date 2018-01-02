package com.ty.dao.imp;

import org.springframework.stereotype.Repository;

import com.ty.BaseDao.BaseDao;
import com.ty.dao1.IStaffDAO;
import com.ty.entity.Dept;
import com.ty.entity.Staff;

@Repository
public class StaffDAO extends BaseDao<Staff> implements IStaffDAO{

	@Override
	public Staff findStaffById(int id) throws Exception {
		return (Staff) getSession().get(Staff.class, id);
	}
}

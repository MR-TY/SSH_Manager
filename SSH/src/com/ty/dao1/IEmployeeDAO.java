package com.ty.dao1;

import java.util.List;

import com.ty.IBaseDao.IBaseDao;
import com.ty.entity.Employee;

public interface IEmployeeDAO extends IBaseDao<Employee>{
	public List<Employee> findObjectByStaffId(int did);
}

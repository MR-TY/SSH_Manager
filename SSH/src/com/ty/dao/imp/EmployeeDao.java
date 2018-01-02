package com.ty.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ty.BaseDao.BaseDao;
import com.ty.IBaseDao.IBaseDao;
import com.ty.dao1.IEmployeeDAO;
import com.ty.entity.Dept;
import com.ty.entity.Employee;
@Repository
public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDAO{
	//通过职位的id查找
	public List<Employee> findObjectByStaffId(int staffId1){
		Query q = getSession().createQuery("from Employee e where e.staff.staffId=:staffId");
		q.setParameter("staffId",staffId1);
		List<Employee> employees = q.list();
		return employees;
	}
	public List<Employee> findObjectBydId(int dId1){
		Query q = getSession().createQuery("from Employee e where e.dept.dId=:dId");
		q.setParameter("dId",dId1);
		List<Employee> employees = q.list();
		return employees;
	}
}

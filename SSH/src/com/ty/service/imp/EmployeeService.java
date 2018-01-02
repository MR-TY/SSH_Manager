package com.ty.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.dao.imp.EmployeeDao;
import com.ty.entity.Employee;
import com.ty.service1.IEmployeeService;
@Service
@Transactional
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findEmployeeAll() throws Exception {
		List<Employee> employees = employeeDao.findObjectAll();
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByNameLike(String name) throws Exception {
		
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) throws Exception {
		deleteEmployeeByIds(new int[] { id });
	}

	@Override
	public void deleteEmployeeByIds(int... ids) throws Exception {
		if (null == ids) {
			throw new RuntimeException("不对");
		}
		employeeDao.deleteTByIds("tbl_employee", "eId", ids);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		if (null == employee) {
			throw new RuntimeException("部门为空，不能进行更新");
		}
		employeeDao.updateObject(employee);
	}

	@Override
	public void deleteEmployeeByObj(Employee Employee) throws Exception {
		
		
	}

	@Override
	public void saveEmployee(Employee Employee) throws Exception {
		employeeDao.saveObject(Employee);
	}

	@Override
	public Employee findEmployeeById(int dId) throws Exception {
		return employeeDao.findObject(dId);
	}

	@Override
	public List<Employee> findEmployeeByMany(int dId1, int staffId1, int genderId, String eName) {
		System.out.println("dId1:"+dId1+"------staffId1:"+staffId1+"---genderId:"+genderId+"----eName:"+eName);
		if (dId1==0&&staffId1==0&&genderId==0&&eName.equals("")) {
			System.out.println("全部员工查询");
			List<Employee> employees =  employeeDao.findObjectAll();
			return employees;
		}
		if (dId1==0&&staffId1!=0&&genderId==0&&eName.equals("")) {
			System.out.println("------------------正在职位查询------------------");
			List<Employee> employees =  employeeDao.findObjectByStaffId(staffId1);
			System.out.println("employees"+employees);
			return employees;
		}
		if (dId1!=0&&staffId1==0&&genderId==0&&eName.equals("")) {
			System.out.println("------------------正在职位查询------------------");
			List<Employee> employees =  employeeDao.findObjectBydId(dId1);
			System.out.println("employees"+employees);
			return employees;
		}
		return null;
	}
	
}

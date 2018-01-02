package com.ty.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ty.Utils.DataUtils;
import com.ty.entity.Dept;
import com.ty.entity.Employee;
import com.ty.entity.Staff;
import com.ty.enum1.Gender;
import com.ty.enum1.Politics;
import com.ty.mycustomes_tools.CustomersDateEdit;
import com.ty.mycustomes_tools.CustomersGenderEdit;
import com.ty.mycustomes_tools.CustomersPolicsEdit;
import com.ty.service.imp.DeptService;
import com.ty.service.imp.EmployeeService;
import com.ty.service.imp.StaffService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private DeptService deptService;
	
	/**
	 * 绑定时间转换器，和性别转换器
	* @Function: EmployeeController.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年1月3日 下午3:33:21 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年1月3日       water           v1.0.0               修改原因
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomersDateEdit(DataUtils.getFormates(), true));
		binder.registerCustomEditor(Gender.class, new CustomersGenderEdit());
		binder.registerCustomEditor(Politics.class, new CustomersPolicsEdit());
	}
	
	@RequestMapping("/querAllEmp")
	public String queryAllDept(Model model) throws Exception {
		List<Employee> employees = employeeService.findEmployeeAll();
		model.addAttribute("emp", employees);
		System.out.println("进到部门查询了");
		return "/WEB-INF/jsp/employee/employee.jsp";
	}
	
	@RequestMapping("/insertOneEmp")
	public String addOneDept(Employee employee) throws Exception {
		System.out.println("进到员工添加了-----------------");
		System.out.println("employee:"+employee);
		employeeService.saveEmployee(employee);
		return "redirect:/querAllEmp";
	}
	
	@RequestMapping("getStaffAll")
	public @ResponseBody Object getStaffAll() throws Exception {
		List<Staff> staffs = staffService.findStaffAll();
		System.out.println(staffs);
		return staffs;
	}
	
	@RequestMapping("getDeptAll")
	public @ResponseBody Object getDeptAll() throws Exception {
		List<Dept> depts = deptService.findDeptAll();
		System.out.println(depts);
		return depts;
	}
	
	@RequestMapping("deleteOneEmp")
	public String deleteDept(String eId) throws Exception {
		// 字符串中是否包含逗號，不包含就刪除一個，包含就刪除多個
		if (!eId.contains(",")) {
			System.out.println(eId);
			int id = Integer.parseInt(eId);
			employeeService.deleteEmployeeById(id);
		} else if (eId.contains(",")) {
			String[] ids = eId.split(",");
			int[] id2 = new int[ids.length];
			int i = 0;
			for (String id1 : ids) {
				id2[i++] = Integer.parseInt(id1);
			}
			employeeService.deleteEmployeeByIds(id2);
		}
		return "redirect:/querAllEmp";
	}
	
	@RequestMapping("findOneEmp")
	public String findOneEmp(String eId, Model model) throws Exception {
		int id1 = Integer.parseInt(eId);
		Employee employee = employeeService.findEmployeeById(id1);
		model.addAttribute("employee", employee);
		return "/WEB-INF/jsp/employee/showUpdateEmployee.jsp";
	}
	
	@RequestMapping("/updateOneEmp")
	public String updateOneEmp(Employee employee) throws Exception {
		employeeService.updateEmployee(employee);
		return "redirect:/querAllEmp";
	}
	
	@RequestMapping("/findEmployLike")
	public String findEmployLike(String dId, String staffId, String gender,String eName,Model model) throws Exception {
		System.out.println("dId:"+dId+"---"+"staffId:"+staffId+"gender:"+gender+"ename:"+eName);
		int dId1 = Integer.parseInt(dId);
		int staffId1 = Integer.parseInt(staffId);
		int genderId = Integer.parseInt(gender);
		List<Employee> employees = employeeService.findEmployeeByMany(dId1,staffId1,genderId,eName);
		model.addAttribute("emp", employees);
		return "/WEB-INF/jsp/employee/employee.jsp";
	}
}

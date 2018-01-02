package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ty.entity.Dept;
import com.ty.entity.Staff;
import com.ty.service.imp.StaffService;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;

	@RequestMapping("/queryAllStaff")
	public String queryAllStaff(Model model) throws Exception {
		List<Staff> Staffs = staffService.findStaffAll();
		System.out.println(Staffs);
		model.addAttribute("Staff", Staffs);
		return "/WEB-INF/jsp/job/job.jsp";
	}
	
	@RequestMapping("insertOneStaff")
	public String insertOneStaff(Staff staff) throws Exception {
		staffService.saveStaff(staff);
		return "redirect:/queryAllStaff";
	}
	
	@RequestMapping("deleteOneStaff")
	public String deleteDept(String staffId) throws Exception {
		System.out.println("staffId.length()"+staffId.length());
		//字符串中是否包含逗號，不包含就刪除一個，包含就刪除多個
		if (!staffId.contains(",")) {
			System.out.println(staffId);
			int staffId1 = Integer.parseInt(staffId);
			staffService.deleteStaffById(staffId1);
		}else if(staffId.contains(",")){
			String[] ids = staffId.split(",");
			int[] id2 = new int[ids.length];
			int i=0;
			for (String id1 : ids) {
				id2[i++] = Integer.parseInt(id1);
			}
			staffService.deleteStaffByIds(id2);
		}
		return "redirect:/queryAllStaff";
	}
	
	@RequestMapping("updateStaff")
	public String updateStaff(String staffId,Model model) throws Exception {
		int id1 = Integer.parseInt(staffId);
		Staff staff = staffService.findStaffById(id1);
		model.addAttribute("job", staff);
		return "/WEB-INF/jsp/job/showUpdateJob.jsp";
	}
	
	@RequestMapping("/updateOneStaff")
	public String updateOneStaff(Staff staff) throws Exception {
		System.out.println(staff);
		staffService.updateStaff(staff);
		return "redirect:/queryAllStaff";
	}
	
	@RequestMapping("/findOneStaffLike")
	public String findOneStaffLike(String staffName,Model model) throws Exception {
		System.out.println(staffName);
		List<Staff> staffs = staffService.findStaffByNameLike(staffName);
		model.addAttribute("Staff", staffs);
		return "/WEB-INF/jsp/job/job.jsp";
	}
}

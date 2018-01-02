package com.ty.test_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.BaseDao.BaseDao;
import com.ty.entity.Dept;
@Controller
public class TestController {
	@Autowired
	private BaseDao<Dept> basic;
	
	@RequestMapping("/helloworld1")
	public String test() {
		System.out.println("-----------"+basic);
		Dept dept = new Dept();
		dept.setdId(4);
		dept.setdDetail("哈哈");
		dept.setdName("卡卡");
		basic.saveObject(dept);
		return "/WEB-INF/views/NewFile.jsp";
	}
	//不能进行更新
	@Transactional
	@RequestMapping("/helloworld3")
	public String test2() throws Exception {
		System.out.println("-----------"+basic);
		Dept dept = basic.findObject(3);
		System.out.println("查询一个："+dept);
		
		dept.setdDetail("哈哈111");
		dept.setdName("卡卡111");
		System.out.println(dept);
		basic.updateObject(dept);
		return "/WEB-INF/views/NewFile.jsp";
	}
	//--------不能进行更改-----------
	@RequestMapping("/helloworld4")
	public String test3() throws Exception {
		System.out.println("-----------"+basic);
		List<Dept> depts = basic.findObjectAll();
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		Dept dept = basic.findObject(1);
		System.out.println("查询一个："+dept);
		return "/WEB-INF/views/NewFile.jsp";
	}
	@RequestMapping("/helloworld6")
	public String test5() throws Exception {
		List<Dept> depts = basic.findTByNameLike("dName", "卡");
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		return "/WEB-INF/views/NewFile.jsp";
	}
	
}

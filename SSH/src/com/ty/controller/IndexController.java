package com.ty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("top")
	public String ToTop(){
		return "/WEB-INF/jsp/top.jsp";
	}
	@RequestMapping("left")
	public String ToLeft(){
		return "/WEB-INF/jsp/left.jsp";
	}
	@RequestMapping("right")
	public String ToRight(){
		return "/WEB-INF/jsp/right.jsp";
	}
}

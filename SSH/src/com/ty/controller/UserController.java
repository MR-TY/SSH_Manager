package com.ty.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ty.Utils.M5Utils;
import com.ty.entity.Dept;
import com.ty.entity.Employee;
import com.ty.entity.User;
import com.ty.service.imp.EmployeeService;
import com.ty.service.imp.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("users")
	public String loginUser(User user, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			System.out.println("进到登录的页面了");
			// 1.ͨ通过用户名和密码发现用户
			User user2 = userService.findUserByUserNameAndPassword(user);
			System.out.println("user2:"+user2);
			// 2.把用户放进域对象
			model.addAttribute("user", user2);
			// 3.生成token
			String token = UUID.randomUUID().toString();
			// 4.保存token
			saveToken(user2, response, token);
			// 5.把token放进session中
			saveTokenToSession(request, token, user2);
			// 6.跳转页面
			return "/WEB-INF/jsp/main.jsp";
		} catch (Exception e) {
			return "/WEB-INF/jsp/loginForm.jsp";
		}
	}

	// ------------------保存token到session------------
	private void saveTokenToSession(HttpServletRequest request, String token, User user2) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user2);
		System.out.println("token："+token);
		System.out.println("session:" + session);
	}

	// -----------------保存token----------------
	private void saveToken(User user2, HttpServletResponse response, String token) {
		// 1把用户转换为字符串类型
		String userData = user2.toString();
		System.out.println("userData:" + userData);
		// 2.生成cookie
		Cookie cookie = new Cookie(token, userData);
		// 3.给cookie设置时间，不设置时间默认关闭会话就结束cookie
		// 4.给cookie设置路径
		cookie.setPath("/SSH");
		// 5.响应cookie
		response.addCookie(cookie);
		System.out.println("成功");
	}

	@RequestMapping("findAllUser")
	public String findAllUser(Model model) throws Exception {
		List<User> users = userService.findUserAll();
		model.addAttribute("user", users);
		return "/WEB-INF/jsp/user/user.jsp";
	}

	@RequestMapping("updateUser")
	public String findAllUser(int eId, Model model) throws Exception {
		User users = userService.findObject(eId);
		model.addAttribute("user", users);
		return "/WEB-INF/jsp/user/showUpdateUser.jsp";
	}

	@RequestMapping("updateOneUser")
	public String updateOneUser(User user) throws Exception {
		System.out.println("进到user的更新了--------------");
		System.out.println("原来的uesr" + user);
		// -----------通过id发现密码-----------
		String pwd = userService.findPwdByEId(user.geteId());
		System.out.println("user密码：" + user.getuPwd());
		// -----------如果密码不等于原来的密码------------
		if (!pwd.equals(user.getuPwd())) {
			user.setuPwd(M5Utils.getM5Parame(user.getuPwd()));
		}
		user.setuCreateTime(new Date());
		System.out.println("现在的User" + user);
		userService.updateUser(user);
		return "redirect:/findAllUser";
	}

	@RequestMapping("deleteUser")
	public String deleteUser(String eId) throws Exception {
		if (!eId.contains(",")) {
			System.out.println(eId);
			int eId1 = Integer.parseInt(eId);
			userService.deleteUserById(eId1);
		} else if (eId.contains(",")) {
			String[] ids = eId.split(",");
			int[] id2 = new int[ids.length];
			int i = 0;
			for (String id1 : ids) {
				id2[i++] = Integer.parseInt(id1);
			}
			userService.deleteUserByIds(id2);
		}
		return "redirect:/findAllUser";
	}

	@RequestMapping("/queryLikeUser")
	public String findOneUserLike(String uName,String state, Model model) throws Exception {
		System.out.println("uName:"+uName+"========="+"state:"+state);
		Integer state1=null;
		if (!state.equals("")) {
			state1 = Integer.parseInt(state);
		}
		List<User> users = userService.findUserByNameAndState(uName, state1);
		model.addAttribute("user", users);
		return "/WEB-INF/jsp/user/user.jsp";
	}
	
	@RequestMapping("findAllEmp")
	public @ResponseBody Object findAllEmp() throws Exception {
		List<Employee> employees = employeeService.findEmployeeAll();
		System.out.println(employees);
		return employees;
	}
	
	@RequestMapping("addOneUser")
	public String addOneUser(User user) throws Exception {
		int id = user.geteId();
		if (userService.findObject(id)!=null) {
			System.err.println("用户已经存在，不能在创建");
			return "redirect:/findAllUser";
		}
		user.setuCreateTime(new Date());
		user.setEmp(employeeService.findEmployeeById(user.geteId()));
		user.setuPwd(M5Utils.getM5Parame(user.getuPwd()));
		userService.addOneUser(user);
		return "redirect:/findAllUser";
	}
}

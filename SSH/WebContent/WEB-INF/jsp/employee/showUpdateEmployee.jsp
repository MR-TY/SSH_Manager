<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人事管理系统——修改员工</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link href="${pageContext.request.contextPath}/css/css.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css" />
<link
	href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-migrate-1.2.1.js"></script>
<script
	src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.jss"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/pager.css"
	type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function JobInit() {
		var ajax = getAJAX();
		ajax.open("POST", "${pageContext.request.contextPath}/getStaffAll");
		ajax.send(null);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					//获取servlet中响应的值  
					var val = ajax.responseText;
					//编码为json的格式
					var jsonArray = eval("(" + val + ")");
					//通过id获取select的对象
					var jobSelects = document.getElementById("job_jId");
					//遍历数组
					for (var i = 0; i < jsonArray.length; i++) {
						//获取json的对象
						var val1 = jsonArray[i];
						//创建子类option
						var optionChild = document.createElement("option");
						//通过json的对象获取id值
						optionChild.value = val1.staffId;
						//通过json的对象获取名字
						optionChild.innerText = val1.staffName;
						//接入子类
						jobSelects.appendChild(optionChild);
					}
				}
			}
		}
	}
	function deptInit() {
		//获取ajax的对象
		var ajax = getAJAX();
		//打开servlet的方法
		ajax.open("POST", "${pageContext.request.contextPath}/getDeptAll");
		//发送空指针
		ajax.send(null);
		//进行ajax的监听
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					//获取servlet中响应的值  
					var val = ajax.responseText;
					//编码为json的格式
					var jsonArray = eval("(" + val + ")");
					//通过id获取select的对象
					var jobSelects = document.getElementById("dept_dId");
					//遍历数组
					for (var i = 0; i < jsonArray.length; i++) {
						//获取json的对象
						var val1 = jsonArray[i];
						//创建子类option
						var optionChild = document.createElement("option");
						//通过json的对象获取id值
						optionChild.value = val1.dId;
						//通过json的对象获取名字
						optionChild.innerText = val1.dName;
						//接入子类
						jobSelects.appendChild(optionChild);
					}
				}
			}
		}
	}
	//获取ajax的对象
	function getAJAX() {
		var ajax = null;
		try {
			ajax = new ActiveXObject('microsoft.xmlhttp');
		} catch (e) {
			try {
				ajax = new XMLHttpRequest();
			} catch (e) {
				alert("浏览器使用的是啥玩意儿")
			}
		}
		return ajax;
	}
	window.onload = function() {
		JobInit();
		deptInit();
	}
	$(function() {
		/** 员工表单提交 */
		$("#employeeForm").submit(function() {
			/* var name = $("#name");
			var cardId = $("#cardId");
			var education = $("#education");
			var email = $("#email");
			var phone = $("#phone");
			var tel = $("#tel");
			var party = $("#party");
			var qqNum = $("#qqNum");
			var address = $("#address");
			var postCode = $("#postCode");
			var birthday = $("#birthday");
			var race = $("#race");
			var speciality = $("#speciality");
			var hobby = $("#hobby");
			var msg = "";
			if ($.trim(name.val()) == ""){
				msg = "姓名不能为空！";
				name.focus();
			}else if ($.trim(cardId.val()) == ""){
				msg = "身份证号码不能为空！";
				cardId.focus();
			}else if (!/^[1-9]\d{16}[0-9A-Za-z]$/.test($.trim(cardId.val()))){
				msg = "身份证号码格式不正确！";
				cardId.focus();
			}else if ($.trim(education.val()) == ""){
				msg = "学历不能为空！";
				education.focus();
			}else if ($.trim(email.val()) == ""){
				msg = "邮箱不能为空！";
				email.focus();
			}else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(email.val()))){
				msg = "邮箱格式不正确！";
				email.focus();
			}else if ($.trim(phone.val()) == ""){
				msg = "手机号码不能为空！";
				phone.focus();
			}else if (!/^1[3|5|8]\d{9}$/.test($.trim(phone.val()))){
				msg = "手机号码格式不正确！";
				phone.focus();
			}else if ($.trim(tel.val()) == ""){
				msg = "电话号码不能为空！";
				tel.focus();
			}else if (!/^0\d{2,3}-?\d{7,8}$/.test($.trim(tel.val()))){
				msg = "电话号码格式不正确！";
				tel.focus();
			} else if ($.trim(party.val()) == ""){
				msg = "政治面貌不能为空！";
				party.focus();
			} else if ($.trim(qqNum.val()) == ""){
				msg = "QQ号码不能为空！";
				qqNum.focus();
			}else if (!/^\d{6,}$/.test($.trim(qqNum.val()))){
				msg = "QQ号码格式不正确！";
				qqNum.focus();
			}else if ($.trim(address.val()) == ""){
				msg = "地址不能为空！";
				address.focus();
			}else if ($.trim(postCode.val()) == ""){
				msg = "邮政编码不能为空！";
				postCode.focus();
			}else if (!/^[1-9]\d{5}$/.test($.trim(postCode.val()))){
				msg = "邮政编码格式不正确！";
				postCode.focus();
			} else if ($.trim(birthday.val()) == ""){
				msg = "出生日期不能为空！";
				birthday.focus();
			} else if (!birthday.val()){
			//					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
				msg = "出生日期格式不正确！";
				birthday.focus();
			}else if ($.trim(race.val()) == ""){
				msg = "民族不能为空！";
				race.focus();
			}else if ($.trim(speciality.val()) == ""){
				msg = "专业不能为空！";
				speciality.focus();
			}else if ($.trim(hobby.val()) == ""){
				msg = "爱好不能为空！";
				hobby.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			} */
			$("#employeeForm").submit();
		});
	});
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="15" height="32"><img
				src="${pageContext.request.contextPath}/images/main_locleft.gif"
				width="15" height="32"></td>
			<td class="main_locbg font2"><img
				src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理
				&gt; 修改员工</td>
			<td width="15" height="32"><img
				src="${pageContext.request.contextPath}/images/main_locright.gif"
				width="15" height="32"></td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5"
		cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form action="${pageContext.request.contextPath}/updateOneEmp"
					id="employeeForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<input type="hidden" name="flag" value="2"> <input
						type="hidden" name="eId" value="${employee.eId}">
					<table width="100%" border="0" cellpadding="0" cellspacing="10"
						class="main_tab">
						<tr>
							<td class="font3 fftd">
								<table>
									<tr>
										<td class="font3 fftd">姓名：<input type="text" name="eName"
											id="name" size="20" value="${employee.eName }" /></td>
										<td class="font3 fftd">身份证号码：<input type="text"
											name="eIdCard" id="cardId" size="20"
											value="${employee.idCardNum }" /></td>
									</tr>

									<tr>
										<td class="font3 fftd">性别： <select id="sex"
											name="eGender" style="width: 143px;">
												<option value="0">--请选择性别--</option>
												<option value="2">男</option>
												<option value="1">女</option>
										</select>
										</td>

										<td class="font3 fftd">职&nbsp;&nbsp;&nbsp;位： <select
											id="job_jId" name="staff.staffId" style="width: 143px;">
												<%-- 	<option value="0">--请选择职位--</option>
					    			<c:forEach items="${requestScope.jobs }" var="job">
					    				<option value="${job.id }">${job.name }</option>
					    			</c:forEach>--%>
										</select>
										</td>
									</tr>

								</table>
							</td>
						</tr>
						<tr>
							<td class="font3 fftd">政治面貌： <select name="politics"
								style="width: 143px;">
									<option value="0">--请选择身份--</option>
									<option value="1">群众</option>
									<option value="2">预备党员</option>
									<option value="3">党员</option>
							</select>
							</td>
						</tr>

						<tr>
							<td class="font3 fftd"></td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>

						<tr>
							<td class="font3 fftd">联系地址：<input name="eAddress"
								id="address" size="40" value="${employee.address}" />&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>

						<tr>
							<td class="font3 fftd"></td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>

						<tr>
							<td class="font3 fftd"></td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>

						<tr>
							<td class="font3 fftd">&nbsp;&nbsp;所属部门： <select
								id="dept_dId" name="dept.dId" style="width: 100px;">

							</select>
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>

						<tr>
							<td align="left" class="fftd"><input type="submit"
								value="修改">&nbsp;&nbsp;<input type="reset" value="取消 "></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
</body>
</html>
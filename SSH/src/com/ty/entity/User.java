package com.ty.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
/**
 * �Ñ��w
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: User.java
* @Description: ����Ĺ�������
*
* @version: v1.0.0
* @author: water
* @date: 2018��4��3�� ����10:55:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018��4��3��       water           v1.0.0               �޸�ԭ��
 */
@Entity
public class User implements Serializable {
	private int eId;
	private Employee employee;
	private String uLoginName;
	private String uPwd;
	private int state;
	private Date uCreateTime;

	public User() {

	}

	public User(int eId, Employee emp, String uLoginName, String uPwd, int state, Date uCreateTime) {
		super();
		this.eId = eId;
		this.employee = emp;
		this.uLoginName = uLoginName;
		this.uPwd = uPwd;
		this.state = state;
		this.uCreateTime = uCreateTime;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public Employee getEmp() {
		return employee;
	}

	public void setEmp(Employee emp) {
		this.employee = emp;
	}

	public String getuLoginName() {
		return uLoginName;
	}

	public void setuLoginName(String uLoginName) {
		this.uLoginName = uLoginName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	@Override
	public String toString() {
		return "User [eId=" + eId + ", emp=" + employee + ", uLoginName=" + uLoginName + ", uPwd=" + uPwd + ", state="
				+ state + ", uCreateTime=" + uCreateTime + "]";
	}
}

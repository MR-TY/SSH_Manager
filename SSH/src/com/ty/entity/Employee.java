package com.ty.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.sun.corba.se.impl.oa.poa.Policies;
import com.ty.enum1.Gender;
import com.ty.enum1.Politics;
/**
 * �T�����w
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Employee.java
* @Description: ����Ĺ�������
*
* @version: v1.0.0
* @author: water
* @date: 2018��4��3�� ����10:54:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018��4��3��       water           v1.0.0               �޸�ԭ��
 */
@Entity
public class Employee implements Serializable{
	private int  eId;           
	private String eName;       
	private String idCardNum;   
	private Gender gender;      
	private Staff staff;        
	private String education;   
	private String email;       
	private String mobilePhone; 
	private String phoneNum;    
	private Politics politics;  
	private String qqNum;        
	private String address;    
	private String postCode;       
	private Date birthDay;       
	private String nation;       
	private String major;        
	private String habbit;       
	private String remark;       
	private Dept dept;           
	public Employee() {
		super();
	}
	public Employee(int eId, String eName, String idCardNum, Gender gender, Staff staff, String education, String email,
			String mobilePhone, String phoneNum, Politics politics, String qqNum, String address, String postCode,
			Date birthDay, String nation, String major, String habbit, String remark, Dept dept) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.idCardNum = idCardNum;
		this.gender = gender;
		this.staff = staff;
		this.education = education;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.phoneNum = phoneNum;
		this.politics = politics;
		this.qqNum = qqNum;
		this.address = address;
		this.postCode = postCode;
		this.birthDay = birthDay;
		this.nation = nation;
		this.major = major;
		this.habbit = habbit;
		this.remark = remark;
		this.dept = dept;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Politics getPolitics() {
		return politics;
	}
	public void setPolitics(Politics politics) {
		this.politics = politics;
	}
	public String getQqNum() {
		return qqNum;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getHabbit() {
		return habbit;
	}
	public void setHabbit(String habbit) {
		this.habbit = habbit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", idCardNum=" + idCardNum + ", gender=" + gender
				+ ", staff=" + staff + ", education=" + education + ", email=" + email + ", mobilePhone=" + mobilePhone
				+ ", phoneNum=" + phoneNum + ", politics=" + politics + ", qqNum=" + qqNum + ", address=" + address
				+ ", postCode=" + postCode + ", birthDay=" + birthDay + ", nation=" + nation + ", major=" + major
				+ ", habbit=" + habbit + ", remark=" + remark + ", dept=" + dept + "]";
	}
}

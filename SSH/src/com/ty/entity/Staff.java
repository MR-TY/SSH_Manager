package com.ty.entity;

import java.io.Serializable;

import javax.persistence.Entity;
/**
 * λ���w
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Staff.java
* @Description: ����Ĺ�������
*
* @version: v1.0.0
* @author: water
* @date: 2018��4��3�� ����10:55:13 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018��4��3��       water           v1.0.0               �޸�ԭ��
 */
@Entity
public class Staff implements Serializable {
	private int staffId;
	private String staffName;
	private String staffDetail;

	public Staff() {

	}

	public Staff(int staffId, String staffName, String staffDetail) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffDetail = staffDetail;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffDetail() {
		return staffDetail;
	}

	public void setStaffDetail(String staffDetail) {
		this.staffDetail = staffDetail;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffDetail=" + staffDetail + "]";
	}
}

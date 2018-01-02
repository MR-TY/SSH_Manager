package com.ty.entity;

import java.io.Serializable;

import javax.persistence.Entity;
/**
 * 部門實體
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Dept.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: water
* @date: 2018年4月3日 下午10:54:34 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年4月3日       water           v1.0.0               修改原因
 */
@Entity
public class Dept implements Serializable {
	private int dId;
	private String dName;
	private String dDetail;

	public Dept(int dId, String dName, String dDetail) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dDetail = dDetail;
	}

	public Dept() {

	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdDetail() {
		return dDetail;
	}

	public void setdDetail(String dDetail) {
		this.dDetail = dDetail;
	}

	@Override
	public String toString() {
		return "Dept [dId=" + dId + ", dName=" + dName + ", dDetail=" + dDetail + "]";
	}
}

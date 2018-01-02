package com.ty.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
/**
 * ���挍�w
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Notice.java
* @Description: ����Ĺ�������
*
* @version: v1.0.0
* @author: water
* @date: 2018��4��3�� ����10:55:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018��4��3��       water           v1.0.0               �޸�ԭ��
 */
@Entity
public class Notice implements Serializable{
	 private int nitoceId;
	 private String noticeName;
	 private String noticeContent;
	 private Date noticeCreateTime;
	 private User user;
	public Notice() {

	}
	public Notice(int nitoceId, String noticeName, String noticeContent, Date noticeCreateTime, User user) {
		super();
		this.nitoceId = nitoceId;
		this.noticeName = noticeName;
		this.noticeContent = noticeContent;
		this.noticeCreateTime = noticeCreateTime;
		this.user = user;
	}
	public int getNitoceId() {
		return nitoceId;
	}
	public void setNitoceId(int nitoceId) {
		this.nitoceId = nitoceId;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeCreateTime() {
		return noticeCreateTime;
	}
	public void setNoticeCreateTime(Date noticeCreateTime) {
		this.noticeCreateTime = noticeCreateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notice [nitoceId=" + nitoceId + ", noticeName=" + noticeName + ", noticeContent=" + noticeContent
				+ ", noticeCreateTime=" + noticeCreateTime + ", user=" + user + "]";
	}  
}

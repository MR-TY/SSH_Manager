package com.ty.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
/**
 * 公告實體
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Notice.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: water
* @date: 2018年4月3日 下午10:55:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年4月3日       water           v1.0.0               修改原因
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

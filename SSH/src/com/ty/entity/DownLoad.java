package com.ty.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
/**
 * ���d���Č��w
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: DownLoad.java
* @Description: ����Ĺ�������
*
* @version: v1.0.0
* @author: water
* @date: 2018��4��3�� ����10:54:17 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018��4��3��       water           v1.0.0               �޸�ԭ��
 */
@Entity
public class DownLoad implements Serializable {
	private int downloadId;
	private String downloadTitle;
	private Date downloadCreateTime;
	private User user;
	private String downloadDes;
	private String downPath;
	public DownLoad(int downloadId, String downloadTitle, Date downloadCreateTime, User user, String downloadDes,
			String downPath) {
		super();
		this.downloadId = downloadId;
		this.downloadTitle = downloadTitle;
		this.downloadCreateTime = downloadCreateTime;
		this.user = user;
		this.downloadDes = downloadDes;
		this.downPath = downPath;
	}
	public DownLoad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDownloadId() {
		return downloadId;
	}
	public void setDownloadId(int downloadId) {
		this.downloadId = downloadId;
	}
	public String getDownloadTitle() {
		return downloadTitle;
	}
	public void setDownloadTitle(String downloadTitle) {
		this.downloadTitle = downloadTitle;
	}
	public Date getDownloadCreateTime() {
		return downloadCreateTime;
	}
	public void setDownloadCreateTime(Date downloadCreateTime) {
		this.downloadCreateTime = downloadCreateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDownloadDes() {
		return downloadDes;
	}
	public void setDownloadDes(String downloadDes) {
		this.downloadDes = downloadDes;
	}
	public String getDownPath() {
		return downPath;
	}
	public void setDownPath(String downPath) {
		this.downPath = downPath;
	}
	@Override
	public String toString() {
		return "DownLoad [downloadId=" + downloadId + ", downloadTitle=" + downloadTitle + ", downloadCreateTime="
				+ downloadCreateTime + ", user=" + user + ", downloadDes=" + downloadDes + ", downPath=" + downPath
				+ "]";
	}
}

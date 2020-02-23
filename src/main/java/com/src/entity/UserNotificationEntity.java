package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "usernotificationentity")
@Table(name = "APP_USER_NOTIFICATIONS")

public class UserNotificationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "USERID")
	private int userid;

	@Column(name = "SENTON")
	private String senton;

	@Column(name = "SENTBY")
	private String sentby;

	@Column(name = "TEMPLATEID")
	private int templateid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenton() {
		return senton;
	}

	public void setSenton(String senton) {
		this.senton = senton;
	}

	public String getSentby() {
		return sentby;
	}

	public void setSentby(String sentby) {
		this.sentby = sentby;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTemplateid() {
		return templateid;
	}

	public void setTemplateid(int templateid) {
		this.templateid = templateid;
	}

}

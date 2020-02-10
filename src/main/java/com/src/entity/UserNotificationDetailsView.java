package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "APP_USERNOTIFICATION_DETAILS_VW")
public class UserNotificationDetailsView {

	@Id
	@Column(name = "TEMPLATEID")
	private int templateId;

	@Column(name = "USERID")
	private int userId;

	@Column(name = "NAME")
	private String templatename;

	@Column(name = "SENTON")
	private String senton;

	@Column(name = "SENTBY")
	private String sentby;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "DESCRIPTION")
	private String description; 
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	
}

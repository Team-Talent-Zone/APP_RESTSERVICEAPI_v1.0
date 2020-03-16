package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity(name = "freelancedocumententity")
@Table(name = "APP_USER_FREELANCER_DOCUMENTS")

public class FreeLanceDocumentsEntity implements Serializable{

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer Id;
	
	@Column(insertable = false, updatable = false, name = "USERID")
	private Integer userid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	@Column(name = "DOCNAME")
	private String docname;
	
	@Column(name = "DOCURL")
	private String docurl;
	
	@Column(name = "UPLOADDATE")
	private String uploaddate;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDocurl() {
		return docurl;
	}

	public void setDocurl(String docurl) {
		this.docurl = docurl;
	}

	public String getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	
}

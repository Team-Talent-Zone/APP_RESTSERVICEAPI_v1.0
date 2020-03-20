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

/**
 * The <code> UserManagerDetailsEntity </code> class defines a POJO that provides back-end
 * functionality for the <code>User Details</code> pages.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */

@Entity(name = "usermanagerdetailsentity")
@Table(name = "APP_USER_MANAGER_DETAILS")
public class UserManagerDetailsEntity implements Serializable {

	private static final long serialVersionUID = 7746606166203360317L;
	
	@Column(insertable = false, updatable = false, name = "userId")
	private int userId;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer Id;
	
	@Column(name = "MANAGERID")
	private int managerid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}
	
}

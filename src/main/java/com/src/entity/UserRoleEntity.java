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
 * The <code> UserRoleEntity </code> class defines a POJO that provides back-end
 * functionality for the <code>UserDetails</code> pages.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
@Entity(name = "userroles")
@Table(name = "APP_USER_ROLE")
public class UserRoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLEID")
	@GeneratedValue
	private Integer roleId;

	@Column(insertable = false, updatable = false, name = "userId")
	private int userId;

	@Column(name = "ROLECODE")
	private String rolecode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

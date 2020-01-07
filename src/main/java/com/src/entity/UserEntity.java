package com.src.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * This is UserEntity class 
 */

@Entity(name = "userdetails")
@Table(name = "APP_USER_DETAILS")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userId")
	@GeneratedValue
	private Integer userId;

	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ISACTIVE")
	private boolean isactive;

	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "ISRECOVERYPWD")
	private boolean isrecoverypwd;

	@Column(name = "REASONOFDEACTIVATION")
	private String reasonofdeactivation;

	@Column(name = "CREATEDON")
	private String createdon;
	
	@Column(name = "CREATEDBY")
	private String createdby;


	@Column(name = "UPDATEDBY")
	private String updateby;

	@Column(name = "UPDATEDON")
	private String updatedon;

	 	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "userdetails")
	private Set<UserRoleEntity> userroles;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "userdetails")
	private Set<UserBizEntity> userbizdetails;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isIsrecoverypwd() {
		return isrecoverypwd;
	}

	public void setIsrecoverypwd(boolean isrecoverypwd) {
		this.isrecoverypwd = isrecoverypwd;
	}

	public String getReasonofdeactivation() {
		return reasonofdeactivation;
	}

	public void setReasonofdeactivation(String reasonofdeactivation) {
		this.reasonofdeactivation = reasonofdeactivation;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public Set<UserRoleEntity> getUserroles() {
		return userroles;
	}

	public void setUserroles(Set<UserRoleEntity> userroles) {
		this.userroles = userroles;
	}

	public Set<UserBizEntity> getUserbizdetails() {
		return userbizdetails;
	}

	public void setUserbizdetails(Set<UserBizEntity> userbizdetails) {
		this.userbizdetails = userbizdetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 
	
	
	
}
package com.src.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The <code> UserEntity </code> class defines a POJO that provides back-end
 * functionality for the <code>UserDetails</code> pages.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
@Entity(name = "userdetails")
@Table(name = "APP_USER_DETAILS")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 428235307895292984L;

	@Id
	@Column(name = "USERID")
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

	@Column(name = "AVTARURL")
	private String avtarurl;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userdetails")
	private UserRoleEntity userroles;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userdetails")
	private UserBizEntity userbizdetails;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userdetails")
	private FreelanceEntity freeLanceDetails;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userdetails")
	private FreelancehistoryEntity freelancehistoryentity;

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

	public UserRoleEntity getUserroles() {
		return userroles;
	}

	public void setUserroles(UserRoleEntity userroles) {
		this.userroles = userroles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAvtarurl() {
		return avtarurl;
	}

	public void setAvtarurl(String avtarurl) {
		this.avtarurl = avtarurl;
	}

	public UserBizEntity getUserbizdetails() {
		return userbizdetails;
	}

	public void setUserbizdetails(UserBizEntity userbizdetails) {
		this.userbizdetails = userbizdetails;
	}

	public FreelanceEntity getFreeLanceDetails() {
		return freeLanceDetails;
	}

	public void setFreeLanceDetails(FreelanceEntity freeLanceDetails) {
		this.freeLanceDetails = freeLanceDetails;
	}

	public FreelancehistoryEntity getFreelancehistoryentity() {
		return freelancehistoryentity;
	}

	public void setFreelancehistoryentity(FreelancehistoryEntity freelancehistoryentity) {
		this.freelancehistoryentity = freelancehistoryentity;
	}

}
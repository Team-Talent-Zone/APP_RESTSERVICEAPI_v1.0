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

@Entity(name = "userdetails")
@Table(name = "userdetails")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERID")
	@GeneratedValue
	private Integer userid;

	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ENABLED")
	private boolean enabled;

	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "FULLNAME")
	private String fullname;
	
	@Column(name = "ABTYOU")
	private String abtyou;

	@Column(name = "UPLOADPICURL")
	private String uploadpicurl;

	@Column(name = "isrecoverypwd")
	private boolean isrecoverypwd;

	@Column(name = "PHONENUMBER")
	private String phonenumber;

	@Column(name = "CREATEDON")
	private String createdon;

	@Column(name = "LASTUPDATEDON")
	private String lastupdatedon;

	@Column(name = "LASTUPDATEDBY")
	private String lastupdatedby;

	@Column(name = "ISSPCERTIFIED")
	private boolean isspcertified;
	
	@Column(name = "ISNOTIFICATEDTOTEAM")
	private boolean isnotificatedtoteam;
	
	@Column(name = "REASONFORDISABLE")
	private String reasonfordisable;
	
	@Column(name = "LASTLOGINEDIN")
	private String lastloginedin;
	
	/*@Column(name = "istermsacceptedatsignup")
	private boolean istermsacceptedatsignup;*/
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "userdetails")
	private Set<UserRoleEntity> userroles;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "userdetails")
	private Set<UserBizEntity> userbizdetails;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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


	public Set<UserRoleEntity> getUserroles() {
		return userroles;
	}

	public void setUserroles(Set<UserRoleEntity> userroles) {
		this.userroles = userroles;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Set<UserBizEntity> getUserbizdetails() {
		return userbizdetails;
	}

	public void setUserbizdetails(Set<UserBizEntity> userbizdetails) {
		this.userbizdetails = userbizdetails;
	}

	public String getAbtyou() {
		return abtyou;
	}

	public void setAbtyou(String abtyou) {
		this.abtyou = abtyou;
	}

	public String getUploadpicurl() {
		return uploadpicurl;
	}

	public void setUploadpicurl(String uploadpicurl) {
		this.uploadpicurl = uploadpicurl;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getLastupdatedon() {
		return lastupdatedon;
	}

	public void setLastupdatedon(String lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}

	public String getLastupdatedby() {
		return lastupdatedby;
	}

	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public boolean isIsspcertified() {
		return isspcertified;
	}

	public void setIsspcertified(boolean isspcertified) {
		this.isspcertified = isspcertified;
	}
	
	public boolean isIsnotificatedtoteam() {
		return isnotificatedtoteam;
	}

	public void setIsnotificatedtoteam(boolean isnotificatedtoteam) {
		this.isnotificatedtoteam = isnotificatedtoteam;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isIsrecoverypwd() {
		return isrecoverypwd;
	}

	public void setIsrecoverypwd(boolean isrecoverypwd) {
		this.isrecoverypwd = isrecoverypwd;
	}

	public String getReasonfordisable() {
		return reasonfordisable;
	}

	public void setReasonfordisable(String reasonfordisable) {
		this.reasonfordisable = reasonfordisable;
	}

	public String getLastloginedin() {
		return lastloginedin;
	}

	public void setLastloginedin(String lastloginedin) {
		this.lastloginedin = lastloginedin;
	}

	/*public boolean isIstermsacceptedatsignup() {
		return istermsacceptedatsignup;
	}

	public void setIstermsacceptedatsignup(boolean istermsacceptedatsignup) {
		this.istermsacceptedatsignup = istermsacceptedatsignup;
	}*/

	
	
	
}
package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> UserServiceExpirationDetailsView </code> class defines managed
 * beans which provides functionality on the
 * <code>User Service Expiration Details View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_USERSERVICE_EXPIRATION_DETAILS_VW")
public class UserServiceExpirationDetailsView {

	@Id
	@Column(name = "USERID")
	private int userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "CREATEDON")
	private String createdon;

	@Column(name = "CREATEDBY")
	private String createdby;

	@Column(name = "SERVICESTARTON")
	private String servicestarton;

	@Column(name = "SERVICEENDON")
	private String serviceendon;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PREFERLANG")
	private String preferlang;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getServicestarton() {
		return servicestarton;
	}

	public void setServicestarton(String servicestarton) {
		this.servicestarton = servicestarton;
	}

	public String getServiceendon() {
		return serviceendon;
	}

	public void setServiceendon(String serviceendon) {
		this.serviceendon = serviceendon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreferlang() {
		return preferlang;
	}

	public void setPreferlang(String preferlang) {
		this.preferlang = preferlang;
	}

}

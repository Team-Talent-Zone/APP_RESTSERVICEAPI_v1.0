package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> FreeLanceOnServiceExpirationDetailsView </code> class defines
 * managed beans which provides functionality on the
 * <code>FreeLance On Service Expiration Details View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_FU_ONSERVICE_JOB_EXPIRATION_DETAILS_VW")
public class FreeLanceOnServiceExpirationDetailsView {

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

	@Column(name = "NAME")
	private String name;

	@Column(name = "PREFERLANG")
	private String preferlang;

	@Column(name = "JOBCREATEDON")
	private String jobcreatedon;

	@Column(name = "JOBENDEDON")
	private String jobendedon;

	@Column(name = "AMOUNTCBAPAIDTOFU")
	private String amountcbapaidtofu;

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

	public String getJobcreatedon() {
		return jobcreatedon;
	}

	public void setJobcreatedon(String jobcreatedon) {
		this.jobcreatedon = jobcreatedon;
	}

	public String getJobendedon() {
		return jobendedon;
	}

	public void setJobendedon(String jobendedon) {
		this.jobendedon = jobendedon;
	}

	public String getAmountcbapaidtofu() {
		return amountcbapaidtofu;
	}

	public void setAmountcbapaidtofu(String amountcbapaidtofu) {
		this.amountcbapaidtofu = amountcbapaidtofu;
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

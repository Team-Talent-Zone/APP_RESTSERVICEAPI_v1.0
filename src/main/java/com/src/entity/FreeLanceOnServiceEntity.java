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
 * The <code> FreeLanceOnServiceEntity </code> class defines a POJO that
 * provides back-end functionality for the
 * <code> Free Lance On Service Details.</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "freeLanceOnService")
@Table(name = "APP_FREELANCE_ONSERVICE_DETAILS")
public class FreeLanceOnServiceEntity implements Serializable {
	private static final long serialVersionUID = -3335012254117836219L;

	@Id
	@Column(name = "JOBID")
	@GeneratedValue
	private Integer jobId;

	@Column(insertable = false, updatable = false, name = "SERVICEID")
	private int serviceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceId", nullable = false)
	@JsonIgnore
	private UserServiceDetailsEntity userServiceDetails;

	@Column(name = "freelanceuserId")
	private Integer freelanceuserId;

	@Column(insertable = true, updatable = false, name = "USERID")
	private Integer userId;

	@Column(name = "JOBCREATEDON")
	private String jobstartedon;

	@Column(name = "JOBENDEDON")
	private String jobendedon;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ISJOBACCEPTED")
	private boolean isjobaccepted;

	@Column(name = "UPDATEDON")
	private String updatedon;

	@Column(name = "UPDATEDBY")
	private String updatedby;

	@Column(name = "ISJOBACTIVE")
	private boolean isjobactive;

	@Column(name = "TOTALHOURSOFJOB")
	private Float totalhoursofjob;

	@Column(name = "AMOUNT")
	private Float amount;

	@Column(name = "isjobamtpaid")
	private boolean isjobamtpaid;

	@Column(name = "ISJOBCANCEL")
	private boolean isjobcancel;

	@Column(name = "subcategory")
	private String subcategory;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public UserServiceDetailsEntity getUserServiceDetails() {
		return userServiceDetails;
	}

	public void setUserServiceDetails(UserServiceDetailsEntity userServiceDetails) {
		this.userServiceDetails = userServiceDetails;
	}

	public Integer getFreelanceuserId() {
		return freelanceuserId;
	}

	public void setFreelanceuserId(Integer freelanceuserId) {
		this.freelanceuserId = freelanceuserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getJobstartedon() {
		return jobstartedon;
	}

	public void setJobstartedon(String jobstartedon) {
		this.jobstartedon = jobstartedon;
	}

	public String getJobendedon() {
		return jobendedon;
	}

	public void setJobendedon(String jobendedon) {
		this.jobendedon = jobendedon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isIsjobaccepted() {
		return isjobaccepted;
	}

	public void setIsjobaccepted(boolean isjobaccepted) {
		this.isjobaccepted = isjobaccepted;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public boolean isIsjobactive() {
		return isjobactive;
	}

	public void setIsjobactive(boolean isjobactive) {
		this.isjobactive = isjobactive;
	}

	public Float getTotalhoursofjob() {
		return totalhoursofjob;
	}

	public void setTotalhoursofjob(Float totalhoursofjob) {
		this.totalhoursofjob = totalhoursofjob;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public boolean isIsjobamtpaid() {
		return isjobamtpaid;
	}

	public void setIsjobamtpaid(boolean isjobamtpaid) {
		this.isjobamtpaid = isjobamtpaid;
	}

	public boolean isIsjobcancel() {
		return isjobcancel;
	}

	public void setIsjobcancel(boolean isjobcancel) {
		this.isjobcancel = isjobcancel;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
 

	
}

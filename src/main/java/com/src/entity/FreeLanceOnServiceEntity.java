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

	@Column(insertable = true, updatable = false, name = "USERID")
	private Integer userId;

	@Column(name = "JOBCREATEDON")
	private String jobCreatedOn;

	@Column(name = "JOBENDEDON")
	private String jobEndedOn;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ISJOBACCEPTED")
	private boolean isJobAccepted;

	@Column(name = "UPDATEDON")
	private String updatedOn;

	@Column(name = "UPDATEDBY")
	private String updatedBy;

	@Column(name = "ISJOBACTIVE")
	private boolean isJobActive;

	@Column(name = "TOTALHOURSOFJOB")
	private Float totalHoursOfJob;

	@Column(name = "AMOUNTCBAPAIDTOFU")
	private Float amountCbaPaidToFu;

	@Column(name = "OUTSTANDINGAMTOPAYTOCOMPANY")
	private Float outStandingAmtoPayToCompany;

	@Column(name = "ISOUTSTANDINGAMTPAID")
	private boolean isOutStandingAmtPaid;

	@Column(name = "ISJOBCANCEL")
	private boolean isJobCancel;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getJobCreatedOn() {
		return jobCreatedOn;
	}

	public void setJobCreatedOn(String jobCreatedOn) {
		this.jobCreatedOn = jobCreatedOn;
	}

	public String getJobEndedOn() {
		return jobEndedOn;
	}

	public void setJobEndedOn(String jobEndedOn) {
		this.jobEndedOn = jobEndedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isJobAccepted() {
		return isJobAccepted;
	}

	public void setJobAccepted(boolean isJobAccepted) {
		this.isJobAccepted = isJobAccepted;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isJobActive() {
		return isJobActive;
	}

	public void setJobActive(boolean isJobActive) {
		this.isJobActive = isJobActive;
	}

	public Float getTotalHoursOfJob() {
		return totalHoursOfJob;
	}

	public void setTotalHoursOfJob(Float totalHoursOfJob) {
		this.totalHoursOfJob = totalHoursOfJob;
	}

	public Float getAmountCbaPaidToFu() {
		return amountCbaPaidToFu;
	}

	public void setAmountCbaPaidToFu(Float amountCbaPaidToFu) {
		this.amountCbaPaidToFu = amountCbaPaidToFu;
	}

	public Float getOutStandingAmtoPayToCompany() {
		return outStandingAmtoPayToCompany;
	}

	public void setOutStandingAmtoPayToCompany(Float outStandingAmtoPayToCompany) {
		this.outStandingAmtoPayToCompany = outStandingAmtoPayToCompany;
	}

	public boolean isOutStandingAmtPaid() {
		return isOutStandingAmtPaid;
	}

	public void setOutStandingAmtPaid(boolean isOutStandingAmtPaid) {
		this.isOutStandingAmtPaid = isOutStandingAmtPaid;
	}

	public boolean isJobCancel() {
		return isJobCancel;
	}

	public void setJobCancel(boolean isJobCancel) {
		this.isJobCancel = isJobCancel;
	}

}

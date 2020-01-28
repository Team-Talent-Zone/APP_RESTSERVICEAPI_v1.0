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
 * The <code> UserServiceDetails </code> class defines a POJO that provides
 * back-end functionality for the <code> User Service Details.</code>.
 * 
 * @author Shanoor
 *
 */
@Entity(name = "userServiceDetails")
@Table(name = "APP_USER_SERVICE_DETAILS")
public class UserServiceDetailsEntity implements Serializable {
	private static final long serialVersionUID = 178635312682419598L;

	@Id
	@Column(name = "SERVICEID")
	@GeneratedValue
	private Integer serviceId;

	@Column(insertable = false, updatable = false, name = "OURSERVICEID")
	private int ourserviceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ourserviceId", nullable = false)
	@JsonIgnore
	private NewServiceEntity newService;

	@Column(insertable = true, updatable = false, name = "USERID")
	private Integer userId;

	@Column(name = "CREATEDBY")
	private String createdBy;

	@Column(name = "CREATEDON")
	private String createdOn;

	@Column(name = "ISACTIVE")
	private boolean isActive;

	@Column(name = "REASONOFUNSUBSCRIBE")
	private String reasonOfUnSubscribe;

	@Column(name = "SERVICEPACKNAME")
	private String servicePackName;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SERVICESTARTON")
	private String serviceStartOn;

	@Column(name = "SERVICEENDON")
	private String serviceEndOn;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public int getOurserviceId() {
		return ourserviceId;
	}

	public void setOurserviceId(int ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

	public NewServiceEntity getNewService() {
		return newService;
	}

	public void setNewService(NewServiceEntity newService) {
		this.newService = newService;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getReasonOfUnSubscribe() {
		return reasonOfUnSubscribe;
	}

	public void setReasonOfUnSubscribe(String reasonOfUnSubscribe) {
		this.reasonOfUnSubscribe = reasonOfUnSubscribe;
	}

	public String getServicePackName() {
		return servicePackName;
	}

	public void setServicePackName(String servicePackName) {
		this.servicePackName = servicePackName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceStartOn() {
		return serviceStartOn;
	}

	public void setServiceStartOn(String serviceStartOn) {
		this.serviceStartOn = serviceStartOn;
	}

	public String getServiceEndOn() {
		return serviceEndOn;
	}

	public void setServiceEndOn(String serviceEndOn) {
		this.serviceEndOn = serviceEndOn;
	}

}

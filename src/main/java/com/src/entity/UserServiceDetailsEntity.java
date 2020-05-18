package com.src.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The <code> UserServiceDetailsEntity </code> class defines a POJO that
 * provides back-end functionality for the <code> User Service Details.</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "userServiceDetailsEntity")
@Table(name = "APP_USER_SERVICE_DETAILS")
public class UserServiceDetailsEntity implements Serializable {
	private static final long serialVersionUID = 178635312682419598L;

	@Id
	@Column(name = "SERVICEID")
	@GeneratedValue
	private Integer serviceId;

	@Column(insertable = false, updatable = false, name = "ourserviceId")
	private Integer ourserviceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ourserviceId", nullable = false)
	@JsonIgnore
	private NewServiceEntity newService;

	@Column(name = "USERID")
	private int userid;
	
	@Column(name = "CHILDSERVICEPKGSERVICEID")
	private Integer childservicepkgserviceid;

	@Column(name = "CREATEDBY")
	private String createdby; 
	
	@Column(name = "txnid")
	private String txnid; 

	@Column(name = "CREATEDON")
	private String createdon;

	@Column(name = "ISACTIVE")
	private boolean isactive;

	@Column(name = "REASONOFUNSUBSCRIBE")
	private String reasonofunsubscribe;

	@Column(name = "ISSERVICEPACK")
	private boolean isservicepack;
	
	@Column(name = "ISSERVICEPURCHASED")
	private boolean isservicepurchased;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "amount")
	private Float amount; 

	@Column(name = "SERVICESTARTON")
	private String servicestarton;

	@Column(name = "SERVICEENDON")
	private String serviceendon;
	
	@Column(name = "validPeriodLabel")
	private String validPeriodLabel;
	
	@Column(name = "validPeriodCode")
	private String validPeriodCode;
	
	@Column(name = "publishedlinkurl")
	private String publishedlinkurl;
		
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userServiceDetailsEntity")
	private Set<UserServiceEventHistoryEntity> userServiceEventHistory;

	public String getValidPeriodLabel() {
		return validPeriodLabel;
	}

	public void setValidPeriodLabel(String validPeriodLabel) {
		this.validPeriodLabel = validPeriodLabel;
	}

	public String getValidPeriodCode() {
		return validPeriodCode;
	}

	public void setValidPeriodCode(String validPeriodCode) {
		this.validPeriodCode = validPeriodCode;
	}

	public boolean isIsservicepurchased() {
		return isservicepurchased;
	}

	public void setIsservicepurchased(boolean isservicepurchased) {
		this.isservicepurchased = isservicepurchased;
	}

	public Integer getChildservicepkgserviceid() {
		return childservicepkgserviceid;
	}

	public void setChildservicepkgserviceid(Integer childservicepkgserviceid) {
		this.childservicepkgserviceid = childservicepkgserviceid;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getOurserviceId() {
		return ourserviceId;
	}

	public void setOurserviceId(Integer ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

	public NewServiceEntity getNewService() {
		return newService;
	}

	public void setNewService(NewServiceEntity newService) {
		this.newService = newService;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getReasonOfunsubscribe() {
		return reasonofunsubscribe;
	}

	public void setReasonOfunsubscribe(String reasonOfunsubscribe) {
		this.reasonofunsubscribe = reasonOfunsubscribe;
	}

	public boolean isIsservicepack() {
		return isservicepack;
	}

	public void setIsservicepack(boolean isservicepack) {
		this.isservicepack = isservicepack;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Set<UserServiceEventHistoryEntity> getUserServiceEventHistory() {
		return userServiceEventHistory;
	}

	public String getReasonofunsubscribe() {
		return reasonofunsubscribe;
	}

	public void setReasonofunsubscribe(String reasonofunsubscribe) {
		this.reasonofunsubscribe = reasonofunsubscribe;
	}

	public void setUserServiceEventHistory(Set<UserServiceEventHistoryEntity> userServiceEventHistory) {
		this.userServiceEventHistory = userServiceEventHistory;
	}
	
	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getPublishedlinkurl() {
		return publishedlinkurl;
	}

	public void setPublishedlinkurl(String publishedlinkurl) {
		this.publishedlinkurl = publishedlinkurl;
	}
	
}

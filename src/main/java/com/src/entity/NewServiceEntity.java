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

/**
 * The <code> NewServiceEntity </code> class defines a POJO that provides
 * back-end functionality for the <code>New Service Adding</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "newService")
@Table(name = "APP_ADMIN_NEWSERVICE")
public class NewServiceEntity implements Serializable {
	private static final long serialVersionUID = 178635312682419598L;

	@Id
	@Column(name = "ourserviceId")
	@GeneratedValue
	private Integer ourserviceId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DOMAIN")
	private String domain;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "ISACTIVE")
	private boolean  active;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "FULLCONTENT")
	private String fullContent;

	@Column(name = "IMGURL")
	private String imageUrl;

	@Column(name = "CREATEDBY")
	private String createdBy;

	@Column(name = "CREATEDON")
	private String createdOn;

	@Column(name = "UPDATEDON")
	private String updatedOn;

	@Column(name = "UPDATEDBY")
	private String updatedBy;
	
	@Column(name = "CURRENTSTATUS")
	private String currentstatus;

	@Column(name = "ISUPGRADE")
	private boolean isupgrade;

	@Column(name = "VALIDPERIOD")
	private String validPeriod;

	@Column(name = "AMOUNT")
	private Float amount;
	
	@Column(name = "PACKWITHOTHEROURSERVICEID")
	private Integer packwithotherourserviceid;

	@Column(insertable = true, updatable = false, name = "userId") 
	private Integer userId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "newService")
	private Set<NewServiceHistoryEntity> serviceHistory;

	public Integer getOurserviceId() {
		return ourserviceId;
	}

	public void setOurserviceId(Integer ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

	public String getName() {
		return name;
	}

	public String getCurrentstatus() {
		return currentstatus;
	}
 
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullContent() {
		return fullContent;
	}

	public void setFullContent(String fullContent) {
		this.fullContent = fullContent;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

 
	public boolean isIsupgrade() {
		return isupgrade;
	}

	public void setIsupgrade(boolean isupgrade) {
		this.isupgrade = isupgrade;
	}

	public String getValidPeriod() {
		return validPeriod;
	}

	public void setValidPeriod(String validPeriod) {
		this.validPeriod = validPeriod;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Set<NewServiceHistoryEntity> getServiceHistory() {
		return serviceHistory;
	}

	public void setServiceHistory(Set<NewServiceHistoryEntity> serviceHistory) {
		this.serviceHistory = serviceHistory;
	}

	public Integer getPackwithotherourserviceid() {
		return packwithotherourserviceid;
	}

	public void setPackwithotherourserviceid(Integer packwithotherourserviceid) {
		this.packwithotherourserviceid = packwithotherourserviceid;
	}

}

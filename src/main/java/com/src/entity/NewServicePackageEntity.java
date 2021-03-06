package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The <code> NewServicePackageEntity </code> class defines a POJO that provides
 * back-end functionality for the <code>New Service Package</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "servicePackage")
@Table(name = "APP_ADMIN_NEWSERVICE_PACKAGE")
public class NewServicePackageEntity implements Serializable {
	private static final long serialVersionUID = 5543009639489969527L;

	@Id
	@GeneratedValue
	@Column(name = "SERVICEPACKID")
	private Integer servicePackId;

	@Column(name = "SERVICEPACKNAME")
	private String servicePackName;

	@Column(name = "PKGAMOUNT")
	private Float pkgAmount;

	@Column(name = "pkgvalidperiod")
	private String pkgValidYears;

	@Column(name = "ISACTIVE")
	private boolean isActive;

	@Column(name = "CREATEDON")
	private String createdOn;

	@Column(insertable = true, updatable = false, name = "userId")
	private Integer userId;

	@Column(insertable = true, updatable = false, name = "ourserviceId")
	private Integer ourserviceId;

	public Integer getServicePackId() {
		return servicePackId;
	}

	public void setServicePackId(Integer servicePackId) {
		this.servicePackId = servicePackId;
	}

	public String getServicePackName() {
		return servicePackName;
	}

	public void setServicePackName(String servicePackName) {
		this.servicePackName = servicePackName;
	}

	public Integer getOurserviceId() {
		return ourserviceId;
	}

	public void setOurserviceId(Integer ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

	public Float getPkgAmount() {
		return pkgAmount;
	}

	public void setPkgAmount(Float pkgAmount) {
		this.pkgAmount = pkgAmount;
	}

	public String getPkgValidYears() {
		return pkgValidYears;
	}

	public void setPkgValidYears(String pkgValidYears) {
		this.pkgValidYears = pkgValidYears;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}

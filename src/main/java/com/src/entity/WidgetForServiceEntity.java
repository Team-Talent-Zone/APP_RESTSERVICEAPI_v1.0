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
 * The <code> WidgetForServiceEntity </code> class defines a POJO that provides
 * back-end functionality for the <code>Widget For Service Entity</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "widgetEntity")
@Table(name = "APP_DESIGN_WIDGET_FORSERVICE")
public class WidgetForServiceEntity implements Serializable {

	private static final long serialVersionUID = -554310494836630112L;

	@Id
	@Column(name = "widgetId")
	@GeneratedValue
	private Integer widgetId;

	@Column(name = "CREATEDON")
	private String createdOn;

	@Column(name = "ISACTIVE")
	private boolean isActive;

	@Column(name = "ISPUBLISHED")
	private boolean ispublished;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "updatedon")
	private String updatedon;

	@Column(name = "HOSTNAME")
	private String hostname;

	@Column(insertable = true, updatable = false, name = "userId")
	private int userId;

	@Column(insertable = true, updatable = false, name = "serviceid")
	private int serviceId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "widgetEntity")
	private WidgetLayoutEntity widgetLayoutEntity;

	public Integer getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(Integer widgetId) {
		this.widgetId = widgetId;
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

	public boolean isIspublished() {
		return ispublished;
	}

	public void setIspublished(boolean ispublished) {
		this.ispublished = ispublished;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public WidgetLayoutEntity getWidgetLayoutEntity() {
		return widgetLayoutEntity;
	}

	public void setWidgetLayoutEntity(WidgetLayoutEntity widgetLayoutEntity) {
		this.widgetLayoutEntity = widgetLayoutEntity;
	}

}

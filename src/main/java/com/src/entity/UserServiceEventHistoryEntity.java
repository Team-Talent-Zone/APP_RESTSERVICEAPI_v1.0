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
 * The <code> UserServiceEventHistory </code> class defines a POJO that provides
 * back-end functionality for the <code>User Service Event History</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "userServiceEventHistory")
@Table(name = "APP_USER_SERVICE_EVENT_HISTORY")
public class UserServiceEventHistoryEntity implements Serializable {
	private static final long serialVersionUID = 178635312682419598L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(insertable = false, updatable = false, name = "SERVICEID")
	private Integer serviceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceId", nullable = false)
	@JsonIgnore
	private UserServiceDetailsEntity userServiceDetailsEntity;

	@Column(name = "EVENTNAME")
	private String eventname;

	@Column(name = "EVENTCODE")
	private String eventcode;

	@Column(name = "UPDATEDBY")
	private String updatedby;

	@Column(name = "UPDATEDON")
	private String updatedon;

	@Column(insertable = true, updatable = false, name = "userId")
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public UserServiceDetailsEntity getUserServiceDetailsEntity() {
		return userServiceDetailsEntity;
	}

	public void setUserServiceDetailsEntity(UserServiceDetailsEntity userServiceDetailsEntity) {
		this.userServiceDetailsEntity = userServiceDetailsEntity;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventcode() {
		return eventcode;
	}

	public void setEventcode(String eventcode) {
		this.eventcode = eventcode;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}

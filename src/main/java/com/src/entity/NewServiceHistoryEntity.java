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
 * The <code> NewServiceHistoryEntity </code> class defines a POJO that provides
 * back-end functionality for the <code>New Service History</code>.
 * 
 * @author Shanoor
 *
 */
@Entity(name = "serviceHistory")
@Table(name = "APP_ADMIN_NEWSERVICE_HISTORY")
public class NewServiceHistoryEntity implements Serializable {
	private static final long serialVersionUID = -5752035189768615452L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(insertable = false, updatable = false, name = "ourserviceId")
	private int ourserviceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ourserviceId", nullable = false)
	@JsonIgnore
	private NewServiceEntity newService;

	@Column(insertable = true, updatable = false, name = "userId")
	private int userId;

	@Column(name = "DECISIONBY")
	private String decisionBy;

	@Column(name = "DECISIONON")
	private String decisionOn;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "ISLOCKED")
	private boolean isLocked;

	@Column(name = "MANAGERID")
	private Integer managerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOurserviceId() {
		return ourserviceId;
	}

	public void setOurserviceId(Integer ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDecisionBy() {
		return decisionBy;
	}

	public void setDecisionBy(String decisionBy) {
		this.decisionBy = decisionBy;
	}

	public String getDecisionOn() {
		return decisionOn;
	}

	public void setDecisionOn(String decisionOn) {
		this.decisionOn = decisionOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public NewServiceEntity getNewService() {
		return newService;
	}

	public void setNewService(NewServiceEntity newService) {
		this.newService = newService;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setOurserviceId(int ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

}

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

@Entity(name = "freelancehistoryentity")
@Table(name = "APP_USER_FREELANCE_HISTORY")
public class FreeLanceHistoryEntity implements Serializable {

	private static final long serialVersionUID = -1697844064430609298L;

	@Id
	@Column(name = "EVENTID")
	@GeneratedValue
	private Integer eventId;
	
	@Column(insertable = false, updatable = false, name = "USERID")
	private Integer userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	@Column(name = "DECISIONBY")
	private String decisionBy;

	@Column(name = "DECISIONON")
	private String decisionOn;

	@Column(name = "BGSTATUS")
	private String bgStatus;

	@Column(name = "BGCOMMENT")
	private String bgComment;

	@Column(name = "ISLOCKED")
	private boolean isLocked;

	@Column(name = "MANAGERID")
	private Integer managerId;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
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

	public String getBgStatus() {
		return bgStatus;
	}

	public void setBgStatus(String bgStatus) {
		this.bgStatus = bgStatus;
	}

	public String getBgComment() {
		return bgComment;
	}

	public void setBgComment(String bgComment) {
		this.bgComment = bgComment;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

}

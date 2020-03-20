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
 * The <code> FreeLanceOnServiceNotification </code> class defines a POJO that
 * provides back-end functionality for the
 * <code>Free Lance On Service Notification.</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "freeLanceOnServiceNotification")
@Table(name = "APP_FREELANCE_ONSERVICE_NOTIFICATIONS")
public class FreeLanceOnServiceNotification implements Serializable {

	private static final long serialVersionUID = -5483605173825535762L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(insertable = false, updatable = false, name = "JOBID")
	private Integer jobId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobId", nullable = false)
	@JsonIgnore
	private FreeLanceOnServiceEntity freeLanceOnServiceEntity;

	@Column(name = "senton")
	private String sentOn;

	@Column(name = "sentby")
	private String sentBy;

	@Column(insertable = true, updatable = false, name = "USERID")
	private Integer userId;

	@Column(insertable = true, updatable = false, name = "TEMPLATEID")
	private Integer templateId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public FreeLanceOnServiceEntity getFreeLanceOnServiceEntity() {
		return freeLanceOnServiceEntity;
	}

	public void setFreeLanceOnServiceEntity(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		this.freeLanceOnServiceEntity = freeLanceOnServiceEntity;
	}

	public String getSentOn() {
		return sentOn;
	}

	public void setSentOn(String sentOn) {
		this.sentOn = sentOn;
	}

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

}

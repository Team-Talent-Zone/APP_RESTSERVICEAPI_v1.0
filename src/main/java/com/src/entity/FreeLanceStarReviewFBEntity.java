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
 * The <code> FreeLanceStarReviewFB </code> class defines a POJO that provides
 * back-end functionality for the
 * <code> Free Lance Star Review FeedBack Details.</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "freeLanceStarReviewFB")
@Table(name = "APP_FREELANCE_STARREVIEWS_FEEDBACK")
public class FreeLanceStarReviewFBEntity implements Serializable {

	private static final long serialVersionUID = 495528534806932352L;

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer id;

	@Column(insertable = false, updatable = false, name = "JOBID")
	private Integer jobId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobId", nullable = false)
	@JsonIgnore
	private FreeLanceOnServiceEntity freeLanceOnServiceEntity;

	@Column(insertable = true, updatable = false, name = "USERID")
	private Integer userId;

	@Column(name = "feedbackby")
	private String feedbackby;

	@Column(name = "starrate")
	private Integer starrate;

	@Column(name = "feedbackon")
	private String feedbackon;

	@Column(name = "feedbackcomment")
	private String feedbackcomment;
	
	@Column(name = "freelanceuserId")
	private Integer freelanceuserId;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	public String getFeedbackby() {
		return feedbackby;
	}

	public void setFeedbackby(String feedbackby) {
		this.feedbackby = feedbackby;
	}

	public Integer getStarrate() {
		return starrate;
	}

	public void setStarrate(Integer starrate) {
		this.starrate = starrate;
	}

	public String getFeedbackon() {
		return feedbackon;
	}

	public void setFeedbackon(String feedbackon) {
		this.feedbackon = feedbackon;
	}

	public String getFeedbackcomment() {
		return feedbackcomment;
	}

	public void setFeedbackcomment(String feedbackcomment) {
		this.feedbackcomment = feedbackcomment;
	}

	public Integer getFreelanceuserId() {
		return freelanceuserId;
	}

	public void setFreelanceuserId(Integer freelanceuserId) {
		this.freelanceuserId = freelanceuserId;
	}

	

}

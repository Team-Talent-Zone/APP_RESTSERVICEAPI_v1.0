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
 *
 */
@Entity(name = "freeLanceStarReviewFB")
@Table(name = "APP_FREELANCE_STARREVIEWS_FEEDBACK")
public class FreeLanceStarReviewFBEntity implements Serializable {

	private static final long serialVersionUID = 495528534806932352L;

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

	@Column(insertable = true, updatable = false, name = "USERID")
	private Integer userId;

	@Column(name = "feedbackby")
	private String feedBackBy;

	@Column(name = "starrate")
	private Integer starRate;

	@Column(name = "feedbackon")
	private String feedBackOn;

	@Column(name = "feedbackcomment")
	private String feedBackComment;

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

	public String getFeedBackBy() {
		return feedBackBy;
	}

	public void setFeedBackBy(String feedBackBy) {
		this.feedBackBy = feedBackBy;
	}

	public Integer getStarRate() {
		return starRate;
	}

	public void setStarRate(Integer starRate) {
		this.starRate = starRate;
	}

	public String getFeedBackOn() {
		return feedBackOn;
	}

	public void setFeedBackOn(String feedBackOn) {
		this.feedBackOn = feedBackOn;
	}

	public String getFeedBackComment() {
		return feedBackComment;
	}

	public void setFeedBackComment(String feedBackComment) {
		this.feedBackComment = feedBackComment;
	}

}

package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> FreeLanceStarReviewFB </code> class defines a POJO that provides
 * back-end functionality for the
 * <code> Free Lance Star Review FeedBack Details.</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_FU_TESTIMONIALS_VW")
public class FreeLanceTestimonialsDetailsView implements Serializable {

	private static final long serialVersionUID = 495528534806932352L;


	@Id
	@Column(name = "Id")
	private Integer Id;

	@Column(name = "feedbackby")
	private String feedbackby;

	@Column(name = "starrate")
	private Integer starrate;

	@Column(name = "feedbackon")
	private String feedbackon;

	@Column(name = "feedbackcomment")
	private String feedbackcomment;
	
	@Column(name = "label")
	private String label ;
	
	@Column(name = "avtarurl")
	private String avtarurl ;
	
	@Column(name = "fullname")
	private String fullname ;

	
	public String getAvtarurl() {
		return avtarurl;
	}

	public void setAvtarurl(String avtarurl) {
		this.avtarurl = avtarurl;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
		 


	

	

}

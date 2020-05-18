package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.Immutable;

/**
 * The <code> UserServiceActiveDetailsView </code> class defines managed
 * beans which provides functionality on the
 * <code>User Service Active Details View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callGetFreelancerNotAvbBetweenStartDate",
	query = "CALL getFreelancerAvailableStartDateSP(:jobstarton,:scategory)",
	resultClass = FreelancerAvailableStartDateStoreProc.class
	)
})
@Entity
@Immutable 
public class FreelancerAvailableStartDateStoreProc {

 
	@Id
	@Column(name = "userId")
	private Integer userId;

	@Column(name = "USERNAME")
	private String username;

	
	@Column(name = "FULLNAME")
	private String fullname;
	
	@Column(name = "AVTARURL")
	private String avtarurl;
	
	@Column(name = "SHORTADDRESS")
	private String shortaddress;
	
	@Column(name = "LAT")
	private Float lat;
	
	@Column(name = "LNG")
	private Float lng;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "SUBCATEGORY")
	private String subCategory;
	
	@Column(name = "EXPERIENCEINFIELD")
	private Integer experienceInField;

	@Column(name = "ABT")
	private String abt;

	@Column(name = "HOURLYRATE")
	private Integer hourlyRate;
	
	@Column(name = "feedbackby")
	private String feedBackBy;

	@Column(name = "starrate")
	private Integer starRate;
	
	@Column(name = "feedbackcomment")
	private String feedBackComment;
	
 
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvtarurl() {
		return avtarurl;
	}

	public void setAvtarurl(String avtarurl) {
		this.avtarurl = avtarurl;
	}

	public String getShortaddress() {
		return shortaddress;
	}

	public void setShortaddress(String shortaddress) {
		this.shortaddress = shortaddress;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Integer getExperienceInField() {
		return experienceInField;
	}

	public void setExperienceInField(Integer experienceInField) {
		this.experienceInField = experienceInField;
	}

	public String getAbt() {
		return abt;
	}

	public void setAbt(String abt) {
		this.abt = abt;
	}

	public Integer getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Integer hourlyRate) {
		this.hourlyRate = hourlyRate;
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

	public String getFeedBackComment() {
		return feedBackComment;
	}

	public void setFeedBackComment(String feedBackComment) {
		this.feedBackComment = feedBackComment;
	}

 
	
}

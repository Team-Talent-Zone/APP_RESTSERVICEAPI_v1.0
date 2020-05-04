package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Immutable
@Table(name = "APP_ALL_ACTIVE_NEWSERVICE_VW")
public class AllActiveNewSeviceDetailsView {

 
	@Id
	@Column(name = "ourserviceId")
	private int ourserviceId;

	@Column(name = "category")
	private String category;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "fullcontent")
	private String fullcontent;
	
	@Column(name = "imgurl")
	private String imgurl;
	
	@Column(name = "validPeriodCode")
	private String validPeriodCode; 
	
	@Column(name = "validPeriodLabel")
	private String validPeriodLabel; 

	@Column(name = "amount")
	private Float amount;
	
	@Column(name = "PACKWITHOTHEROURSERVICEID")
	private Integer packwithotherourserviceid;
	
	@Column(name = "SERVICESTARTON")
	private String servicestarton;

	@Column(name = "SERVICEENDON")
	private String serviceendon;

	public int getOurserviceId() {
		return ourserviceId;
	}

	public void setOurserviceId(int ourserviceId) {
		this.ourserviceId = ourserviceId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullcontent() {
		return fullcontent;
	}

	public void setFullcontent(String fullcontent) {
		this.fullcontent = fullcontent;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getValidPeriodCode() {
		return validPeriodCode;
	}

	public void setValidPeriodCode(String validPeriodCode) {
		this.validPeriodCode = validPeriodCode;
	}

	public String getValidPeriodLabel() {
		return validPeriodLabel;
	}

	public void setValidPeriodLabel(String validPeriodLabel) {
		this.validPeriodLabel = validPeriodLabel;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getPackwithotherourserviceid() {
		return packwithotherourserviceid;
	}

	public void setPackwithotherourserviceid(Integer packwithotherourserviceid) {
		this.packwithotherourserviceid = packwithotherourserviceid;
	}

	public String getServicestarton() {
		return servicestarton;
	}

	public void setServicestarton(String servicestarton) {
		this.servicestarton = servicestarton;
	}

	public String getServiceendon() {
		return serviceendon;
	}

	public void setServiceendon(String serviceendon) {
		this.serviceendon = serviceendon;
	} 
	
	
}

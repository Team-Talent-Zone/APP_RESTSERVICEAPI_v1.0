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
@Table(name = "APP_USERSERVICE_ACTIVE_DETAILS_VW")
public class UserServiceActiveDetailsView {

 
	@Id
	@Column(name = "serviceId")
	private int serviceId;

	@Column(name = "ourserviceId")
	private int ourserviceId;

	@Column(name = "category")
	private String category;

	@Column(name = "SERVICESTARTON")
	private String servicestarton;

	@Column(name = "SERVICEENDON")
	private String serviceendon;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ISSERVICEPURCHASED")
	private boolean isservicepurchased;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "fullcontent")
	private String fullcontent;
	
	@Column(name = "imgurl")
	private String imgurl;
	
	@Column(name = "validdays")
	private String validdays; 
	
	@Column(name = "validPeriodLabel")
	private String validPeriodLabel; 

	@Column(name = "amount")
	private Float amount; 
	
	@Column(name = "status")
	private String status; 
	
	@Column(name = "PACKWITHOTHEROURSERVICEID")
	private Integer packwithotherourserviceid;
	
	@Column(name = "CHILDSERVICEPKGSERVICEID")
	private Integer childservicepkgserviceid;
	
	@Column(name = "userId")
	private Integer userid;
	
	@Column(name = "ISSERVICEPACK")
	private boolean isservicepack;
	
	@Column(name = "publishedlinkurl")
	private String publishedlinkurl;
	
	@Column(name = "txnid")
	private String txnid; 
	
	@Column(name = "widgetId")
	private String widgetId; 

	@Column(name = "fullname")
	private String fullname; 
	
	@Column(name = "bizname")
	private String bizname; 
	
	@Column(name = "phoneno")
	private String phoneno; 
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBizname() {
		return bizname;
	}

	public void setBizname(String bizname) {
		this.bizname = bizname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public Integer getChildservicepkgserviceid() {
		return childservicepkgserviceid;
	}

	public void setChildservicepkgserviceid(Integer childservicepkgserviceid) {
		this.childservicepkgserviceid = childservicepkgserviceid;
	}

	public boolean isIsservicepack() {
		return isservicepack;
	}

	public void setIsservicepack(boolean isservicepack) {
		this.isservicepack = isservicepack;
	}

	public int getServiceId() {
		return serviceId; 
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

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

	public String getValiddays() {
		return validdays;
	}

	public void setValiddays(String validdays) {
		this.validdays = validdays;
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

	public String getPublishedlinkurl() {
		return publishedlinkurl;
	}

	public void setPublishedlinkurl(String publishedlinkurl) {
		this.publishedlinkurl = publishedlinkurl;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isIsservicepurchased() {
		return isservicepurchased;
	}

	public void setIsservicepurchased(boolean isservicepurchased) {
		this.isservicepurchased = isservicepurchased;
	}

	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}
	
	
}

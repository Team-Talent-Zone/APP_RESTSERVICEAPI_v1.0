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
 * The <code> UserBizEntity </code> class defines a POJO that provides back-end
 * functionality for the <code>UserDetails</code> pages.
 * 
 * @author Azmiri.
 * @version 1.0
 * 
 */
@Entity(name = "userbizdetails")
@Table(name = "APP_USER_BIZ_DETAILS")
public class UserBizEntity implements Serializable {
	private static final long serialVersionUID = -9018030589046335435L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer Id;

	@Column(insertable = false, updatable = false, name = "userId")
	private int userId;

	@Column(name = "BIZNAME")
	private String bizname;

	@Column(name = "BIZTYPE")
	private String biztype;

	@Column(name = "BIZWEBSITE")
	private String bizwebsite;

	@Column(name = "ABTBIZ")
	private String abtbiz;

	@Column(name = "PURPOSEOFSIGNUP")
	private String purposeofsignup;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "FULLADDRESS")
	private String fulladdress;

	@Column(name = "ROUTE")
	private String route;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "SHORTADDRESS")
	private String shortaddress;
	
	@Column(name = "LAT")
	private Float lat;
	
	@Column(name = "LNG")
	private Float lng;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShortaddress() {
		return shortaddress;
	}

	public void setShortaddress(String shortaddress) {
		this.shortaddress = shortaddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBizname() {
		return bizname;
	}

	public void setBizname(String bizname) {
		this.bizname = bizname;
	}

	public String getBiztype() {
		return biztype;
	}

	public void setBiztype(String biztype) {
		this.biztype = biztype;
	}

	public String getBizwebsite() {
		return bizwebsite;
	}

	public void setBizwebsite(String bizwebsite) {
		this.bizwebsite = bizwebsite;
	}

	public String getAbtbiz() {
		return abtbiz;
	}

	public void setAbtbiz(String abtbiz) {
		this.abtbiz = abtbiz;
	}

	public String getPurposeofsignup() {
		return purposeofsignup;
	}

	public void setPurposeofsignup(String purposeofsignup) {
		this.purposeofsignup = purposeofsignup;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFulladdress() {
		return fulladdress;
	}

	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}
 
	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Float getLng() {
		return lng;
	}
	

} 

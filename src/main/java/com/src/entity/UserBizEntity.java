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

@Entity(name = "userbizdetails")
@Table(name = "userbizdetails")
public class UserBizEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(insertable = false, updatable = false, name = "userid")
	private int userid;
	
	@Column(name = "BIZNAME")
	private String bizname;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "TYPEOFBIZ")
	private String typeofbiz;

	@Column(name = "ABTBIZ")
	private String abtbiz;

	@Column(name = "BIZWEBSITE")
	private String bizwebsite;

	@Column(name = "BIZFULLADDRESS")
	private String bizFullAddress;

	@Column(name = "PURPOSEOFSIGNUP")
	private String purposeofsignup;

	@Column(name = "STREET_NUMBER")
	private String streetNumber;
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ZIPCODE")
	private String zipcode;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "LONGITUDE")
	private String longitude;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "userid", nullable=false)
	@JsonIgnore
	private UserEntity userdetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBizname() {
		return bizname;
	}

	public void setBizname(String bizname) {
		this.bizname = bizname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTypeofbiz() {
		return typeofbiz;
	}

	public void setTypeofbiz(String typeofbiz) {
		this.typeofbiz = typeofbiz;
	}

	public String getAbtbiz() {
		return abtbiz;
	}

	public void setAbtbiz(String abtbiz) {
		this.abtbiz = abtbiz;
	}

	public String getBizwebsite() {
		return bizwebsite;
	}

	public void setBizwebsite(String bizwebsite) {
		this.bizwebsite = bizwebsite;
	}

	public String getBizFullAddress() {
		return bizFullAddress;
	}

	public void setBizFullAddress(String bizFullAddress) {
		this.bizFullAddress = bizFullAddress;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

	public String getPurposeofsignup() {
		return purposeofsignup;
	}

	public void setPurposeofsignup(String purposeofsignup) {
		this.purposeofsignup = purposeofsignup;
	}

	public String getStreetNumber() {
	    return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
	    this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
	    return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
	    this.streetAddress = streetAddress;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
}

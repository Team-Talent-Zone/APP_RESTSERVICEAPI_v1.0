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
 * The <code> FreelancerEntity </code> class defines a POJO that provides
 * back-end functionality for the <code>Free Lancer User</code> pages.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */

@Entity(name = "freeLanceDetails")
@Table(name = "APP_USER_FREELANCEDETAILS")
public class FreeLanceEntity implements Serializable {
	private static final long serialVersionUID = 8431711325791818386L;

	@Id
	@Column(name = "FREELANCEID")
	@GeneratedValue
	private Integer freeLanceId;

	
	@Column(insertable = false, updatable = false, name = "USERID")
	private Integer userId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	@Column(name = "UPLOADVALIDPHOTOIDIMGURL")
	private String uploadValidPhotoidImgUrl;

	@Column(name = "ISBGDONE")
	private boolean isbgdone;
	
	@Column(name = "ISREGFEEDONE")
	private boolean isregfeedone;
	
	@Column(name = "ISPROFILECOMPLETED")
	private boolean isprofilecompleted;
	
	@Column(name = "ISBGSTARTED")
	private boolean isbgstarted;

 
	@Column(name = "SUBCATEGORY")
	private String subCategory;
	
	@Column(name = "subcategorylabel")
	private String subcategorylabel;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "EXPERIENCEINFIELD")
	private Integer experienceInField;

	@Column(name = "ABT")
	private String abt;

	@Column(name = "HOURLYRATE")
	private Integer hourlyRate;
	
	@Column(name = "FUPERCENTAGE")
	private int fupercentage;
	
	@Column(name = "COMPANYPERCENTAGE")
	private int companypercentage;
	
	@Column(name = "BGCURRENTSTATUS")
	private String bgcurrentstatus;
	
	@Column(name = "ACCOUNTNAME")
	private String accountname;

	@Column(name = "ACCOUNTNO")
	private String accountno;

	@Column(name = "IFSC")
	private String ifsc;

	@Column(name = "BENEFICIARYID")
	private Integer beneficiaryid;

	
	public String getSubcategorylabel() {
		return subcategorylabel;
	}

	public void setSubcategorylabel(String subcategorylabel) {
		this.subcategorylabel = subcategorylabel;
	}

	public Integer getFreeLanceId() {
		return freeLanceId;
	}

	public void setFreeLanceId(Integer freeLanceId) {
		this.freeLanceId = freeLanceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUploadValidPhotoidImgUrl() {
		return uploadValidPhotoidImgUrl;
	}

	public void setUploadValidPhotoidImgUrl(String uploadValidPhotoidImgUrl) {
		this.uploadValidPhotoidImgUrl = uploadValidPhotoidImgUrl;
	}

	public boolean isIsbgdone() {
		return isbgdone;
	}

	public void setIsbgdone(boolean isbgdone) {
		this.isbgdone = isbgdone;
	}

	public boolean isIsprofilecompleted() {
		return isprofilecompleted;
	}

	public void setIsprofilecompleted(boolean isprofilecompleted) {
		this.isprofilecompleted = isprofilecompleted;
	}

	public boolean isIsbgstarted() {
		return isbgstarted;
	}

	public void setIsbgstarted(boolean isbgstarted) {
		this.isbgstarted = isbgstarted;
	} 
 
	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
 
	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

	public int getFupercentage() {
		return fupercentage;
	}

	public void setFupercentage(int fupercentage) {
		this.fupercentage = fupercentage;
	}

	public int getCompanypercentage() {
		return companypercentage;
	}

	public void setCompanypercentage(int companypercentage) {
		this.companypercentage = companypercentage;
	}

	public boolean isIsregfeedone() {
		return isregfeedone;
	}

	public void setIsregfeedone(boolean isregfeedone) {
		this.isregfeedone = isregfeedone;
	}

	public String getBgcurrentstatus() {
		return bgcurrentstatus;
	}

	public void setBgcurrentstatus(String bgcurrentstatus) {
		this.bgcurrentstatus = bgcurrentstatus;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Integer getBeneficiaryid() {
		return beneficiaryid;
	}

	public void setBeneficiaryid(Integer beneficiaryid) {
		this.beneficiaryid = beneficiaryid;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	
}
package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> UserServiceActiveDetailsView </code> class defines managed beans
 * which provides functionality on the
 * <code>User Service Active Details View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_FU_ONSERVICE_JOB_POSTED_VW")
public class FreelanceOnServiceJobPostedView {

	@Id
	@Column(name = "jobId")
	private Integer jobId;
	
	@Column(name = "freelanceuserId")
	private Integer freelanceuserId;
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "subcategorylabel")
	private String subcategorylabel;

	@Column(name = "bizname")
	private String bizname;

	@Column(name = "avtarurl")
	private String avtarurl;

	@Column(name = "preferlang")
	private String preferlang;

	@Column(name = "LAT")
	private Float lat;

	@Column(name = "LNG")
	private Float lng;

	@Column(name = "CITY")
	private String city;

	@Column(name = "SUBCATEGORY")
	private String scategory;

	@Column(name = "EXPERIENCEINFIELD")
	private Integer experienceInField;

	@Column(name = "ABT")
	private String abt;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "shortaddress")
	private String shortaddress;

	@Column(name = "jobstartedon")
	private String jobstartedon;

	@Column(name = "jobendedon")
	private String jobendedon;

	@Column(name = "updatedon")
	private String updatedon;

	@Column(name = "totalhoursofjob")
	private Float totalhoursofjob;

	@Column(name = "amount")
	private Float amount;

	@Column(name = "isjobamtpaidtofu")
	private Boolean isjobamtpaidtofu;

	@Column(name = "isjobcompleted")
	private Boolean isjobcompleted;

	@Column(name = "isjobamtpaidtocompany")
	private Boolean isjobamtpaidtocompany;

	@Column(name = "isjobcancel")
	private Boolean isjobcancel;
	
	@Column(name = "isjobaccepted")
	private Boolean isjobaccepted;

	@Column(name = "isjobactive")
	private Boolean isjobactive;

	@Column(name = "joblocation")
	private String joblocation;
	
	@Column(name = "isdeactive")
	private String isdeactive;

	@Column(name = "jobdescription")
	private String jobdescription;

	@Column(name = "tofreelanceamount")
	private String tofreelanceamount;

	@Column(name = "tocompanyamount")
	private String tocompanyamount;

	@Column(name = "isupcoming")
	private String isupcoming;

	@Column(name = "fuphoneno")
	private String fuphoneno;
	
	@Column(name = "cbausername")
	private String cbausername;
	
	@Column(name = "cbafullname")
	private String cbafullname;
	
	@Column(name = "cbaphoneno")
	private String cbaphoneno;
	
	@Column(name = "txnid")
	private String txnid;
	
	@Column(name = "futxnid")
	private String futxnid;
	
	@Column(name = "DIFFINMINS")
	private Boolean diffinmins;
	
	@Column(name = "JOBACCEPTEDDATE")
	private String jobaccepteddate;
	
	@Column(name ="BENEFICIARYID")
	private Integer beneficiaryId;
	
	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public String getFuphoneno() {
		return fuphoneno;
	}

	public void setFuphoneno(String fuphoneno) {
		this.fuphoneno = fuphoneno;
	}

	public String getCbausername() {
		return cbausername;
	}

	public void setCbausername(String cbausername) {
		this.cbausername = cbausername;
	}

	public String getCbafullname() {
		return cbafullname;
	}

	public void setCbafullname(String cbafullname) {
		this.cbafullname = cbafullname;
	}

	public String getCbaphoneno() {
		return cbaphoneno;
	}

	public void setCbaphoneno(String cbaphoneno) {
		this.cbaphoneno = cbaphoneno;
	}

	public Integer getFreelanceuserId() {
		return freelanceuserId;
	}

	public void setFreelanceuserId(Integer freelanceuserId) {
		this.freelanceuserId = freelanceuserId;
	}

	public String getBizname() {
		return bizname;
	}

	public void setBizname(String bizname) {
		this.bizname = bizname;
	}

	public String getAvtarurl() {
		return avtarurl;
	}

	public void setAvtarurl(String avtarurl) {
		this.avtarurl = avtarurl;
	}

	public String getPreferlang() {
		return preferlang;
	}

	public void setPreferlang(String preferlang) {
		this.preferlang = preferlang;
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

	public String getScategory() {
		return scategory;
	}

	public void setScategory(String scategory) {
		this.scategory = scategory;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getShortaddress() {
		return shortaddress;
	}

	public void setShortaddress(String shortaddress) {
		this.shortaddress = shortaddress;
	}

	public String getJobstartedon() {
		return jobstartedon;
	}

	public void setJobstartedon(String jobstartedon) {
		this.jobstartedon = jobstartedon;
	}

	public String getJobendedon() {
		return jobendedon;
	}

	public void setJobendedon(String jobendedon) {
		this.jobendedon = jobendedon;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public Float getTotalhoursofjob() {
		return totalhoursofjob;
	}

	public void setTotalhoursofjob(Float totalhoursofjob) {
		this.totalhoursofjob = totalhoursofjob;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public boolean isIsjobamtpaidtofu() {
		return isjobamtpaidtofu;
	}

	public void setIsjobamtpaidtofu(boolean isjobamtpaidtofu) {
		this.isjobamtpaidtofu = isjobamtpaidtofu;
	}

	public boolean isIsjobcompleted() {
		return isjobcompleted;
	}

	public void setIsjobcompleted(boolean isjobcompleted) {
		this.isjobcompleted = isjobcompleted;
	}

	public boolean isIsjobamtpaidtocompany() {
		return isjobamtpaidtocompany;
	}

	public void setIsjobamtpaidtocompany(boolean isjobamtpaidtocompany) {
		this.isjobamtpaidtocompany = isjobamtpaidtocompany;
	}

	public boolean isIsjobcancel() {
		return isjobcancel;
	}

	public void setIsjobcancel(boolean isjobcancel) {
		this.isjobcancel = isjobcancel;
	}

	public boolean isIsjobactive() {
		return isjobactive;
	}

	public void setIsjobactive(boolean isjobactive) {
		this.isjobactive = isjobactive;
	}

	public String getJoblocation() {
		return joblocation;
	}

	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getTofreelanceamount() {
		return tofreelanceamount;
	}

	public void setTofreelanceamount(String tofreelanceamount) {
		this.tofreelanceamount = tofreelanceamount;
	}

	public String getTocompanyamount() {
		return tocompanyamount;
	}

	public void setTocompanyamount(String tocompanyamount) {
		this.tocompanyamount = tocompanyamount;
	}

	public String getIsupcoming() {
		return isupcoming;
	}

	public void setIsupcoming(String isupcoming) {
		this.isupcoming = isupcoming;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Boolean getIsjobamtpaidtofu() {
		return isjobamtpaidtofu;
	}

	public void setIsjobamtpaidtofu(Boolean isjobamtpaidtofu) {
		this.isjobamtpaidtofu = isjobamtpaidtofu;
	}

	public Boolean getIsjobcompleted() {
		return isjobcompleted;
	}

	public void setIsjobcompleted(Boolean isjobcompleted) {
		this.isjobcompleted = isjobcompleted;
	}

	public Boolean getIsjobamtpaidtocompany() {
		return isjobamtpaidtocompany;
	}

	public void setIsjobamtpaidtocompany(Boolean isjobamtpaidtocompany) {
		this.isjobamtpaidtocompany = isjobamtpaidtocompany;
	}

	public Boolean getIsjobcancel() {
		return isjobcancel;
	}

	public void setIsjobcancel(Boolean isjobcancel) {
		this.isjobcancel = isjobcancel;
	}

	public Boolean getIsjobactive() {
		return isjobactive;
	}

	public void setIsjobactive(Boolean isjobactive) {
		this.isjobactive = isjobactive;
	}

	public Boolean getIsjobaccepted() {
		return isjobaccepted;
	}

	public void setIsjobaccepted(Boolean isjobaccepted) {
		this.isjobaccepted = isjobaccepted;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSubcategorylabel() {
		return subcategorylabel;
	}

	public void setSubcategorylabel(String subcategorylabel) {
		this.subcategorylabel = subcategorylabel;
	}

	public String getIsdeactive() {
		return isdeactive;
	}

	public void setIsdeactive(String isdeactive) {
		this.isdeactive = isdeactive;
	}

	public String getFutxnid() {
		return futxnid;
	}

	public void setFutxnid(String futxnid) {
		this.futxnid = futxnid;
	}

	public Boolean getDiffinmins() {
		return diffinmins;
	}

	public void setDiffinmins(Boolean diffinmins) {
		this.diffinmins = diffinmins;
	}

	public String getJobaccepteddate() {
		return jobaccepteddate;
	}

	public void setJobaccepteddate(String jobaccepteddate) {
		this.jobaccepteddate = jobaccepteddate;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	
	
	
}

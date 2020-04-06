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
 * The <code> widgetLayoutEntity </code> class defines a POJO that provides
 * back-end functionality for the <code>widget Layout Entity</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "widgetLayoutEntity")
@Table(name = "APP_DESIGN_WIDGET_DEFAULT_LAYOUT")
public class WidgetLayoutEntity implements Serializable {

	private static final long serialVersionUID = 3928441475773576313L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(insertable = false, updatable = false, name = "widgetId")
	private int widgetId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "widgetId", nullable = false)
	@JsonIgnore
	private WidgetForServiceEntity widgetEntity;

	@Column(name = "BGIMGURL")
	private String bgimgurl;

	@Column(name = "LOGOURL")
	private String logourl;

	@Column(name = "COMPANYNAME")
	private String companyname;

	@Column(name = "COMPANYIMGURL")
	private String companyimgurl;

	@Column(name = "FOOTERCONTENT")
	private String footercontent;

	@Column(name = "FOOTERCOMPANYADDRESS")
	private String footercompanyaddress;

	@Column(name = "FOOTERICONHREF")
	private String footericonhref;

	@Column(name = "FOOTERICONURL")
	private String footericonurl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}

	public WidgetForServiceEntity getWidgetEntity() {
		return widgetEntity;
	}

	public void setWidgetEntity(WidgetForServiceEntity widgetEntity) {
		this.widgetEntity = widgetEntity;
	}

	public String getBgimgurl() {
		return bgimgurl;
	}

	public void setBgimgurl(String bgimgurl) {
		this.bgimgurl = bgimgurl;
	}

	public String getLogourl() {
		return logourl;
	}

	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyimgurl() {
		return companyimgurl;
	}

	public void setCompanyimgurl(String companyimgurl) {
		this.companyimgurl = companyimgurl;
	}

	public String getFootercontent() {
		return footercontent;
	}

	public void setFootercontent(String footercontent) {
		this.footercontent = footercontent;
	}

	public String getFootercompanyaddress() {
		return footercompanyaddress;
	}

	public void setFootercompanyaddress(String footercompanyaddress) {
		this.footercompanyaddress = footercompanyaddress;
	}

	public String getFootericonhref() {
		return footericonhref;
	}

	public void setFootericonhref(String footericonhref) {
		this.footericonhref = footericonhref;
	}

	public String getFootericonurl() {
		return footericonurl;
	}

	public void setFootericonurl(String footericonurl) {
		this.footericonurl = footericonurl;
	}

}
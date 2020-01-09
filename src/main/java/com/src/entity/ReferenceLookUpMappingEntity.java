package com.src.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "referencelookupmapping")
@Table(name = "APP_REFERENCELOOKUP_MAPPING")
public class ReferenceLookUpMappingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MAPId")
	@GeneratedValue
	private Integer mapId;

	@Column(name = "CODE")
	private String code;

	@Column(name = "KEY")
	private String key;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "SHORTKEY")
	private String shortkey;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refId", nullable = false)
	@JsonIgnore
	private ReferenceLookUpEntity referencelookup;
	
	@Column(insertable = false, updatable = false, name = "refId")
	private int refId;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "referencelookupmapping")
	private Set<ReferenceLookUpMappingSubCategoryEntity> referencelookupmappingsubcategories;

	
	public Set<ReferenceLookUpMappingSubCategoryEntity> getReferencelookupmappingsubcategories() {
		return referencelookupmappingsubcategories;
	}


	public void setReferencelookupmappingsubcategories(
			Set<ReferenceLookUpMappingSubCategoryEntity> referencelookupmappingsubcategories) {
		this.referencelookupmappingsubcategories = referencelookupmappingsubcategories;
	}


	public ReferenceLookUpEntity getReferencelookup() {
		return referencelookup;
	}


	public void setReferencelookup(ReferenceLookUpEntity referencelookup) {
		this.referencelookup = referencelookup;
	}


	public int getRefId() {
		return refId;
	}


	public void setRefId(int refId) {
		this.refId = refId;
	}


	public Integer getMapId() {
		return mapId;
	}


	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getShortkey() {
		return shortkey;
	}

	public void setShortkey(String shortkey) {
		this.shortkey = shortkey;
	}

}
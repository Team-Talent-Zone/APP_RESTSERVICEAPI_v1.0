package com.src.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "referencelookup")
@Table(name = "APP_REFERENCELOOKUP")
public class ReferenceLookUpEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "REFId")
	@GeneratedValue
	private Integer refId;

	@Column(name = "CODE")
	private String code;

	@Column(name = "KEY")
	private String key;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "SHORTKEY")
	private String shortkey;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "referencelookup")
	private Set<ReferenceLookUpMappingEntity> referencelookupmapping;


	public Set<ReferenceLookUpMappingEntity> getReferencelookupmapping() {
		return referencelookupmapping;
	}

	public void setReferencelookupmapping(Set<ReferenceLookUpMappingEntity> referencelookupmapping) {
		this.referencelookupmapping = referencelookupmapping;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
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
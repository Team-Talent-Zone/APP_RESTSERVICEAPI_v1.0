package com.src.service;

import java.util.ArrayList;

import com.src.entity.ReferenceLookUpEntity;
import com.src.entity.ReferenceLookUpMappingEntity;
import com.src.entity.ReferenceLookUpMappingSubCategoryEntity;
import com.src.entity.ReferenceLookUpTemplateEntity;

/**
 * The <code> ReferenceLookUpService </code> interface is Reference Lookup Service
 * Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
public interface ReferenceLookUpService {

	/**
	 * To Get Reference Lookup by key.
	 * 
	 * @param key
	 */
	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key);

	/**
	 * To get All Reference Lookup Data.
	 * 
	 */
	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData();

	/**
	 * To get Reference Lookup by Short key.
	 * 
	 * @param shortkey
	 */
	public String getReferenceLookupByShortKey(String shortkey);

	/**
	 * To get Reference Lookup MApping by Ref Id.
	 * 
	 * @param refId
	 */
	public ArrayList<ReferenceLookUpMappingEntity> getReferenceLookupMappingByRefId(int refId);

	/**
	 * To get Reference Lookup Mapping Sub Category By Mapid.
	 * 
	 * @param mapId
	 */
	public ArrayList<ReferenceLookUpMappingSubCategoryEntity> getReferenceLookupMappingSubCategoryByMapId(int mapId);

	/**
	 * To get Lookup Template Entity by Short key
	 * 
	 * @param shortkey
	 */
	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey);
	
	public ReferenceLookUpMappingSubCategoryEntity getReferenceLookupMappingSubCategoryByCode(String code);


}

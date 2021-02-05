package com.src.dao;

import java.util.ArrayList;

import com.src.entity.ReferenceLookUpEntity;
import com.src.entity.ReferenceLookUpMappingEntity;
import com.src.entity.ReferenceLookUpMappingSubCategoryEntity;
import com.src.entity.ReferenceLookUpTemplateEntity;

/**
 * This <code>ReferenceLookUpDAOImpl </code>Interface is written to get
 * Reference Lookup Details.
 * 
 * @author Ishaq.
 *
 */
public interface ReferenceLookUpDAO {

	/**
	 * This method is to get Reference Lookup details by key.
	 * 
	 * @param key
	 */
	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key);

	/**
	 * This method is to get Reference Lookup details.
	 * 
	 */
	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData();

	/**
	 * This method is to get Reference Lookup details by shortkey.
	 * 
	 * @param refId
	 */
	public String getReferenceLookupByShortKey(String shortkey);

	/**
	 * This method is to get Reference Lookup details by ref id.
	 * 
	 * @param refId
	 */
	public ArrayList<ReferenceLookUpMappingEntity> getReferenceLookupMappingByRefId(int refId);

	/**
	 * This method is to get Reference Lookup details by sub Category Map id.
	 * 
	 * @param mapId
	 */
	public ArrayList<ReferenceLookUpMappingSubCategoryEntity> getReferenceLookupMappingSubCategoryByMapId(int mapId);

	/**
	 * This method is to get Lookup Template details by short key.
	 * 
	 * @param shortkey
	 */
	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey);

	/**
	 * This method is to get Lookup Sub Category details by code .
	 * 
	 * @param shortkey
	 */
	public ReferenceLookUpMappingSubCategoryEntity getReferenceLookupMappingSubCategoryByCode(String code);

}
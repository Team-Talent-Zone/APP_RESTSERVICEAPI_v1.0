package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.ReferenceLookUpEntity;
import com.src.entity.ReferenceLookUpMappingEntity;
import com.src.entity.ReferenceLookUpMappingSubCategoryEntity;
import com.src.entity.ReferenceLookUpTemplateEntity;

/**
 * The <code> ReferenceLookUpServiceImpl </code> class defines Reference Lookup
 * Service Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Service("referenceLookUpManager")
@Transactional(rollbackFor = { Exception.class })
public class ReferenceLookUpServiceImpl extends AbstractServiceManager implements ReferenceLookUpService {

	/**
	 * To get Reference lookup by KEY Details.
	 */
	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key) {
		return referenceLookUpDAO.getReferenceLookupByKey(key);
	}

	/**
	 * To get all Reference Lookup Data Details.
	 */
	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData() {
		return referenceLookUpDAO.getAllReferenceLookupData();
	}

	/**
	 * To get Reference Lookup Short Key Details.
	 */
	public String getReferenceLookupByShortKey(String shortkey) {
		return referenceLookUpDAO.getReferenceLookupByShortKey(shortkey);
	}

	/**
	 * To get Reference Lookup Mapping by RefId.
	 */
	public ArrayList<ReferenceLookUpMappingEntity> getReferenceLookupMappingByRefId(int refId) {
		return referenceLookUpDAO.getReferenceLookupMappingByRefId(refId);
	}

	/**
	 * To get REference Lookup Mapping Sub category by Map id details.
	 */
	public ArrayList<ReferenceLookUpMappingSubCategoryEntity> getReferenceLookupMappingSubCategoryByMapId(int mapId) {
		return referenceLookUpDAO.getReferenceLookupMappingSubCategoryByMapId(mapId);
	}

	/**
	 * To get Lookup Template Entity by Short Key Details.
	 */
	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey) {
		return referenceLookUpDAO.getLookupTemplateEntityByShortkey(shortkey);
	}
	
	/**
	 * To get REference Lookup Mapping Sub category by Code details.
	 */
	public ReferenceLookUpMappingSubCategoryEntity getReferenceLookupMappingSubCategoryByCode(String code) {
		return referenceLookUpDAO.getReferenceLookupMappingSubCategoryByCode(code);
	}
}

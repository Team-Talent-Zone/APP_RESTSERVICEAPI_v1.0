package com.src.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.ReferenceLookUpEntity;
import com.src.entity.ReferenceLookUpMappingEntity;
import com.src.entity.ReferenceLookUpMappingSubCategoryEntity;
import com.src.entity.ReferenceLookUpTemplateEntity;
import com.src.entity.ReferenceStaticDataEntity;

@Service("referenceLookUpManager")
@Transactional(rollbackFor = { Exception.class })
public class ReferenceLookUpServiceImpl extends AbstractServiceManager implements ReferenceLookUpService {

	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key) {
		return referenceLookUpDAO.getReferenceLookupByKey(key);
	}

	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData() {
		return referenceLookUpDAO.getAllReferenceLookupData();
	}

	public String getReferenceLookupByShortKey(String shortkey) {
		return referenceLookUpDAO.getReferenceLookupByShortKey(shortkey);
	}

	public ArrayList<ReferenceLookUpMappingEntity> getReferenceLookupMappingByRefId(int refId) {
		return referenceLookUpDAO.getReferenceLookupMappingByRefId(refId);
	}

	public ArrayList<ReferenceLookUpMappingSubCategoryEntity> getReferenceLookupMappingSubCategoryByMapId(int mapId) {
		return referenceLookUpDAO.getReferenceLookupMappingSubCategoryByMapId(mapId);
	}

	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey) {
		return referenceLookUpDAO.getLookupTemplateEntityByShortkey(shortkey);
	}

	public ArrayList<ReferenceStaticDataEntity> getLookupStaticDataEntityBykey(String key) {
		return referenceLookUpDAO.getLookupStaticDataEntityBykey(key);
	}

	public ArrayList<ReferenceStaticDataEntity> getLookupStaticDataEntity(String targetLanguage) throws IOException {
		return referenceLookUpDAO.getLookupStaticDataEntity();
	}

}

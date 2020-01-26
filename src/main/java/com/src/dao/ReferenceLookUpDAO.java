package com.src.dao;

import java.util.ArrayList;

import com.src.entity.ReferenceLookUpEntity;
import com.src.entity.ReferenceLookUpMappingEntity;
import com.src.entity.ReferenceLookUpMappingSubCategoryEntity;
import com.src.entity.ReferenceLookUpTemplateEntity;
import com.src.entity.ReferenceStaticDataEntity;

public interface ReferenceLookUpDAO {

	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key);

	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData();

	public String getReferenceLookupByShortKey(String shortkey);

	public ArrayList<ReferenceLookUpMappingEntity> getReferenceLookupMappingByRefId(int refId);

	public ArrayList<ReferenceLookUpMappingSubCategoryEntity> getReferenceLookupMappingSubCategoryByMapId(int mapId);

	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey);

	public ArrayList<ReferenceStaticDataEntity> getLookupStaticDataEntityBykey(String key);

	public ArrayList<ReferenceStaticDataEntity> getLookupStaticDataEntity();

}
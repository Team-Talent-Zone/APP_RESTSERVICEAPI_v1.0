package com.src.dao;

import java.util.ArrayList;

import com.src.entity.ReferenceLookUpEntity;

public interface ReferenceLookUpDAO {

	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key);

	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData();

	public ReferenceLookUpEntity getReferenceLookupByShortKey(String shortkey);
}
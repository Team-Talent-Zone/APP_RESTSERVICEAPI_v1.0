package com.src.service;

import java.util.ArrayList;

import com.src.entity.ReferenceLookUpEntity;

public interface ReferenceLookUpService {

	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key);

	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData();

}

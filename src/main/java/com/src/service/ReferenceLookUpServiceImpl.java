package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.ReferenceLookUpEntity;

@Service("referenceLookUpManager")
@Transactional(rollbackFor = { Exception.class })
public class ReferenceLookUpServiceImpl extends AbstractServiceManager implements ReferenceLookUpService {

	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key) {
		return referenceLookUpDAO.getReferenceLookupByKey(key);
	}

	@Override
	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData() {
		return referenceLookUpDAO.getAllReferenceLookupData();
	}

}

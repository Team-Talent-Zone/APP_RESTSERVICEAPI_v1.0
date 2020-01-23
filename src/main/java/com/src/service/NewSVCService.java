package com.src.service;

import java.util.ArrayList;

import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;

/**
 * The <code> NewSVCService </code> interface defines a business service for
 * retrieving <code>New Service</code>.
 * 
 * @author Shanoor
 *
 */
public interface NewSVCService {

	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity);

	public NewServiceEntity saveOrUpdateNewService(NewServiceEntity newServiceEntity);
	
	public NewServiceHistoryEntity saveNewServiceHistory (NewServiceHistoryEntity newServiceHistoryEntity);
	
	public NewServicePackageEntity saveNewServicePackage (NewServicePackageEntity newServicePackageEntity);
	
	public ArrayList<NewServiceEntity> getAllServiceDetails();
}

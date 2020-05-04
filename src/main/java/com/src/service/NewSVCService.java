package com.src.service;

import java.util.ArrayList;

import com.src.entity.AllActiveNewSeviceDetailsView;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;

/**
 * The <code> NewSVCService </code> interface defines a business service for
 * retrieving <code>New Service</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface NewSVCService {

	/**
	 * To save New Service details.
	 * 
	 * @param newServiceEntity
	 * @return
	 */
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity);

	/**
	 * To Edit and Save (update) the New Service Details.
	 * 
	 * @param newServiceEntity
	 * @return
	 */
	public NewServiceEntity saveOrUpdateNewService(NewServiceEntity newServiceEntity);

	/**
	 * To save New Service History Details.
	 * 
	 * @param newServiceHistoryEntity
	 * @return
	 */
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity);

	
	
	/**
	 * To save Service Package Details.
	 * 
	 * @param newServicePackageEntity
	 * @return
	 */
	public ArrayList<NewServicePackageEntity> saveNewServicePackage(
			ArrayList<NewServicePackageEntity> newServicePackageEntity);

	/**
	 * To Get the all Service Details.
	 * 
	 * @return
	 */
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails();
	
	/**
	 * To check if the service name is exist by passing service name.
	 * 
	 * @return
	 */
	public boolean checkNewServiceIsExist(String servicename);
	
	/**
	 * To Get the all Service Details by service id.
	 * 
	 * @return
	 */
	public NewServiceEntity getNewServiceDetailsByServiceId(int ourserviceId);


	/**
	 * Get All New Service Details by managerId.
	 * 
	 * @param managerId
	 */
	public ArrayList<NewServiceHistoryEntity> getAllNewServiceDetailsByManagerId(int managerId);

	/**
	 * Get All New Service Details by userId.
	 * 
	 * @param userId
	 */
	public ArrayList<NewServiceHistoryEntity> getAllNewServiceDetailsByUserId(int userId);

	/**
	 * To get New Service Details Created.
	 */
	public ArrayList<NewServiceEntity> getNewServiceDetailsCreated();
}

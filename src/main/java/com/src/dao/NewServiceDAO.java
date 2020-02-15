
 package com.src.dao;

import java.util.ArrayList;

import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;

/**
 * The <code> NewServiceDAO </code> interface defines a data access object for
 * retrieving <code>NewService</code>.
 * 
 * @author Shanoor
 *
 */
public interface NewServiceDAO {

	/**
	 * To save New Service details.
	 * 
	 * @param newServiceEntity
	 * @return
	 */
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity);

	/**
	 * To save or Update the New Service Details.
	 * 
	 * @param newServiceEntity
	 */
	public void saveOrUpdateNewService(NewServiceEntity newServiceEntity);

	/**
	 * To save the New Service History Details.
	 * 
	 * @param newServiceHistoryEntity
	 * @return
	 */
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity);

	/**
	 * To Save the New Service Package Details.
	 * 
	 * @param newServicePackageEntity
	 * @return
	 */
	public NewServicePackageEntity saveNewServicePackage(NewServicePackageEntity newServicePackageEntity);

	/**
	 * To get All Service Details.
	 * 
	 * @return
	 */
	public ArrayList<NewServiceEntity> getAllServiceDetails();

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
	 * To get All Service Details which create a day back.
	 * 
	 * @return
	 */
	public ArrayList<NewServiceEntity> getNewServiceDetailsCreated();

}
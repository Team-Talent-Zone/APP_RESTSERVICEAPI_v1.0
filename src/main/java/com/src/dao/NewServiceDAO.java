
package com.src.dao;

import java.util.ArrayList;

import com.src.entity.AllActiveNewSeviceDetailsView;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;

/**
 * The <code> NewServiceDAO </code> interface defines a data access object for
 * retrieving <code>NewService</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface NewServiceDAO {

	/**
	 * To save New Service details.
	 * 
	 * @param newServiceEntity
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
	 */
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity);

 
	/**
	 * To get All Service Details.
	 * 
	 */
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails();

	/**
	 * To get All Service Details.
	 * 
	 */
	public ArrayList<NewServiceEntity> getAllNewServices();

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
	 */
	public ArrayList<NewServiceEntity> getNewServiceDetailsCreated();

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

}
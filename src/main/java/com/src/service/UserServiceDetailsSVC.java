package com.src.service;

import java.util.ArrayList;

import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceEventHistoryEntity;
import com.src.entity.UserServiceNotfications;

/**
 * The <code> UserServiceDetailsService </code> interface defines a business
 * service for retrieving <code>User Service Details.</code>.
 * 
 * @author Shanoor
 * @version 1.0.
 *
 */
public interface UserServiceDetailsSVC {

	/**
	 * To save User Service Details.
	 * 
	 * @param UserServiceDetailsEntity
	 * @return
	 */
	public UserServiceDetailsEntity saveUserServiceDetails(UserServiceDetailsEntity userServiceDetailsEntity);

	/**
	 * To save New User Service History Details.
	 * 
	 * @param newServiceHistoryEntity
	 * @return
	 */
	public UserServiceEventHistoryEntity saveUserServiceEventHistory(UserServiceEventHistoryEntity eventHistoryEntity);

	/**
	 * To edit and update the user Service details.
	 * 
	 * @param userServiceDetailsEntity
	 * @return
	 */
	public UserServiceDetailsEntity saveOrUpdateUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity);

	/**
	 * Get the User Service Details by UserId.
	 * 
	 * @param userId
	 */
	public UserServiceDetailsEntity getUserServiceDetailsByUserId(int userId);

	/**
	 * Get the User Service Details by serviceId.
	 * 
	 * @param serviceId
	 */
	public UserServiceDetailsEntity getUserServiceDetailsByServiceId(int serviceId);

	/**
	 * To Get the all User Service Details.
	 * 
	 * @return Get All User Service Details.
	 */
	public ArrayList<UserServiceDetailsEntity> getAllUserServiceDetails();


	/**
	 * To save User Service Notificaton.
	 * 
	 * @param saveUserServiceNotification
	 * @return
	 */
	public UserServiceNotfications saveUserServiceNotification(UserServiceNotfications userServiceNotfication);

	/**
	 * To get user Service Pending payments.
	 */
	public ArrayList<UserServiceDetailsEntity> getUserServicePendingPayment();
	
	
	/**
	 * To delete the User Service Details.
	 */
	public boolean deleteUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity);
	

}

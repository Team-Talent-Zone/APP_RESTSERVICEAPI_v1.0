package com.src.dao;

import java.util.ArrayList;

import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceExpirationDetailsView;
import com.src.entity.UserServiceNotfications;
import com.src.entity.UserServiceNotificationDetailsView;

/**
 * The <code> UserServiceDetailsDAO </code> interface defines a data access
 * object for retrieving <code>User Service Details</code>.
 * 
 * @author Shanoor
 *
 */
public interface UserServiceDetailsDAO {

	/**
	 * To save User Service Details.
	 * 
	 * @param UserServiceDetailsEntity
	 * @return
	 */
	public UserServiceDetailsEntity saveUserServiceDetails(UserServiceDetailsEntity userServiceDetailsEntity);

	/**
	 * To edit and update the user Service details.
	 * 
	 * @param userServiceDetailsEntity
	 * @return
	 */
	public void saveOrUpdateUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity);

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
	
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails();

	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId);

}

package com.src.dao;

import java.util.ArrayList;

import com.src.entity.AllBellNotificationsView;
import com.src.entity.UserServiceActiveDetailsView;
import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceEventHistoryEntity;
import com.src.entity.UserServiceExpirationDetailsView;
import com.src.entity.UserServiceNotfications;
import com.src.entity.UserServiceNotificationDetailsView;

/**
 * The <code> UserServiceDetailsDAO </code> interface defines a data access
 * object for retrieving <code>User Service Details</code>.
 * 
 * @author Shanoor
 * @version 1.0
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
	 * To save User Service Event History Details.
	 * 
	 * @param UserServiceEventHistoryEntity
	 * @return
	 */
	public void saveUserServiceEventHistory(UserServiceEventHistoryEntity eventHistoryEntity);

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
	 */
	public UserServiceNotfications saveUserServiceNotification(UserServiceNotfications userServiceNotfication);

	/**
	 * To get the User Expiration Details Notification.
	 */
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails();

	/**
	 * To get the User Service Details Notification by User id.
	 * 
	 * @param userId
	 */
	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId);

	/**
	 * To get the User Service Details Pending Payments Notification.
	 */
	public ArrayList<UserServiceDetailsEntity> getUserServicePendingPayment();

	/**
	 * To get the User Service Details by userId.
	 */
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsByUserId(int userId);
	
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsView();

	/**
	 * To delete the User Service Details.
	 */
	public void deleteUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity);

	/**
	 * To get all bell notifications by userId.
	 */
	public ArrayList<AllBellNotificationsView> getAllBellNotifications(int userId , String visibility);
	
	/**
	 * To get all bell notifications.
	 */
	public ArrayList<AllBellNotificationsView> getAllAdminBellNotifications(String roleCode);
}

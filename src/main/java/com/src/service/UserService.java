package com.src.service;

import java.util.ArrayList;

import com.src.entity.FreeLanceDocumentsEntity;
import com.src.entity.FreeLanceHistoryEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserNotificationDetailsView;
import com.src.entity.UserNotificationEntity;

/**
 * The <code> UserService </code> interface defines a business service for
 * retrieving <code>UserDetails</code>.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
public interface UserService {

	/**
	 * Get the User Details by UserName.
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity findByUsername(String username, String password);

	/**
	 * Save the User Details.
	 * 
	 * @param userEntityObject
	 * @return
	 */
	public UserEntity saveUser(UserEntity userEntity);

	/**
	 * Save the User Notification Details.
	 * 
	 * @param userNotificationEntity
	 * @return
	 */
	public UserNotificationEntity saveUserNotification(UserNotificationEntity userNotificationEntity);

	/**
	 * Get All User Details from the List.
	 * 
	 */
	public ArrayList<UserEntity> getAllUsers();

	/**
	 * Get User Details by the Role.
	 * 
	 * @param role
	 */
	public ArrayList<UserEntity> getUsersByRole(String role);

	/**
	 * Update or Edit on user Details Screen.
	 * 
	 * @param userEntityObj
	 */
	public UserEntity saveorupdateUserDetails(UserEntity userEntity);

	/**
	 * Get the User Details by UserId.
	 * 
	 * @param userId
	 */
	public UserEntity getUserByUserId(int userId);

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 * @throws Exception
	 */
	public UserEntity checkUsername(String username);

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 * @throws Exception
	 */
	public boolean checkUsernameNotExist(String username);

	/**
	 * Helps in password recovery.
	 * 
	 * @param username
	 * @throws Exception
	 */
	public UserEntity forgetPassword(String username);

	/**
	 * Gets all the user details if isrecoverypwd is true
	 * 
	 */
	public ArrayList<UserEntity> getUserByRecoveryPwd();

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<UserEntity> getUserDetailsByJobAvailable();

	/**
	 * Gets all the freelancer user details when incomplete profile
	 * 
	 * 
	 */
	public ArrayList<UserEntity> getFUUserDetailsWhenInCompleteProfile();

	/**
	 * Gets all the notification details based on the user Id
	 * 
	 * @param userId
	 * 
	 */
	public ArrayList<UserNotificationDetailsView> getNotificationDetailsByUserId(int userId);
	
	public FreeLanceHistoryEntity saveFreeLanceHistory(FreeLanceHistoryEntity freeLanceHistoryEntity);
	
	public FreeLanceDocumentsEntity saveFreeLanceDocument(FreeLanceDocumentsEntity freeLanceDocumentsEntity);
	
	public UserEntity prepareAdminToSignUp(String username);

}

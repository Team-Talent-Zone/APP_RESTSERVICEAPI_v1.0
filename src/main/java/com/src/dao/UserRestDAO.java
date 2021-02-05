package com.src.dao;

import java.util.ArrayList;

import com.src.entity.FreeLanceDocumentsEntity;
import com.src.entity.FreeLanceHistoryEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserNotificationEntity;

/**
 * The <code> UserRestDAO </code> interface defines a data access object for
 * retrieving <code>UserDetails</code>.
 * 
 * @author Azmiri.
 * @version 1.0
 * 
 */
public interface UserRestDAO {

	/**
	 * Get the User Details by UserName.
	 * 
	 * @param username
	 */
	public UserEntity findByUsername(String username);

	/**
	 * Save the User Details.
	 * 
	 * @param userEntityObject
	 */
	public UserEntity saveUser(UserEntity userEntity);

	/**
	 * Save the User Notification Details.
	 * 
	 * @param userNotificationEntity
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
	public void saveorupdateUserDetails(UserEntity userEntity);

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
	 */
	public UserEntity checkUsername(String username);

	/**
	 * Gives the user details.
	 */
	public ArrayList<UserEntity> getUserByRecoveryPwd();

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 */
	public boolean checkUsernameNotExist(String username);

	/**
	 * Gets all the freelance user details when incomplete profile
	 */
	public ArrayList<UserEntity> getFUUserDetailsWhenInCompleteProfile();


	/**
	 * To Save Free Lancer History Details.
	 * 
	 * @param FreeLanceHistoryEntity freeLanceHistoryEntity
	 * @return freeLanceHistoryEntity
	 */
	public FreeLanceHistoryEntity saveFreeLanceHistory(FreeLanceHistoryEntity freeLanceHistoryEntity);

	/**
	 * To Save Free Lancer Document Details.
	 * 
	 * @param FreeLanceHistoryEntity freeLanceHistoryEntity
	 * @return freeLanceHistoryEntity
	 */
	public FreeLanceDocumentsEntity saveFreeLanceDocument(FreeLanceDocumentsEntity freeLanceDocumentsEntity);

}
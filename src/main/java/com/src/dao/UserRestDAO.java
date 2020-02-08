package com.src.dao;

import java.util.ArrayList;

import com.src.entity.FreelanceEntity;
import com.src.entity.UserEntity;

/**
 * The <code> UserRestDAO </code> interface defines a data access object for
 * retrieving <code>UserDetails</code>.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
public interface UserRestDAO {

	/**
	 * Get the User Details by UserName.
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity findByUsername(String username);

	/**
	 * Save the User Details.
	 * 
	 * @param userEntityObject
	 * @return
	 */
	public UserEntity saveUser(UserEntity userEntity);

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
	 * @throws Exception
	 */
	public UserEntity checkUsername(String username);

	/**
	 * Gives the user details.
	 * 
	 * @param isrecoverypwd
	 * @return
	 */
	public ArrayList<UserEntity> getUserByRecoveryPwd(Boolean isrecoverypwd);

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 * @throws Exception
	 */
	public boolean checkUsernameNotExist(String username);

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelanceEntity> getUserDetailsByJobAvailable(Boolean isJobAvailable);

}
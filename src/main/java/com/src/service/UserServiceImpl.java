package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.UserConstant;
import com.src.entity.UserEntity;
import com.src.utils.CommonUtilites;

/**
 * The <code> UserServiceImpl </code> class provides the implementation for the
 * <code>UserDetails</code> related business interface.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
@Service(UserConstant.USER_MANAGER)
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl extends AbstractServiceManager implements UserService {

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 */
	public UserEntity checkUsername(String username) {
		return userRestDAO.checkUsername(username);
	}

	/**
	 * Get the User Details by UserId.
	 * 
	 * @param userId
	 */
	public UserEntity getUserByUserId(int userId) {
		return userRestDAO.getUserByUserId(userId);
	}

	/**
	 * Save the User Details.
	 * 
	 * @param userEntityObject
	 * @return
	 */

	public UserEntity saveUser(UserEntity userEntity) {
		userEntity.setIsactive(Boolean.FALSE);
		userEntity.setIsrecoverypwd(Boolean.FALSE);
	    userEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
		userEntity.setCreatedby(CommonUtilites.getCurrentDateInNewFormat());
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		return userRestDAO.saveUser(userEntity);
	}

	/**
	 * Get All User Details from the List.
	 * 
	 */
	public ArrayList<UserEntity> getAllUsers() {
		return userRestDAO.getAllUsers();
	}

	/**
	 * Get User Details by the Role.
	 * 
	 * @param role
	 */
	public ArrayList<UserEntity> getUsersByRole(String role) {
		return userRestDAO.getUsersByRole(role);
	}

	/**
	 * Update or Edit on user Details Screen.
	 * 
	 * @param userEntityObj
	 */
	public UserEntity saveorupdateUserDetails(UserEntity userEntity) {
		userRestDAO.saveorupdateUserDetails(userEntity);
		return userEntity;
	}

	/**
	 * Get the User Details by UserName.
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity findByUsername(String username) {
		return userRestDAO.findByUsername(username);
	}

}

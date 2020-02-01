package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.UserConstant;
import com.src.entity.FreelanceEntity;
import com.src.entity.FreelancehistoryEntity;
import com.src.entity.UserBizEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserRoleEntity;
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
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 */
	public Boolean checkUsernameNotExist(String username) {
		return userRestDAO.checkUsernameNotExist(username);
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
		//userEntity.setCreatedby(CommonUtilites.getCurrentDateInNewFormat());
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		userEntity.setUpdatedon(CommonUtilites.getCurrentDate());

		UserRoleEntity userRoleEntity = userEntity.getUserroles();
		UserBizEntity userBizEntity = userEntity.getUserbizdetails();

		if (userRoleEntity.getRolecode().equals(UserConstant.FREELANCER_USER)) {

			FreelanceEntity freelanceentity = userEntity.getFreeLanceDetails();
			FreelancehistoryEntity freelancehistoryEntity = userEntity.getFreelancehistoryentity();

			freelanceentity.setJobAvailable(Boolean.FALSE);
			freelanceentity.setBgDone(Boolean.FALSE);
			freelanceentity.setBgStarted(Boolean.FALSE);
			freelancehistoryEntity.setLocked(Boolean.FALSE);

			freelanceentity.setUserdetails(userEntity);
			userEntity.setFreeLanceDetails(freelanceentity);
			freelancehistoryEntity.setUserdetails(userEntity);
			userEntity.setFreelancehistoryentity(freelancehistoryEntity);
		}

		userRoleEntity.setUserdetails(userEntity);
		userEntity.setUserroles(userRoleEntity);

		userBizEntity.setUserdetails(userEntity);
		userEntity.setUserbizdetails(userBizEntity);

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

		//Below IF condition is written for forgetPassword recovery 
		if (userEntity.isIsrecoverypwd()) {
			userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		}

		userEntity.setUpdatedon(CommonUtilites.getCurrentDate());
		UserRoleEntity userRoleEntity = userEntity.getUserroles();
		UserBizEntity userBizEntity = userEntity.getUserbizdetails();

		if (userRoleEntity.getRolecode().equals(UserConstant.FREELANCER_USER)) {

			FreelanceEntity freelanceentity = userEntity.getFreeLanceDetails();
			FreelancehistoryEntity freelancehistoryEntity = userEntity.getFreelancehistoryentity();

			freelanceentity.setUserdetails(userEntity);
			userEntity.setFreeLanceDetails(freelanceentity);
			freelancehistoryEntity.setUserdetails(userEntity);
			userEntity.setFreelancehistoryentity(freelancehistoryEntity);
		}

		userRoleEntity.setUserdetails(userEntity);
		userEntity.setUserroles(userRoleEntity);

		userBizEntity.setUserdetails(userEntity);
		userEntity.setUserbizdetails(userBizEntity);

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

	/**
	 * Helps in setting new password.
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity forgetPassword(String username) {

		UserEntity userEntity = userRestDAO.checkUsername(username);
		String newPassword = CommonUtilites.genRandomAlphaNumeric();
		userEntity.setIsrecoverypwd(Boolean.TRUE);
		userEntity.setUpdatedon(CommonUtilites.getCurrentDate());
		userEntity.setPassword(encoder.encode(newPassword));

		return userEntity;
	}

}

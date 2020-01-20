package com.src.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

		Set<UserRoleEntity> userRoleEntities = new HashSet<UserRoleEntity>();
		Set<FreelanceEntity> freelanceEntities = new HashSet<FreelanceEntity>();
		Set<FreelancehistoryEntity> freelancehistoryEntities = new HashSet<FreelancehistoryEntity>();

		for (UserRoleEntity userRoleEntity : userEntity.getUserroles()) {

			if (userRoleEntity.getRolecode().equals("FREELANCER_USER")) {

				for (FreelanceEntity freelanceentity : userEntity.getFreeLanceDetails()) {

					freelanceentity.setJobAvailable(Boolean.FALSE);
					freelanceentity.setBgDone(Boolean.FALSE);
					freelanceentity.setBgStarted(Boolean.FALSE);

					freelanceEntities.add(freelanceentity);
					freelanceentity.setUserdetails(userEntity);
				}

				for (FreelancehistoryEntity freelancehistoryEntity : userEntity.getFreelancehistoryentity()) {

					freelancehistoryEntity.setLocked(Boolean.FALSE);
					freelancehistoryEntities.add(freelancehistoryEntity);
					freelancehistoryEntity.setUserdetails(userEntity);
				}

			}
			userRoleEntities.add(userRoleEntity);
			userRoleEntity.setUserdetails(userEntity);
		}

		Set<UserBizEntity> userBizEntities = new HashSet<UserBizEntity>();
		for (UserBizEntity userBizEntity : userEntity.getUserbizdetails()) {
			userBizEntities.add(userBizEntity);
			userBizEntity.setUserdetails(userEntity);
		}

		userEntity.setUserroles(userRoleEntities);
		userEntity.setUserbizdetails(userBizEntities);
		userEntity.setFreeLanceDetails(freelanceEntities);
		userEntity.setFreelancehistoryentity(freelancehistoryEntities);

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

package com.src.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.UserConstant;
import com.src.entity.FreeLanceDocumentsEntity;
import com.src.entity.FreeLanceEntity;
import com.src.entity.FreeLanceHistoryEntity;
import com.src.entity.UserBizEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserManagerDetailsEntity;
import com.src.entity.UserNotificationDetailsView;
import com.src.entity.UserNotificationEntity;
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
	public boolean checkUsernameNotExist(String username) {
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

		userEntity.setIsrecoverypwd(Boolean.FALSE);
		userEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		userEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
		userEntity.setFullname(userEntity.getFirstname() + " " + userEntity.getLastname());
		UserRoleEntity userRoleEntity = userEntity.getUserroles();
		UserBizEntity userBizEntity = userEntity.getUserbizdetails();
		userBizEntity.setAccepteditprofileterms(Boolean.FALSE);
		userBizEntity.setAcceptsignupterms(Boolean.TRUE);
		if (userRoleEntity.getRolecode().equals(UserConstant.FREELANCER_USER)) {
			userEntity.setIsactive(Boolean.FALSE);
			FreeLanceEntity freelanceentity = userEntity.getFreeLanceDetails();
			Set<FreeLanceHistoryEntity> freeLanceHistoryEntities = new HashSet<FreeLanceHistoryEntity>();
			for (FreeLanceHistoryEntity entity : userEntity.getFreelancehistoryentity()) {
				entity.setIslocked(Boolean.FALSE);
				freeLanceHistoryEntities.add(entity);
				entity.setUserdetails(userEntity);
			}
			if (userEntity.getFreelancedocumententity() != null) {
				Set<FreeLanceDocumentsEntity> freeLanceDocumentEntities = new HashSet<FreeLanceDocumentsEntity>();
				for (FreeLanceDocumentsEntity docentity : userEntity.getFreelancedocumententity()) {
					freeLanceDocumentEntities.add(docentity);
					docentity.setUserdetails(userEntity);
				}
				userEntity.setFreelancedocumententity(freeLanceDocumentEntities);
			}
			freelanceentity.setJobAvailable(Boolean.FALSE);
			freelanceentity.setIsbgdone(Boolean.FALSE);
			freelanceentity.setIsbgstarted(Boolean.FALSE);
			freelanceentity.setIsprofilecompleted(Boolean.FALSE);
			freelanceentity.setIsregfeedone(Boolean.FALSE);
			freelanceentity.setFupercentage(80);
			freelanceentity.setCompanypercentage(20);
			freelanceentity.setUserdetails(userEntity);
			userEntity.setFreeLanceDetails(freelanceentity);
			userEntity.setFreelancehistoryentity(freeLanceHistoryEntities);

		} else if (userRoleEntity.getRolecode().equals(UserConstant.CLIENT_BUSINESS_ADMINISTRATOR)) {
			userEntity.setUniqueidentificationcode(CommonUtilites.genRandomAlphaNumeric());
			userEntity.setIsactive(Boolean.FALSE);
		} else if ((userRoleEntity.getRolecode().equals(UserConstant.CORE_SERVICE_SUPPORT_MANAGER))
				|| (userRoleEntity.getRolecode().equals(UserConstant.CORE_SERVICE_SUPPORT_TEAM))) {
			userEntity.setIsactive(Boolean.TRUE);
			UserManagerDetailsEntity usermanagerdetailsentity = userEntity.getUsermanagerdetailsentity();
			usermanagerdetailsentity.setUserdetails(userEntity);
			userEntity.setUsermanagerdetailsentity(usermanagerdetailsentity);
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

		userEntity.setFullname(userEntity.getFirstname() + " " + userEntity.getLastname());
		// Below IF condition is written for forgetPassword recovery
		if (userEntity.isIsrecoverypwd()) {
			userEntity.setPassword(encoder.encode(userEntity.getPassword()));
			userEntity.setIsrecoverypwd(Boolean.FALSE);
		}
		userEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
		UserBizEntity userBizEntity = userEntity.getUserbizdetails();
		UserRoleEntity userRoleEntity = userEntity.getUserroles();
		userBizEntity.setAccepteditprofileterms(Boolean.TRUE);

		if (userRoleEntity.getRolecode().equals(UserConstant.FREELANCER_USER)) {
			FreeLanceEntity freelanceentity = userEntity.getFreeLanceDetails();
			Set<FreeLanceHistoryEntity> freeLanceHistoryEntities = new HashSet<FreeLanceHistoryEntity>();
			for (FreeLanceHistoryEntity entity : userEntity.getFreelancehistoryentity()) {
				entity.setDecisionon(CommonUtilites.getCurrentDateInNewFormat());
				freeLanceHistoryEntities.add(entity);
				entity.setUserdetails(userEntity);
			}
			Set<FreeLanceDocumentsEntity> freeLanceDocumentEntities = new HashSet<FreeLanceDocumentsEntity>();
			for (FreeLanceDocumentsEntity docentity : userEntity.getFreelancedocumententity()) {
				freeLanceDocumentEntities.add(docentity);
				docentity.setUserdetails(userEntity);
			}
			freelanceentity.setUserdetails(userEntity);
			userEntity.setFreeLanceDetails(freelanceentity);
			userEntity.setFreelancehistoryentity(freeLanceHistoryEntities);
			userEntity.setFreelancedocumententity(freeLanceDocumentEntities);

		} else if ((userRoleEntity.getRolecode().equals(UserConstant.CORE_SERVICE_SUPPORT_MANAGER))
				|| (userRoleEntity.getRolecode().equals(UserConstant.CORE_SERVICE_SUPPORT_TEAM))) {

			UserManagerDetailsEntity usermanagerdetailsentity = userEntity.getUsermanagerdetailsentity();
			usermanagerdetailsentity.setUserdetails(userEntity);
			userEntity.setUsermanagerdetailsentity(usermanagerdetailsentity);
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
		userEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
		userEntity.setPassword(newPassword);

		return userEntity;
	}

	/**
	 * Helps in setting new password for admin.
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity prepareAdminToSignUp(String username) {

		UserEntity userEntity = new UserEntity();
		boolean checkUsernameNotExist = userRestDAO.checkUsernameNotExist(username);
		if (checkUsernameNotExist) {
			String newPassword = CommonUtilites.genRandomAlphaNumeric();
			userEntity.setIsactive(Boolean.TRUE);
			userEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
			userEntity.setPassword(newPassword);
		}
		return userEntity;
	}

	/**
	 * Gets all the user details if isrecoverypwd is true
	 * 
	 * @return userEntity
	 */
	public ArrayList<UserEntity> getUserByRecoveryPwd() {
		return userRestDAO.getUserByRecoveryPwd();

	}

	/**
	 * Gets all the notification details based on the userId
	 * 
	 * @param userId
	 * 
	 */
	public ArrayList<UserNotificationDetailsView> getNotificationDetailsByUserId(int userId) {
		return userRestDAO.getNotificationDetailsByUserId(userId);
	}

	/**
	 * Save the User Notification Details.
	 * 
	 * @param userNotificationEntity
	 */

	public UserNotificationEntity saveUserNotification(UserNotificationEntity userNotificationEntity) {
		userNotificationEntity.setSenton(CommonUtilites.getCurrentDateInNewFormat());
		return userRestDAO.saveUserNotification(userNotificationEntity);
	}

	/**
	 * Gets all the freelance user details when incomplete profile.
	 */
	public ArrayList<UserEntity> getFUUserDetailsWhenInCompleteProfile() {
		return userRestDAO.getFUUserDetailsWhenInCompleteProfile();
	}

	/**
	 * This method is for Saving Free Lancer History Details.
	 */
	public FreeLanceHistoryEntity saveFreeLanceHistory(FreeLanceHistoryEntity freeLanceHistoryEntity) {
		freeLanceHistoryEntity.setDecisionon(CommonUtilites.getCurrentDateInNewFormat());
		UserEntity userdetails = new UserEntity();
		userdetails.setUserId(freeLanceHistoryEntity.getUserid());
		freeLanceHistoryEntity.setUserdetails(userdetails);
		return userRestDAO.saveFreeLanceHistory(freeLanceHistoryEntity);
	}

	/**
	 * This method is for Saving Free Lancer Document Details.
	 */
	public FreeLanceDocumentsEntity saveFreeLanceDocument(FreeLanceDocumentsEntity freeLanceDocumentsEntity) {
		freeLanceDocumentsEntity.setUploaddate(CommonUtilites.getCurrentDateInNewFormat());
		UserEntity userdetails = new UserEntity();
		userdetails.setUserId(freeLanceDocumentsEntity.getUserid());
		freeLanceDocumentsEntity.setUserdetails(userdetails);
		return userRestDAO.saveFreeLanceDocument(freeLanceDocumentsEntity);
	}

}

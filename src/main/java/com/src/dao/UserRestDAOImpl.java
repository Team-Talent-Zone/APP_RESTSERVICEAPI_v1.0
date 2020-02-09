package com.src.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.constant.UserConstant;
import com.src.entity.UserEntity;
import com.src.entity.UserNotificationDetailsView;
import com.src.entity.UserNotificationEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> UserRestDAOImpl </code> class handles data access operation for
 * <code>UserDetails</code>.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class UserRestDAOImpl extends AbstractDAOManager implements UserRestDAO {
	final Logger LOGGER = LoggerFactory.getLogger(UserRestDAOImpl.class);

	/**
	 * Get the User Details by UserName.
	 * 
	 * @param username
	 */
	@Transactional
	public UserEntity findByUsername(String username) {
		LOGGER.info(UserConstant.USER_DAO_FINDBYUSERNAME);
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERNAME, username));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null && userEntity.isIsactive()) {
			return userEntity;
		}
		if (userEntity != null && !userEntity.isIsactive()) {
			throw new RestCustomException(HttpStatus.FOUND,
					applicationConfigProperties.getProperty(CustomMsgProperties.FINDBYUSERNAME_USERISNOTACTIVE_ERRORMSG)
							+ " for user name :" + username);
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.FINDBYUSERNAME_USERNOTFOUND_ERRORMSG)
						+ " for user name :" + username);
	}

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 * @throws Exception
	 */
	@Transactional
	public UserEntity checkUsername(String username) {
		LOGGER.info(UserConstant.USER_DAO_CHECKUSERNAME);
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERNAME, username));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null) {
			return userEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.CHECK_USERNAME_USERNOTFOUND_ERRORMSG) + " "
						+ username);
	}

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 * @throws Exception
	 */
	@Transactional
	public boolean checkUsernameNotExist(String username) {
		LOGGER.info(UserConstant.USER_DAO_CHECKUSERNAME);
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERNAME, username));
		userEntity = (UserEntity) criteria.setMaxResults(1).uniqueResult();
		if (userEntity == null) {
			return true;
		}
		throw new RestCustomException(HttpStatus.FOUND,
				applicationConfigProperties.getProperty(CustomMsgProperties.CHECK_USERNAME_USERFOUND_ERRORMSG) + " "
						+ username);
	}

	/**
	 * Save the User Details.
	 * 
	 * @param userEntityObject
	 * @return
	 */
	@Transactional
	public UserEntity saveUser(UserEntity userEntity) {

		LOGGER.info(UserConstant.USER_DAO_SAVEUSER);
		int savedId = (Integer) sessionFactory.getCurrentSession().save(userEntity);
		LOGGER.debug(UserConstant.USER_DAO_SUCCESSFULL_SAVEUSER + savedId);
		if (savedId > 0) {
			return userEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.SAVEUSER_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * Get the User Details by UserId.
	 * 
	 * @param userId
	 */
	@Transactional
	public UserEntity getUserByUserId(int userId) {
		LOGGER.info(UserConstant.USER_DAO_GETUSERBYUSERID);
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null) {
			return userEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

	/**
	 * Get All User Details from the List.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getAllUsers() {
		LOGGER.info(UserConstant.USER_DAO_GETALLUSERS);
		List<UserEntity> userEntity = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		LOGGER.debug(UserConstant.USER_DAO_INSIDE_GETALLUSERS + size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETALLUSERS_NOUSERSFOUND_ERRORMSG));
	}

	/**
	 * Get User Details by the Role.
	 * 
	 * @param role
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getUsersByRole(String role) {
		LOGGER.info(UserConstant.USER_DAO_GETUSERSBYROLE);
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.createAlias(UserConstant.USERROLES, UserConstant.UROLE, JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(UserConstant.UROLE_ROLECODE, role));
		userEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		LOGGER.debug(UserConstant.USER_DAO_INSIDE_GETUSERSBYROLE + size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT, applicationConfigProperties
				.getProperty(CustomMsgProperties.GETALLUSERSBYROLE_NOADMINUSERSFOUND_ERRORMSG));
	}

	/**
	 * Update or Edit on user Details Screen.
	 * 
	 * @param userEntityObj
	 */
	@Transactional
	public void saveorupdateUserDetails(UserEntity userEntity) {
		try {
			LOGGER.info(UserConstant.USER_DAO_SAVEORUPDATEUSERDETAILS);
			sessionFactory.getCurrentSession().saveOrUpdate(userEntity);
			LOGGER.info(UserConstant.USER_DAO_INSIDE_SAVEORUPDATEUSERDETAILS + userEntity.getUserId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.SAVEORUPDATEUSERDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	/**
	 * Gets all the user details if isrecoverypwd is true
	 * 
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public ArrayList<UserEntity> getUserByRecoveryPwd() {

		LOGGER.info(UserConstant.USER_DAO_GETUSERSBYRECOVERYPWD);
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USER_DETAILS_ISRECOVERYPWD, true));
		userEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		LOGGER.debug(UserConstant.USER_SERVICE_DAO_INSIDE_GETUSERBYRECOVERYPWD + size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		} else {
			throw new RestCustomException(HttpStatus.NO_CONTENT, applicationConfigProperties
					.getProperty(CustomMsgProperties.GETUSERBYRECOVERYPWD_USERNOTFOUND_ERRORMSG));
		}
	}

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getUserDetailsByJobAvailable() {
		LOGGER.info(UserConstant.USER_SERVICE_DAO_GETUSERSERVICEBYSERVICEID);
		List<UserEntity> freelanceUserEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.createAlias(UserConstant.FREELANCEDETAILS, UserConstant.FREELANCEDETAILS_ALIAS, JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(UserConstant.FU_ISJOBAVAILABLE, false));
		freelanceUserEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = freelanceUserEntity != null ? freelanceUserEntity.size() : 0;

		if (size > 0) {
			return (ArrayList<UserEntity>) freelanceUserEntity;
		} else {
			throw new RestCustomException(HttpStatus.NO_CONTENT, applicationConfigProperties
					.getProperty(CustomMsgProperties.GETUSERDETAILSBYJOBAVAILABLE_INVAILD_ERRORMSG));
		}

	}

	/**
	 * Gets all the notification details based on the user Id
	 * 
	 * @param userId
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ArrayList<UserNotificationDetailsView> getNotificationDetailsByUserId(int userId) {

		LOGGER.info(UserConstant.USER_DAO_GETNOTIFICATIONUSEDETAILSBYUSERID);
		List<UserNotificationDetailsView> userNotificationDetailsEntityViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserNotificationDetailsView.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		userNotificationDetailsEntityViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userNotificationDetailsEntityViews != null ? userNotificationDetailsEntityViews.size() : 0;

		if (size > 0) {
			return (ArrayList<UserNotificationDetailsView>) userNotificationDetailsEntityViews;
		} else {
			throw new RestCustomException(HttpStatus.NO_CONTENT, applicationConfigProperties
					.getProperty(CustomMsgProperties.GETNOTIFICATIONDETAILSBYUSERID_INVAILD_ERRORMSG));
		}
	}

	/**
	 * Save the User Notification Details.
	 * 
	 * @param userNotificationEntity
	 * @return
	 */
	@Transactional
	public UserNotificationEntity saveUserNotification(UserNotificationEntity userNotificationEntity) {
		LOGGER.info(UserConstant.USER_DAO_SAVEUSERNOTIFICATIONS);
		int savedId = (Integer) sessionFactory.getCurrentSession().save(userNotificationEntity);
		LOGGER.debug(UserConstant.USER_DAO_SUCCESSFULL_SAVEUSERNOTIFICATION + savedId);
		if (savedId > 0) {
			return userNotificationEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
				.getProperty(CustomMsgProperties.SAVEUSERNOTIFICATION_UNABLE_TO_SAVE_ERRORMSG));

	}

	/**
	 * Gets all the user freelance details when incomplete profile
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<UserEntity> getFUUserDetailsWhenInCompleteProfile() {
		LOGGER.info(UserConstant.USER_DAO_GETALLUSERDETAILSWHENPROFILEINCOMPLETED);
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.ISACTIVE, true));
		criteria.createAlias(UserConstant.FREELANCEDETAILS, UserConstant.FREELANCEDETAILS_ALIAS, JoinType.INNER_JOIN);
		criteria.add(Restrictions.isNull(UserConstant.FU_NATIONAL_ID));
		criteria.add(Restrictions.isNull(UserConstant.FU_UPLOADL_VALID_PHOTO));
		criteria.add(Restrictions.isNull(UserConstant.FU_UPLOADADDITIONAL_DOCS));
		criteria.add(Restrictions.isNull(UserConstant.FU_EXP_INFIELD));
		criteria.add(Restrictions.isNull(UserConstant.FU_ABOUT));
		criteria.add(Restrictions.isNull(UserConstant.FU_CATEGORY));
		criteria.add(Restrictions.isNull(UserConstant.FU_SUBCATEGORY));
		criteria.createAlias(UserConstant.USERBIZDETAILS, UserConstant.USERBIZDETAILS_ALIAS, JoinType.INNER_JOIN);
		criteria.add(Restrictions.isNull(UserConstant.FU_FULLADDRESS));
		criteria.createAlias(UserConstant.USERMANAGERDETAILS, UserConstant.USERMANAGERDETAILS_ALIAS, JoinType.NONE);
		userEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT, applicationConfigProperties
				.getProperty(CustomMsgProperties.GETALLUSERDETAILSWHENPROFILEINCOMPLETED_INVAILD_ERRORMSG));

	}

}
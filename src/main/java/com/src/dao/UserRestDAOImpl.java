package com.src.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.constant.UserConstant;
import com.src.entity.FreeLanceDocumentsEntity;
import com.src.entity.FreeLanceHistoryEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserNotificationEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> UserRestDAOImpl </code> class handles data access operation for
 * <code>UserDetails</code>.
 * 
 * @author Azmiri.
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
	 * @throws RestCustomException
	 * @param username
	 */
	@Transactional
	public UserEntity findByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info(UserConstant.USER_DAO_FINDBYUSERNAME);
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERNAME, username));
		criteria.add(Restrictions.eq(UserConstant.ISACTIVE, true));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null && userEntity.isIsactive()) {
			return  userEntity;

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
	 * @throws RestCustomException
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
		return null;
		/*throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.CHECK_USERNAME_USERNOTFOUND_ERRORMSG) + " "
						+ username);*/
	}

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 * @throws RestCustomException
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
			return false;
			/*throw new RestCustomException(HttpStatus.NO_CONTENT,
					applicationConfigProperties.getProperty(CustomMsgProperties.CHECK_USERNAME_ISFOUND_ERRORMSG) + " "
							+ username);*/
	}

	/**
	 * Save the User Details.
	 * 
	 * @throws RestCustomException
	 * @param userEntityObject
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
	 * @throws RestCustomException
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
	 * @throws RestCustomException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getAllUsers() {
		List<UserEntity> userEntityList = null;
		LOGGER.info(UserConstant.USER_DAO_GETALLUSERS);
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		//criteria.add(Restrictions.eq(UserConstant.ISACTIVE, true));
		criteria.addOrder(Order.asc("fullname"));
		criteria.createAlias(UserConstant.FREELANCEHISOTRY, UserConstant.FREELANCEDETAILS_ALIAS, JoinType.NONE);
 
		userEntityList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntityList != null ? userEntityList.size() : 0;
		LOGGER.debug(UserConstant.USER_DAO_INSIDE_GETALLUSERS + size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntityList;
		}
		return null;
	}

	/**
	 * Get User Details by the Role.
	 * 
	 * @throws RestCustomException
	 * @param role
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getUsersByRole(String role) {
		LOGGER.info(UserConstant.USER_DAO_GETUSERSBYROLE);
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.ISACTIVE, true));
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
	 * @throws RestCustomException
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
	 * Save the User Notification Details.
	 * 
	 * @throws RestCustomException
	 * @param userNotificationEntity
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
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getFUUserDetailsWhenInCompleteProfile() {
		LOGGER.info(UserConstant.USER_DAO_GETALLUSERDETAILSWHENPROFILEINCOMPLETED);
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq(UserConstant.ISACTIVE, true));
		criteria.createAlias(UserConstant.FREELANCEDETAILS, UserConstant.FREELANCEDETAILS_ALIAS, JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(UserConstant.FU_IS_PROFILE_COMPLETED, false));
		criteria.createAlias(UserConstant.USERMANAGERDETAILS, UserConstant.USERMANAGERDETAILS_ALIAS, JoinType.NONE);
		userEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		return null;
	}

	/**
	 * Gets all the user details if isrecoverypwd is true
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public ArrayList<UserEntity> getUserByRecoveryPwd() {

		LOGGER.info(UserConstant.USER_DAO_GETUSERSBYRECOVERYPD);
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		Criterion isRecoveryPwd = Restrictions.eq(UserConstant.USER_DETAILS_ISRECOVERYPD, true);
		Criterion isActive = Restrictions.eq(UserConstant.ISACTIVE, false);
		criteria.add(Restrictions.or(isRecoveryPwd, isActive));
		criteria.createAlias(UserConstant.USERROLES, UserConstant.UROLE, JoinType.INNER_JOIN);
		criteria.add(Restrictions.in(UserConstant.UROLE_ROLECODE,
				Arrays.asList(UserConstant.FREELANCER_USER, UserConstant.CLIENT_BUSINESS_ADMINISTRATOR)));
		userEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		LOGGER.debug(UserConstant.USER_SERVICE_DAO_INSIDE_GETUSERBYRECOVERYPD + size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		return null;
	}

	/**
	 * To Save Free Lancer History Details.
	 * 
	 * @throws RestCustomException
	 * @param FreeLanceHistoryEntity freeLanceHistoryEntity
	 * @return freeLanceHistoryEntity
	 */
	@Transactional
	public FreeLanceHistoryEntity saveFreeLanceHistory(FreeLanceHistoryEntity freeLanceHistoryEntity) {
		int serviceHistorySavedID = (Integer) sessionFactory.getCurrentSession().save(freeLanceHistoryEntity);
		if (serviceHistorySavedID > 0) {
			return freeLanceHistoryEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.FREELANCEHISTORY_UNABLE_TO_SAVE_ERRORMSG));

	}

	/**
	 * To Save Free Lancer Document Details.
	 * 
	 * @throws RestCustomException
	 * @param FreeLanceHistoryEntity freeLanceHistoryEntity
	 * @return freeLanceHistoryEntity
	 */
	@Transactional
	public FreeLanceDocumentsEntity saveFreeLanceDocument(FreeLanceDocumentsEntity freeLanceDocumentsEntity) {
		int serviceDocSavedID = (Integer) sessionFactory.getCurrentSession().save(freeLanceDocumentsEntity);
		if (serviceDocSavedID > 0) {
			return freeLanceDocumentsEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.FREELANCEDOC_UNABLE_TO_SAVE_ERRORMSG));
	}

}
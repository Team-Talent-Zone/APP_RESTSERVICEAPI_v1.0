package com.src.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.constant.NewServiceConstant;
import com.src.constant.UserConstant;
import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceEventHistoryEntity;
import com.src.entity.UserServiceExpirationDetailsView;
import com.src.entity.UserServiceNotfications;
import com.src.entity.UserServiceNotificationDetailsView;
import com.src.exception.RestCustomException;

/**
 * The <code> UserServiceDetailsDAOImpl </code> class handles data access
 * operation for <code>User Service Details.</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class UserServiceDetailsDAOImpl extends AbstractDAOManager implements UserServiceDetailsDAO {
	final Logger LOGGER = LoggerFactory.getLogger(UserServiceDetailsDAOImpl.class);

	/**
	 * To save the User Service Details.
	 */
	@Transactional
	public UserServiceDetailsEntity saveUserServiceDetails(UserServiceDetailsEntity userServiceDetailsEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_USERSERVICE_DETAILS);
		int userServiceDetailsID = (Integer) sessionFactory.getCurrentSession().save(userServiceDetailsEntity);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_USERSERVICE_DETAILS + userServiceDetailsID);
		if (userServiceDetailsID > 0) {
			return userServiceDetailsEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To save or Update the New Service Details.
	 */
	@Transactional
	public void saveOrUpdateUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity) {
		try {
			LOGGER.info(NewServiceConstant.INSIDE_SAVEORUPDATE_USERSERVICEDETAILS);
			sessionFactory.getCurrentSession().saveOrUpdate(userServiceDetailsEntity);
			LOGGER.info(NewServiceConstant.CONFIRMED_SAVEORUPDATE_USERSERVICEDETAILS
					+ userServiceDetailsEntity.getServiceId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	/**
	 * Get the User Service Details by UserId.
	 * 
	 * @param userId
	 */
	@Transactional
	public UserServiceDetailsEntity getUserServiceDetailsByUserId(int userId) {
		LOGGER.info(UserConstant.USER_SERVICE_DAO_GETUSERSERVICEBYUSERID);
		UserServiceDetailsEntity userServiceDetailsEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserServiceDetailsEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		userServiceDetailsEntity = (UserServiceDetailsEntity) criteria.uniqueResult();
		if (userServiceDetailsEntity != null) {
			return userServiceDetailsEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

	/**
	 * Get the User Service Details by serviceId.
	 * 
	 * @param serviceId
	 */
	@Transactional
	public UserServiceDetailsEntity getUserServiceDetailsByServiceId(int serviceId) {
		LOGGER.info(UserConstant.USER_SERVICE_DAO_GETUSERSERVICEBYSERVICEID);
		UserServiceDetailsEntity userServiceDetailsEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserServiceDetailsEntity.class);
		criteria.add(Restrictions.eq(UserConstant.SERVICEID, serviceId));
		userServiceDetailsEntity = (UserServiceDetailsEntity) criteria.uniqueResult();
		if (userServiceDetailsEntity != null) {
			return userServiceDetailsEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for Service Id : " + serviceId);
	}

	/**
	 * To Get All User Service Details.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserServiceDetailsEntity> getAllUserServiceDetails() {
		LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLUSERSERVICEDETAILS);
		List<UserServiceDetailsEntity> newUserServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserServiceDetailsEntity.class);
		criteria.add(Restrictions.eq(NewServiceConstant.USER_SERVICE_DETAILS_ISACTIVE, true));
		newUserServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newUserServiceEntity != null ? newUserServiceEntity.size() : 0;
		LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLUSERSERVICEDETAILS + size);
		if (size > 0) {
			return (ArrayList<UserServiceDetailsEntity>) newUserServiceEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETALLUSERS_NOUSERSFOUND_ERRORMSG));
	}

	/**
	 * To save the User Service Notification.
	 */
	@Transactional
	public UserServiceNotfications saveUserServiceNotification(UserServiceNotfications userServiceNotfication) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_USERSERVICE_NOTIGFICATION);
		int userServiceNotificationId = (Integer) sessionFactory.getCurrentSession().save(userServiceNotfication);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_USERSERVICE_NOTIFICATION + userServiceNotificationId);
		if (userServiceNotificationId > 0) {
			return userServiceNotfication;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To get the User Expiration Details Notification.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails() {
		List<UserServiceExpirationDetailsView> userServiceExpirationDetails = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(UserServiceExpirationDetailsView.class);
		userServiceExpirationDetails = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userServiceExpirationDetails != null ? userServiceExpirationDetails.size() : 0;

		if (size > 0) {
			return (ArrayList<UserServiceExpirationDetailsView>) userServiceExpirationDetails;
		}
		return null;
	}

	/**
	 * To get the User Service Details Notification by User id.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId) {
		List<UserServiceNotificationDetailsView> userServiceNotificationDetailsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(UserServiceNotificationDetailsView.class);
		userServiceNotificationDetailsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userServiceNotificationDetailsViews != null ? userServiceNotificationDetailsViews.size() : 0;

		if (size > 0) {
			return (ArrayList<UserServiceNotificationDetailsView>) userServiceNotificationDetailsViews;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To get the User Service Details Pending Payments Notification.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserServiceDetailsEntity> getUserServicePendingPayment() {
		List<UserServiceDetailsEntity> newUserServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserServiceDetailsEntity.class);
		criteria.add(Restrictions.eq(NewServiceConstant.USER_SERVICE_DETAILS_ISACTIVE, true));
		criteria.add(Restrictions.eq("status", "PAYMENT_PENDING"));
		newUserServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newUserServiceEntity != null ? newUserServiceEntity.size() : 0;
		if (size > 0) {
			return (ArrayList<UserServiceDetailsEntity>) newUserServiceEntity;
		}
		return null;
	}

	@Transactional
	public void saveUserServiceEventHistory(UserServiceEventHistoryEntity eventHistoryEntity) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(eventHistoryEntity);
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}
}

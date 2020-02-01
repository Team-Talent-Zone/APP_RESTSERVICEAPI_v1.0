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

import com.src.constant.AppConfig;
import com.src.constant.NewServiceConstant;
import com.src.constant.UserConstant;
import com.src.entity.UserServiceDetailsEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> UserServiceDetailsDAOImpl </code> class handles data access
 * operation for <code>User Service Details.</code>.
 * 
 * @author Shanoor
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
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
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
					.getProperty(AppConfig.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
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
				applicationConfigProperties.getProperty(AppConfig.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
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
				applicationConfigProperties.getProperty(AppConfig.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
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
				applicationConfigProperties.getProperty(AppConfig.GETALLUSERS_NOUSERSFOUND_ERRORMSG));
	}
}

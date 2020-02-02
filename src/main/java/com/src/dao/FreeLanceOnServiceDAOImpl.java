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
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> FreeLanceOnServiceDAOImpl </code> class handles data access
 * operation for <code>Free Lance On Service</code>.
 * 
 * @author Shanoor
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class FreeLanceOnServiceDAOImpl extends AbstractDAOManager implements FreeLanceOnServiceDAO {
	final Logger LOGGER = LoggerFactory.getLogger(FreeLanceOnServiceDAOImpl.class);

	/**
	 * To save the freelance on Service.
	 */
	@Transactional
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_FREELANCE_ONSERVICE);
		int userServiceDetailsID = (Integer) sessionFactory.getCurrentSession().save(freeLanceOnServiceEntity);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_FREELANCE_ONSERVICE + userServiceDetailsID);
		if (userServiceDetailsID > 0) {
			return freeLanceOnServiceEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To save or Update the New Service Details.
	 */
	@Transactional
	public void saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		try {
			LOGGER.info(NewServiceConstant.INSIDE_SAVEORUPDATE_FREELANCE_ON_SERVICE);
			sessionFactory.getCurrentSession().saveOrUpdate(freeLanceOnServiceEntity);
			LOGGER.info(NewServiceConstant.CONFIRMED_SAVEORUPDATE_FREELANCE_ON_SERVICE
					+ freeLanceOnServiceEntity.getJobId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(AppConfig.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	/**
	 * To Save Free Lance Star Review Feedback Details.
	 */
	@Transactional
	public FreeLanceStarReviewFBEntity saveFreeLanceStarReviewFB(FreeLanceStarReviewFBEntity freeLanceStarReviewFB) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_FREELANCE_STAR_REVIEW_FB);
		int freeLanceStarReviewFBID = (Integer) sessionFactory.getCurrentSession().save(freeLanceStarReviewFB);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_FREELANCE_STAR_REVIEW_FB + freeLanceStarReviewFBID);
		if (freeLanceStarReviewFBID > 0) {
			return freeLanceStarReviewFB;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To Save Free Lance On Service Notification.
	 */
	@Transactional
	public FreeLanceOnServiceNotification saveFreeLanceOnServiceNotification(
			FreeLanceOnServiceNotification freeLanceOnServiceNotification) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_FREELANCE_ON_SERVICE_NOTIFICATION);
		int freeLanceOnServiceNotificationId = (Integer) sessionFactory.getCurrentSession()
				.save(freeLanceOnServiceNotification);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_FREELANCE_ON_NOTIFICATION + freeLanceOnServiceNotificationId);
		if (freeLanceOnServiceNotificationId > 0) {
			return freeLanceOnServiceNotification;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To get Free Lance on Service Details.
	 */
	@Transactional
	public ArrayList<FreeLanceOnServiceEntity> getAllFreelanceOnServiceDetails() {
		LOGGER.info(UserConstant.USER_DAO_GETALLFREELANCEONSERVICE);
		@SuppressWarnings("unchecked")
		List<FreeLanceOnServiceEntity> freeLanceOnServiceEntity = this.sessionFactory.getCurrentSession()
				.createCriteria(FreeLanceOnServiceEntity.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		int size = freeLanceOnServiceEntity != null ? freeLanceOnServiceEntity.size() : 0;
		LOGGER.debug(UserConstant.USER_DAO_INSIDE_GETALLFREELANCEONSERVICE + size);
		if (size > 0) {
			return (ArrayList<FreeLanceOnServiceEntity>) freeLanceOnServiceEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.GETALLUSERS_NOUSERSFOUND_ERRORMSG));
	}
	
	/**
	 * Get the Free Lance On Service Details by UserId.
	 * 
	 * @param userId
	 */
	@Transactional
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId) {
		LOGGER.info(UserConstant.FREELANCE_ON_SERVICE_DAO_GETUSERSERVICEBYUSERID);
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreeLanceOnServiceEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		freeLanceOnServiceEntity = (FreeLanceOnServiceEntity) criteria.uniqueResult();
		if (freeLanceOnServiceEntity != null) {
			return freeLanceOnServiceEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

}

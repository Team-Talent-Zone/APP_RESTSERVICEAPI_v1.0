package com.src.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.constant.NewServiceConstant;
import com.src.constant.UserConstant;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.entity.FreelanceOnServiceSearchView;
import com.src.entity.FreelancerAvailableStartDateStoreProc;
import com.src.exception.RestCustomException;

/**
 * The <code> FreeLanceOnServiceDAOImpl </code> class handles data access
 * operation for <code>Free Lance On Service</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class FreeLanceOnServiceDAOImpl extends AbstractDAOManager implements FreeLanceOnServiceDAO {
	final Logger LOGGER = LoggerFactory.getLogger(FreeLanceOnServiceDAOImpl.class);

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @throws RestCustomException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<FreelanceOnServiceSearchView> getUserDetailsByJobAvailable() {
		LOGGER.info(UserConstant.USER_SERVICE_DAO_GETUSERSERVICEBYSERVICEID);
		List<FreelanceOnServiceSearchView> freelanceUserEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreelanceOnServiceSearchView.class);
		freelanceUserEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = freelanceUserEntity != null ? freelanceUserEntity.size() : 0;

		if (size > 0) {
			return (ArrayList<FreelanceOnServiceSearchView>) freelanceUserEntity;
		}
		return null;
	}

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @throws RestCustomException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<FreelancerAvailableStartDateStoreProc> getUserDetailsByJobAvailableByJobStartOn(
			String jobstartonval, String scategory) {
		List<FreelancerAvailableStartDateStoreProc> availableStartDateStoreProcs = null;
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("callGetFreelancerNotAvbBetweenStartDate")
				.setParameter("jobstarton", jobstartonval).setParameter("scategory", scategory);
		availableStartDateStoreProcs = query.list();
		int size = availableStartDateStoreProcs != null ? availableStartDateStoreProcs.size() : 0;

		if (size > 0) {
			return (ArrayList<FreelancerAvailableStartDateStoreProc>) availableStartDateStoreProcs;
		}
		return null;

	}

	/**
	 * To save the freelancer on Service.
	 * 
	 * @param freeLanceOnServiceEntity
	 * @throws RestCustomException
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
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To save or Update the New Service Details.
	 * 
	 * @param freeLanceOnServiceEntity
	 * @throws RestCustomException
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
					.getProperty(CustomMsgProperties.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	/**
	 * To Save Free Lance Star Review Feedback Details.
	 * 
	 * @param freeLanceStarReviewFB
	 * @throws RestCustomException
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
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To Save Free Lance On Service Notification.
	 * 
	 * @param freeLanceOnServiceNotification
	 * @throws RestCustomException
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
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To get Free Lance on Service Details.
	 * 
	 * @throws RestCustomException
	 */
	@SuppressWarnings("unused")
	@Transactional
	public FreeLanceOnServiceEntity getAllFreelanceOnServiceDetailsByJobId(int jobId) {
		LOGGER.info(UserConstant.USER_DAO_GETALLFREELANCEONSERVICE);
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreeLanceOnServiceEntity.class);
		criteria.add(Restrictions.eq(UserConstant.JOB_ID, jobId));
		criteria.addOrder(Order.desc("jobId"));
		freeLanceOnServiceEntity = (FreeLanceOnServiceEntity) criteria.uniqueResult();
		if (freeLanceOnServiceEntity != null) {
			return freeLanceOnServiceEntity;
		}
		if (freeLanceOnServiceEntity != null) {
			return freeLanceOnServiceEntity;
		}
		return null;
	}

	/**
	 * Get the Free Lance On Service Details by UserId.
	 * 
	 * @throws RestCustomException
	 * @param userId
	 */
	@Transactional
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId) {
		LOGGER.info(UserConstant.FREELANCE_ON_SERVICE_DAO_GETUSERSERVICEBYUSERID);
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreeLanceOnServiceEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		criteria.addOrder(Order.desc("jobId"));
		freeLanceOnServiceEntity = (FreeLanceOnServiceEntity) criteria.uniqueResult();
		if (freeLanceOnServiceEntity != null) {
			return freeLanceOnServiceEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

	/**
	 * To delete the FreeLance On Service Details.
	 * 
	 * @param freeLanceOnServiceEntity
	 */
	@Transactional
	public void deleteFreelanceSVCDetails(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(freeLanceOnServiceEntity);
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.DELETEFUONSERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId) {
		List<FreeLanceStarReviewFBEntity> freeLanceTestimonialsDetailsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreeLanceStarReviewFBEntity.class);
		criteria.add(Restrictions.eq(UserConstant.FREELANCEID, userId));
		criteria.addOrder(Order.desc("feedbackon"));

		freeLanceTestimonialsDetailsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = freeLanceTestimonialsDetailsViews != null ? freeLanceTestimonialsDetailsViews.size() : 0;
		if (size > 0) {
			return (ArrayList<FreeLanceStarReviewFBEntity>) freeLanceTestimonialsDetailsViews;
		}
		return null;
	}

	@Override
	public FreeLanceStarReviewFBEntity getFUFeebackDetailsByJobId(int jobId) {
		FreeLanceStarReviewFBEntity freeLanceTestimonialsDetailsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreeLanceStarReviewFBEntity.class);
		criteria.add(Restrictions.eq(UserConstant.JOB_ID, jobId));

		freeLanceTestimonialsDetailsViews = (FreeLanceStarReviewFBEntity) criteria.uniqueResult();
		if (freeLanceTestimonialsDetailsViews != null) {
			return freeLanceTestimonialsDetailsViews;
		}
		return null;
	}
}

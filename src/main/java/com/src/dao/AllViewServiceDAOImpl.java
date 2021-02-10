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
import com.src.constant.PaymentConstant;
import com.src.constant.UserConstant;
import com.src.entity.AllActiveNewSeviceDetailsView;
import com.src.entity.AllBellNotificationsView;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceExpirationDetailsView;
import com.src.entity.FreeLanceOnServiceNotificationDetailsView;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.entity.FreeLanceTestimonialsDetailsView;
import com.src.entity.FreelanceOnServiceJobPostedView;
import com.src.entity.FreelanceOnServiceSearchView;
import com.src.entity.FreelancerAvailableStartDateStoreProc;
import com.src.entity.GraphFURRatingView;
import com.src.entity.GraphJobsDataView;
import com.src.entity.GraphSkillBaseDataView;
import com.src.entity.GraphSkillWorkerVoliationDataView;
import com.src.entity.GraphUserServiceDataView;
import com.src.entity.PaymentHistoryCBAView;
import com.src.entity.PaymentHistoryFUView;
import com.src.entity.UserNotificationDetailsView;
import com.src.entity.UserServiceActiveDetailsView;
import com.src.entity.UserServiceExpirationDetailsView;
import com.src.entity.UserServiceNotificationDetailsView;
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
public class AllViewServiceDAOImpl extends AbstractDAOManager implements AllViewServiceDAO {
	final Logger LOGGER = LoggerFactory.getLogger(AllViewServiceDAOImpl.class);
	

	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AllBellNotificationsView> getAllAdminBellNotifications(String roleCode) {
		List<AllBellNotificationsView> allBellNotificationsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AllBellNotificationsView.class);
		criteria.add(Restrictions.eq(NewServiceConstant.USER_SERVICE_DETAILS_VISIBLITY, roleCode));
		allBellNotificationsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = allBellNotificationsViews != null ? allBellNotificationsViews.size() : 0;
		if (size > 0) {
			return (ArrayList<AllBellNotificationsView>) allBellNotificationsViews;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsView() {
		try {
			LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLUSERSERVICEDETAILS);
			List<UserServiceActiveDetailsView> newUserServiceEntity = null;
			Criteria criteria = this.sessionFactory.getCurrentSession()
					.createCriteria(UserServiceActiveDetailsView.class);
			newUserServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			int size = newUserServiceEntity != null ? newUserServiceEntity.size() : 0;
			LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLUSERSERVICEDETAILS + size);
			if (size > 0) {
				return (ArrayList<UserServiceActiveDetailsView>) newUserServiceEntity;
			}
		} catch (Exception e) {
			throw new RestCustomException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return null;
	}
	/**
	 * To get the User Service Details by userId.
	 * 
	 * @param userId
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsByUserId(int userId) {
		try {
			LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLUSERSERVICEDETAILS);
			List<UserServiceActiveDetailsView> newUserServiceEntity = null;
			Criteria criteria = this.sessionFactory.getCurrentSession()
					.createCriteria(UserServiceActiveDetailsView.class);
			criteria.add(Restrictions.eq(NewServiceConstant.USER_SERVICE_DETAILS_USERID, userId));
			newUserServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			int size = newUserServiceEntity != null ? newUserServiceEntity.size() : 0;
			LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLUSERSERVICEDETAILS + size);
			if (size > 0) {
				return (ArrayList<UserServiceActiveDetailsView>) newUserServiceEntity;
			}
		} catch (Exception e) {
			throw new RestCustomException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AllBellNotificationsView> getAllBellNotifications(int userId , String visibility) {
		List<AllBellNotificationsView> allBellNotificationsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AllBellNotificationsView.class);
		criteria.add(Restrictions.eq(NewServiceConstant.USER_SERVICE_DETAILS_UID, userId));
		criteria.add(Restrictions.eq(NewServiceConstant.USER_SERVICE_DETAILS_VISIBLITY, visibility));
		allBellNotificationsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = allBellNotificationsViews != null ? allBellNotificationsViews.size() : 0;
		if (size > 0) {
			return (ArrayList<AllBellNotificationsView>) allBellNotificationsViews;
		}
		return null;
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
	 * 
	 * @param userId
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
	 * Gets all the notification details based on the user Id
	 * 
	 * @throws RestCustomException
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
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public  ArrayList<PaymentHistoryFUView> getPaymentFUDetailsByUserId(int userId) {
		LOGGER.info(PaymentConstant.PAYMENT_GETFUPAYMENT_DETAILSBYUSERID);
		List<PaymentHistoryFUView> paymentFUTranscationHistEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(PaymentHistoryFUView.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		paymentFUTranscationHistEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = paymentFUTranscationHistEntity != null ? paymentFUTranscationHistEntity.size() : 0;
		if (size > 0) {
			return   (ArrayList<PaymentHistoryFUView>) paymentFUTranscationHistEntity;
		}
		return null;
		/*
		 * throw new RestCustomException(HttpStatus.NO_CONTENT,
		 * applicationConfigProperties.getProperty(CustomMsgProperties.
		 * GETUSERBYUSERID_USERNOTFOUND_ERRORMSG) + " for user Id : " + userId);
		 */
	}

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<PaymentHistoryCBAView> getPaymentCBADetailsByUserId(int userId) {
		LOGGER.info(PaymentConstant.PAYMENT_GETCBAPAYMENT_DETAILSBYUSERID);
		List<PaymentHistoryCBAView> paymentCBATranscationHistEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(PaymentHistoryCBAView.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		paymentCBATranscationHistEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = paymentCBATranscationHistEntity != null ? paymentCBATranscationHistEntity.size() : 0;
		if (size > 0) { 
			return  (ArrayList<PaymentHistoryCBAView>)  paymentCBATranscationHistEntity;
		}
		return null;
		/*
		 * throw new RestCustomException(HttpStatus.NO_CONTENT,
		 * applicationConfigProperties.getProperty(CustomMsgProperties.
		 * GETUSERBYUSERID_USERNOTFOUND_ERRORMSG) + " for user Id : " + userId);
		 */
	}

	
	/**
	 * To Get all the Service Details.
	 * 
	 * @throw RestCustomException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails() {
		LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLSERVICEDETAILS);
		List<AllActiveNewSeviceDetailsView> newServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AllActiveNewSeviceDetailsView.class);
	 
		newServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newServiceEntity != null ? newServiceEntity.size() : 0;
		LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLSERVICEDETAILS + size);
		if (size > 0) {
			return (ArrayList<AllActiveNewSeviceDetailsView>) newServiceEntity;
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
	 * To Get the FU on Service Expiration Details.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreeLanceOnServiceExpirationDetailsView> getFUOnServiceExpirationDetails() {
		List<FreeLanceOnServiceExpirationDetailsView> freeLanceOnServiceExpirationDetailsView = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreeLanceOnServiceExpirationDetailsView.class);
		freeLanceOnServiceExpirationDetailsView = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		if (freeLanceOnServiceExpirationDetailsView != null) {
			return (ArrayList<FreeLanceOnServiceExpirationDetailsView>) freeLanceOnServiceExpirationDetailsView;
		}
		return null;
	}

	/**
	 * To Get the FU on Service Notification Details by UserId.
	 * 
	 * @param userId
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreeLanceOnServiceNotificationDetailsView> getFUOnServiceNotificationDetailsByUserId(int userId) {
		List<FreeLanceOnServiceNotificationDetailsView> freeLanceOnServiceNotificationDetailsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreeLanceOnServiceNotificationDetailsView.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		freeLanceOnServiceNotificationDetailsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();

		if (freeLanceOnServiceNotificationDetailsViews != null) {
			return (ArrayList<FreeLanceOnServiceNotificationDetailsView>) freeLanceOnServiceNotificationDetailsViews;
		}
		return null;
	}

	/**
	 * To get all users job details by Sub Category.
	 *  
	 *  @param scategory 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsBySubCategory(String scategory) {
		List<FreelanceOnServiceJobPostedView> freelanceOnServiceAllJobViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreelanceOnServiceJobPostedView.class);
		criteria.add(Restrictions.eq(UserConstant.JOB_SUBCATEGORY, scategory));
		criteria.addOrder(Order.desc("jobId"));
		freelanceOnServiceAllJobViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		if (freelanceOnServiceAllJobViews != null) {
			return (ArrayList<FreelanceOnServiceJobPostedView>) freelanceOnServiceAllJobViews;
		}
		return null;
	}
	
	
	/** To get all users job details 
	 *  
	 *  @param scategory 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetails() {
		List<FreelanceOnServiceJobPostedView> freelanceOnServiceAllJobViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreelanceOnServiceJobPostedView.class);
		criteria.addOrder(Order.desc("jobId"));
		freelanceOnServiceAllJobViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		if (freelanceOnServiceAllJobViews != null) {
			return (ArrayList<FreelanceOnServiceJobPostedView>) freelanceOnServiceAllJobViews;
		}
		return null;
	}

	/**
	 * To get all users job details by UserID.
	 *  
	 *  @param userId 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByUserId(int userId) {
		List<FreelanceOnServiceJobPostedView> freelanceOnServiceAllJobViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreelanceOnServiceJobPostedView.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		criteria.addOrder(Order.desc("jobId"));
		freelanceOnServiceAllJobViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		if (freelanceOnServiceAllJobViews != null) {
			return (ArrayList<FreelanceOnServiceJobPostedView>) freelanceOnServiceAllJobViews;
		}
		return null;
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

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreeLanceTestimonialsDetailsView> getFUFeebackDetails() {
		List<FreeLanceTestimonialsDetailsView> freeLanceTestimonialsDetailsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreeLanceTestimonialsDetailsView.class);
		freeLanceTestimonialsDetailsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = freeLanceTestimonialsDetailsViews != null ? freeLanceTestimonialsDetailsViews.size() : 0;
		if (size > 0) {
			return (ArrayList<FreeLanceTestimonialsDetailsView>) freeLanceTestimonialsDetailsViews;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId) {
		List<FreeLanceStarReviewFBEntity> freeLanceTestimonialsDetailsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FreeLanceStarReviewFBEntity.class);
		criteria.add(Restrictions.eq(UserConstant.FREELANCEID, userId));
		freeLanceTestimonialsDetailsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = freeLanceTestimonialsDetailsViews != null ? freeLanceTestimonialsDetailsViews.size() : 0;
		if (size > 0) {
			return (ArrayList<FreeLanceStarReviewFBEntity>) freeLanceTestimonialsDetailsViews;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AllBellNotificationsView> getAllBellNotificationDetails() {
		List<AllBellNotificationsView> allBellNotificationsViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AllBellNotificationsView.class);
		allBellNotificationsViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = allBellNotificationsViews != null ? allBellNotificationsViews.size() : 0;
		if (size > 0) {
			return (ArrayList<AllBellNotificationsView>) allBellNotificationsViews;
		}
		return null;
	}
	
	/** 
	 * To get all the pending payments of freelancer.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllPendingPaymentOfFreelancer() {
		List<FreelanceOnServiceJobPostedView> freelanceOnServiceAllJobViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreelanceOnServiceJobPostedView.class);
		criteria.add(Restrictions.eq(UserConstant.ISJOBACTIVE, true));
		criteria.add(Restrictions.eq(UserConstant.ISJOBAMTPAIDTOFU, false));
		criteria.add(Restrictions.eq(UserConstant.ISJOBCOMPLETED, true));
		criteria.add(Restrictions.eq(UserConstant.ISJOBAMTPAIDTOCOMPANY, true));
		criteria.add(Restrictions.eq(UserConstant.ISJOBACCEPTED, true));
		freelanceOnServiceAllJobViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		if (freelanceOnServiceAllJobViews != null) {
			return (ArrayList<FreelanceOnServiceJobPostedView>) freelanceOnServiceAllJobViews;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByFreelancerId(int userId) {
		List<FreelanceOnServiceJobPostedView> freelanceOnServiceAllJobViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreelanceOnServiceJobPostedView.class);
		criteria.add(Restrictions.eq(UserConstant.FREELANCERID, userId));
		criteria.addOrder(Order.desc("jobId"));
		freelanceOnServiceAllJobViews = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		if (freelanceOnServiceAllJobViews != null) {
			return (ArrayList<FreelanceOnServiceJobPostedView>) freelanceOnServiceAllJobViews;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GraphFURRatingView> getGraphFURatingData() {
		List<GraphFURRatingView> ratingList = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(GraphFURRatingView.class);
		ratingList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		if (ratingList != null) {
			return (ArrayList<GraphFURRatingView>) ratingList;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GraphJobsDataView> getGraphJobsData() {
		List<GraphJobsDataView> jobsList = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(GraphJobsDataView.class);
		jobsList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		if (jobsList != null) {
			return (ArrayList<GraphJobsDataView>) jobsList;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GraphSkillBaseDataView> getGraphSkillBasedData() {
		List<GraphSkillBaseDataView> ratingList = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(GraphSkillBaseDataView.class);
		ratingList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		if (ratingList != null) {
			return (ArrayList<GraphSkillBaseDataView>) ratingList;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GraphUserServiceDataView> getGraphUserServiceData() {
		List<GraphUserServiceDataView> ratingList = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(GraphUserServiceDataView.class);
		ratingList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		if (ratingList != null) {
			return (ArrayList<GraphUserServiceDataView>) ratingList;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GraphSkillWorkerVoliationDataView> getGraphSKVoliationData() {
		List<GraphSkillWorkerVoliationDataView> ratingList = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(GraphSkillWorkerVoliationDataView.class);
		ratingList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		if (ratingList != null) {
			return (ArrayList<GraphSkillWorkerVoliationDataView>) ratingList;
		}
		return null;
	}

	@Override
	public FreelanceOnServiceJobPostedView getUserAllJobDetailsByJobId(int jobId) {
		FreelanceOnServiceJobPostedView freelanceOnServiceAllJobViews = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(FreelanceOnServiceJobPostedView.class);
		criteria.add(Restrictions.eq(UserConstant.JOB_ID, jobId));
		criteria.addOrder(Order.desc("jobId"));
		freelanceOnServiceAllJobViews = (FreelanceOnServiceJobPostedView) criteria.uniqueResult();
		if (freelanceOnServiceAllJobViews != null) {
			return   freelanceOnServiceAllJobViews;
		}
		return null;
	}
}

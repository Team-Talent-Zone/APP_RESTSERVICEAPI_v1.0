package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.AllActiveNewSeviceDetailsView;
import com.src.entity.AllBellNotificationsView;
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

/**
 * The <code> FreeLanceOnServiceSVCImpl </code> class provides the
 * implementation for the <code>Free Lance on Service</code> related business
 * interface.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Service(NewServiceConstant.ALLVIEW_SERVICE)
@Transactional(rollbackFor = { Exception.class })
public class AllViewServiceSVCImpl extends AbstractServiceManager implements AllViewServiceSVC {
	

	/**
	 * To get User service Notification Details by user id.
	 */
	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId) {
		return allViewServiceDAO.getUserServiceNotificationDetailsByUserId(userId);
	}
	/**
	 * To get the user service Expiration Details.
	 */
	@Override
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails() {
		return allViewServiceDAO.getUserServiceExpirationDetails();
	}

	@Override
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsByUserId(int userId) {
		return allViewServiceDAO.getAllUserServiceDetailsByUserId(userId);
	}
	
	@Override
	public ArrayList<AllBellNotificationsView> getAllBellNotifications(int userId , String visibility) {
		return allViewServiceDAO.getAllBellNotifications(userId , visibility);
	}
	
	@Override
	public ArrayList<AllBellNotificationsView> getAllAdminBellNotifications(String roleCode) {
		return allViewServiceDAO.getAllAdminBellNotifications(roleCode);
	}

	@Override
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsView() {
		return allViewServiceDAO.getAllUserServiceDetailsView();
	}
	
	/**
	 * Gets all the notification details based on the userId
	 * 
	 * @param userId
	 * 
	 */
	public ArrayList<UserNotificationDetailsView> getNotificationDetailsByUserId(int userId) {
		return allViewServiceDAO.getNotificationDetailsByUserId(userId);
	}
	
	/**
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public ArrayList<PaymentHistoryFUView> getPaymentFUDetailsByUserId(int userId) {
		return allViewServiceDAO.getPaymentFUDetailsByUserId(userId);
	}

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public ArrayList<PaymentHistoryCBAView> getPaymentCBADetailsByUserId(int userId) {
		return allViewServiceDAO.getPaymentCBADetailsByUserId(userId);
	}
	
	/**
	 * To Get All Service Details.
	 */
	@Override
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails() {
		return allViewServiceDAO.getAllServiceDetails();
	}
	
	@Override
	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId) {
		return allViewServiceDAO.getFUFeebackDetailsUserId(userId);

	}

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelanceOnServiceSearchView> getUserDetailsByJobAvailable() {
		return allViewServiceDAO.getUserDetailsByJobAvailable();
	}

	/**
	 * Gets all the user details if isJobAvailable is false and createdon
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelancerAvailableStartDateStoreProc> getUserDetailsByJobAvailableByCreateOn(String jobstarton,
			String scategory) {
		return allViewServiceDAO.getUserDetailsByJobAvailableByJobStartOn(jobstarton, scategory);
	}

	
	
	/**
	 * To get FU on service Expiration Details.
	 */
	@Override
	public ArrayList<FreeLanceOnServiceExpirationDetailsView> getFUOnServiceExpirationDetails() {
		return allViewServiceDAO.getFUOnServiceExpirationDetails();
	}

	/**
	 * To Get FU Service Notification Details By UserId.
	 */
	@Override
	public ArrayList<FreeLanceOnServiceNotificationDetailsView> getFUOnServiceNotificationDetailsByUserId(int userId) {
		return allViewServiceDAO.getFUOnServiceNotificationDetailsByUserId(userId);
	}

	/**
	 * To Get FU user job details.
	 */
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsBySubCategory(String scategory) {
		return allViewServiceDAO.getUserAllJobDetailsBySubCategory(scategory);
	}

	/**
	 * To Get FU user job details.
	 */
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetails() {
		return allViewServiceDAO.getUserAllJobDetails();
	}
	
	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByUserId(int userId) {
		return allViewServiceDAO.getUserAllJobDetailsByUserId(userId);
	}


	@Override
	public ArrayList<FreeLanceTestimonialsDetailsView> getFUFeebackDetails() {
		return allViewServiceDAO.getFUFeebackDetails();
	}


	@Override
	public ArrayList<AllBellNotificationsView> getAllBellNotificationDetails() {
		return allViewServiceDAO.getAllBellNotificationDetails();
	}

	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllPendingPaymentOfFreelancer() {
		return allViewServiceDAO.getUserAllPendingPaymentOfFreelancer();
	}

	@Override
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByFreelancerId(int userId) {
		return allViewServiceDAO.getUserAllJobDetailsByFreelancerId(userId);
	}
	
	@Override
	public ArrayList<GraphFURRatingView> getGraphFURatingData() {
		return allViewServiceDAO.getGraphFURatingData();
	}
	
	@Override
	public ArrayList<GraphJobsDataView> getGraphJobsData() {
		return allViewServiceDAO.getGraphJobsData();
	}
	
	@Override
	public ArrayList<GraphSkillBaseDataView> getGraphSkillBasedData() {
		return allViewServiceDAO.getGraphSkillBasedData();
	}
	
	@Override
	public ArrayList<GraphUserServiceDataView> getGraphUserServiceData() {
		return allViewServiceDAO.getGraphUserServiceData();
	}
	
	@Override
	public ArrayList<GraphSkillWorkerVoliationDataView> getGraphSKVoliationData() {
		return allViewServiceDAO.getGraphSKVoliationData();
	}
	
	@Override
	public FreelanceOnServiceJobPostedView getUserAllJobDetailsByJobId(int jobId) {
		return allViewServiceDAO.getUserAllJobDetailsByJobId( jobId);
	}

}

package com.src.dao;

import java.util.ArrayList;

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
 * The <code> FreeLanceOnServiceDAO </code> interface defines a data access
 * object for retrieving <code>Free Lance on Service</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface AllViewServiceDAO {
	
	/**
	 * To get the User Expiration Details Notification.
	 */
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails();

	/**
	 * To get the User Service Details by userId.
	 */
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsByUserId(int userId);
	
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsView();

	/**
	 * To get all bell notifications by userId.
	 */
	public ArrayList<AllBellNotificationsView> getAllBellNotifications(int userId , String visibility);
	
	/**
	 * To get all bell notifications.
	 */
	public ArrayList<AllBellNotificationsView> getAllAdminBellNotifications(String roleCode);

	/**
	 * To get the User Service Details Notification by User id.
	 * 
	 * @param userId
	 */
	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId);

	
	/**
	 * Get the FU on Service Expiration Details.
	 * 
	 */
	public ArrayList<FreeLanceOnServiceExpirationDetailsView> getFUOnServiceExpirationDetails();

	/**
	 * Get the FU on Service Notification Details by UserId.
	 * 
	 * @param userId
	 * 
	 */
	public ArrayList<FreeLanceOnServiceNotificationDetailsView> getFUOnServiceNotificationDetailsByUserId(int userId);

	/**
	 * Gets all the user details if isJobAvailable is false
	 */
	public ArrayList<FreelanceOnServiceSearchView> getUserDetailsByJobAvailable();

	/**
	 * Gets all the user details if isJobAvailable is false and by job start on
	 */
	public ArrayList<FreelancerAvailableStartDateStoreProc> getUserDetailsByJobAvailableByJobStartOn(String jobstarton,
			String scategory);

	/**
	 * Gets all the user details job details by sub category
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsBySubCategory(String scategory);
	
	/**
	 * Gets all the user details job details
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetails();

	/**
	 * Gets all the user details job details by userId
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByUserId(int userId);

	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByFreelancerId(int userId);


	public ArrayList<FreeLanceTestimonialsDetailsView> getFUFeebackDetails();

	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId);

	public ArrayList<AllBellNotificationsView> getAllBellNotificationDetails();
	
	
	/** 
	 * To get all the pending payments of freelancer.
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllPendingPaymentOfFreelancer();
	
	/**
	 * To get All Service Details.
	 * 
	 */
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails();
	
	/**
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public  ArrayList<PaymentHistoryFUView> getPaymentFUDetailsByUserId(int userId);

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public  ArrayList<PaymentHistoryCBAView> getPaymentCBADetailsByUserId(int userId);

	/**
	 * Gets all the notification details based on the user Id
	 * 
	 * @param userId
	 * 
	 */
	public ArrayList<UserNotificationDetailsView> getNotificationDetailsByUserId(int userId);

	public ArrayList<GraphFURRatingView> getGraphFURatingData();
	
	public ArrayList<GraphJobsDataView> getGraphJobsData();
	
	public ArrayList<GraphSkillBaseDataView> getGraphSkillBasedData();
	
	public ArrayList<GraphUserServiceDataView> getGraphUserServiceData();
	
	public ArrayList<GraphSkillWorkerVoliationDataView> getGraphSKVoliationData();

	public FreelanceOnServiceJobPostedView getUserAllJobDetailsByJobId(int jobId);



}

package com.src.service;

import java.util.ArrayList;

import com.src.entity.AllActiveNewSeviceDetailsView;
import com.src.entity.AllBellNotificationsView;
import com.src.entity.FreeLanceOnServiceExpirationDetailsView;
import com.src.entity.FreeLanceOnServiceNotificationDetailsView;
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
 * The <code> FreeLanceOnServiceSVC </code> interface defines a business service
 * for retrieving <code>Free Lance on Service Details.</code>.
 * 
 * @author Shanoor
 *
 */
public interface AllViewServiceSVC {
	
	
	public ArrayList<GraphFURRatingView> getGraphFURatingData();
	
	public ArrayList<GraphJobsDataView> getGraphJobsData();
	
	public ArrayList<GraphSkillBaseDataView> getGraphSkillBasedData();
	
	public ArrayList<GraphUserServiceDataView> getGraphUserServiceData();
	
	public ArrayList<GraphSkillWorkerVoliationDataView> getGraphSKVoliationData();

	
	/**
	 * To Get the all User Service Details by userId.
	 * 
	 * @return Get All User Service Details.
	 */
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsByUserId(int userId);
	
	public ArrayList<UserServiceActiveDetailsView> getAllUserServiceDetailsView();

	/**
	 * To get User Service Expiration Details.
	 */
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails();

	/**
	 * To Get User Service Notification Details by User Id.
	 * 
	 * @param userId
	 */
	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId);

	/**
	 * To get all bell notifications by userId and Role Code.
	 */
	public ArrayList<AllBellNotificationsView> getAllBellNotifications(int userId , String roleCode);
	
	/**
	 * To get all bell notifications.
	 */
	public ArrayList<AllBellNotificationsView> getAllAdminBellNotifications(String roleCode);

	
	/**
	 * Gets all the notification details based on the user Id
	 * 
	 * @param userId
	 * 
	 */
	public ArrayList<UserNotificationDetailsView> getNotificationDetailsByUserId(int userId);

	
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
	 * To Get the all Service Details for CBA.
	 * 
	 * @return
	 */
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails();

	/**
	 * To get FU Service Expiration Details.
	 */
	public ArrayList<FreeLanceOnServiceExpirationDetailsView> getFUOnServiceExpirationDetails();

	/**
	 * To get FU on Service Notifications by user id.
	 * 
	 * @param userId
	 */
	public ArrayList<FreeLanceOnServiceNotificationDetailsView> getFUOnServiceNotificationDetailsByUserId(int userId);

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelanceOnServiceSearchView> getUserDetailsByJobAvailable();

	/**
	 * Gets all the user details passing jobstarton
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelancerAvailableStartDateStoreProc> getUserDetailsByJobAvailableByCreateOn(String jobstarton,
			String scategory);

	/**
	 * Gets all the user details job details by sub category
	 * 
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsBySubCategory(String scategory);
	
	/**
	 * Gets all the user details job details
	 * 
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetails();

	/**
	 * Gets all the user details job details by userId
	 * 
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByUserId(int userId);
	
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByFreelancerId(int userId);

	public ArrayList<FreeLanceTestimonialsDetailsView> getFUFeebackDetails();
	
	public ArrayList<AllBellNotificationsView> getAllBellNotificationDetails();

	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllPendingPaymentOfFreelancer();
	
	public FreelanceOnServiceJobPostedView getUserAllJobDetailsByJobId(int jobId);


}

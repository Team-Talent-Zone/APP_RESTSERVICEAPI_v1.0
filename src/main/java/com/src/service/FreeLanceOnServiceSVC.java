package com.src.service;

import java.util.ArrayList;

import com.src.entity.AllBellNotificationsView;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceExpirationDetailsView;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceOnServiceNotificationDetailsView;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.entity.FreeLanceTestimonialsDetailsView;
import com.src.entity.FreelanceOnServiceJobPostedView;
import com.src.entity.FreelanceOnServiceSearchView;
import com.src.entity.FreelancerAvailableStartDateStoreProc;

/**
 * The <code> FreeLanceOnServiceSVC </code> interface defines a business service
 * for retrieving <code>Free Lance on Service Details.</code>.
 * 
 * @author Shanoor
 *
 */
public interface FreeLanceOnServiceSVC {

	/**
	 * To save Free Lance on Service.
	 * 
	 * @param FreeLanceOnServiceEntity
	 */
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To edit and Update the Free Lance on Service.
	 * 
	 * @param freeLanceOnServiceEntity
	 */
	public FreeLanceOnServiceEntity saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To save Free Lance Star Review FeedBack.
	 * 
	 * @param freeLanceStarReviewFB
	 */
	public FreeLanceStarReviewFBEntity saveFreeLanceStarReviewFB(FreeLanceStarReviewFBEntity freeLanceStarReviewFB);

	/**
	 * To save Free Lance on Service Notification.
	 * 
	 * @param saveFreeLanceOnServiceNotification
	 */
	public FreeLanceOnServiceNotification saveFreeLanceOnServiceNotification(
			FreeLanceOnServiceNotification freeLanceOnServiceNotification);

	/**
	 * To Get the all free lance Service Details.
	 */
	public FreeLanceOnServiceEntity getAllFreelanceOnServiceDetailsByJobId(int jobId);

	/**
	 * Get the Free Lance on Service Details by UserId.
	 * 
	 * @param userId
	 */
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId);

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
	 * Gets all the user details job details
	 * 
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsBySubCategory(String scategory);

	/**
	 * Gets all the user details job details by userId
	 * 
	 * 
	 */
	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByUserId(int userId);

	/**
	 * To delete the FreeLance On Service Details.
	 */	
	public boolean deleteFreelanceSVCDetails(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	
	public ArrayList<FreeLanceTestimonialsDetailsView> getFUFeebackDetails();
	
	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId);
	
	public ArrayList<AllBellNotificationsView> getAllBellNotificationDetails();

	public ArrayList<FreelanceOnServiceJobPostedView> getUserAllPendingPaymentOfFreelancer();

}

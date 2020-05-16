package com.src.dao;

import java.util.ArrayList;

import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceExpirationDetailsView;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceOnServiceNotificationDetailsView;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.entity.FreelanceOnServiceAllJobView;
import com.src.entity.FreelanceOnServiceAvailableForJobView;
import com.src.entity.FreelancerAvailableStartDateStoreProc;

/**
 * The <code> FreeLanceOnServiceDAO </code> interface defines a data access
 * object for retrieving <code>Free Lance on Service</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface FreeLanceOnServiceDAO {

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
	public void saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To save Free Lance Review FeedBack.
	 * 
	 * @param freeLanceStarReviewFB
	 */
	public FreeLanceStarReviewFBEntity saveFreeLanceStarReviewFB(FreeLanceStarReviewFBEntity freeLanceStarReviewFB);

	/**
	 * To save Free Lance on Service Notification.
	 * 
	 * @param freeLanceOnServiceNotification
	 */
	public FreeLanceOnServiceNotification saveFreeLanceOnServiceNotification(
			FreeLanceOnServiceNotification freeLanceOnServiceNotification);

	/**
	 * To get All Free LanceService Details.
	 */
	public ArrayList<FreeLanceOnServiceEntity> getAllFreelanceOnServiceDetails();

	/**
	 * Get the Free Lance on Service Details by UserId.
	 * 
	 * @param userId
	 */
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId);

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
	public ArrayList<FreelanceOnServiceAvailableForJobView> getUserDetailsByJobAvailable();

	/**
	 * Gets all the user details if isJobAvailable is false and by job start on
	 */
	public ArrayList<FreelancerAvailableStartDateStoreProc> getUserDetailsByJobAvailableByJobStartOn(String jobstarton,
			String scategory);

	/**
	 * Gets all the user details job details
	 * 
	 */
	public ArrayList<FreelanceOnServiceAllJobView> getUserAllJobDetailsBySubCategory(String scategory);

}

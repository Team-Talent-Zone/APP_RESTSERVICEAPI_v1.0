package com.src.dao;

import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceStarReviewFBEntity;

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
	public FreeLanceOnServiceEntity getAllFreelanceOnServiceDetailsByJobId(int jobId);

	/**
	 * Get the Free Lance on Service Details by UserId.
	 * 
	 * @param userId
	 */
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId);

	/**
	 * To delete the FreeLance On Service Details.
	 */
	public void deleteFreelanceSVCDetails(FreeLanceOnServiceEntity freeLanceOnServiceEntity);
	
}

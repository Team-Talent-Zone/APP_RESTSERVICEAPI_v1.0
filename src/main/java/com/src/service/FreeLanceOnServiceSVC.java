package com.src.service;

import java.util.ArrayList;

import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceStarReviewFBEntity;

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


	/** To delete the FreeLance On Service Details.
	 *
	 */	
	public boolean deleteFreelanceSVCDetails(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId);

	public FreeLanceStarReviewFBEntity getFUFeebackDetailsByJobId(int jobId);

}

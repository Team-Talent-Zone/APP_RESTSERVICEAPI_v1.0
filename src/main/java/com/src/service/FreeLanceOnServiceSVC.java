package com.src.service;

import java.util.ArrayList;

import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceExpirationDetailsView;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceOnServiceNotificationDetailsView;
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
	 * @return
	 */
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To edit and Update the Free Lance on Service.
	 * 
	 * @param freeLanceOnServiceEntity
	 * @return
	 */
	public FreeLanceOnServiceEntity saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To save Free Lance Star Review FeedBack.
	 * 
	 * @param freeLanceStarReviewFB
	 * @return
	 */
	public FreeLanceStarReviewFBEntity saveFreeLanceStarReviewFB(FreeLanceStarReviewFBEntity freeLanceStarReviewFB);

	/**
	 * To save Free Lance on Service Notification.
	 * 
	 * @param saveFreeLanceOnServiceNotification
	 * @return
	 */
	public FreeLanceOnServiceNotification saveFreeLanceOnServiceNotification(
			FreeLanceOnServiceNotification freeLanceOnServiceNotification);

	/**
	 * To Get the all freelance Service Details.
	 * 
	 * @return
	 */
	public ArrayList<FreeLanceOnServiceEntity> getAllFreelanceOnServiceDetails();

	/**
	 * Get the Free Lance on Service Details by UserId.
	 * 
	 * @param userId
	 */
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId);

	public ArrayList<FreeLanceOnServiceExpirationDetailsView> getFUOnServiceExpirationDetails();

	public ArrayList<FreeLanceOnServiceNotificationDetailsView> getFUOnServiceNotificationDetailsByUserId(int userId);

}

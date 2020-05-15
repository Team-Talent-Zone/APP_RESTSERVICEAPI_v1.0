package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceExpirationDetailsView;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceOnServiceNotificationDetailsView;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.entity.FreelanceOnServiceAllJobView;
import com.src.entity.FreelanceOnServiceAvailableForJobView;
import com.src.entity.FreelancerAvailableStartDateStoreProc;
import com.src.entity.UserServiceDetailsEntity;
import com.src.utils.CommonUtilites;

/**
 * The <code> FreeLanceOnServiceSVCImpl </code> class provides the
 * implementation for the <code>Free Lance on Service</code> related business
 * interface.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Service(NewServiceConstant.FREE_LANCE_ON_SERVICE)
@Transactional(rollbackFor = { Exception.class })
public class FreeLanceOnServiceSVCImpl extends AbstractServiceManager implements FreeLanceOnServiceSVC {

	/**
	 * Gets all the user details if isJobAvailable is false
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelanceOnServiceAvailableForJobView> getUserDetailsByJobAvailable() {
		return freeLanceOnServiceDAO.getUserDetailsByJobAvailable();
	}

	/**
	 * Gets all the user details if isJobAvailable is false and createdon
	 * 
	 * @param isJobAvailable
	 * 
	 */
	public ArrayList<FreelancerAvailableStartDateStoreProc> getUserDetailsByJobAvailableByCreateOn(String jobstarton,
			String scategory) {
		return freeLanceOnServiceDAO.getUserDetailsByJobAvailableByJobStartOn(jobstarton, scategory);
	}

	/**
	 * To save Free Lance On Service Details.
	 */
	@Override
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		freeLanceOnServiceEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
		freeLanceOnServiceEntity.setIsjobaccepted(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobamtpaidtofu(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobamtpaidtocompany(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobcompleted(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobcancel(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobactive(Boolean.TRUE);
		freeLanceOnServiceEntity.setIsjobamtpaidtocompany(Boolean.TRUE);
		UserServiceDetailsEntity userServiceDetailsEntity = new UserServiceDetailsEntity();
		userServiceDetailsEntity.setServiceId(freeLanceOnServiceEntity.getServiceId());
		freeLanceOnServiceEntity.setUserServiceDetails(userServiceDetailsEntity);
		return freeLanceOnServiceDAO.saveFreeLanceOnService(freeLanceOnServiceEntity);
	}

	/**
	 * To save or Update FreeLance on Service Details.
	 */
	@Override
	public FreeLanceOnServiceEntity saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		freeLanceOnServiceEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());

		UserServiceDetailsEntity userServiceDetails = new UserServiceDetailsEntity();
		userServiceDetails.setServiceId(freeLanceOnServiceEntity.getServiceId());
		freeLanceOnServiceEntity.setUserServiceDetails(userServiceDetails);
		freeLanceOnServiceDAO.saveOrUpdateFreeLanceOnService(freeLanceOnServiceEntity);
		return freeLanceOnServiceEntity;
	}

	/**
	 * To save Free Lance Star Review FeedBack Details.
	 */
	@Override
	public FreeLanceStarReviewFBEntity saveFreeLanceStarReviewFB(FreeLanceStarReviewFBEntity freeLanceStarReviewFB) {
		freeLanceStarReviewFB.setFeedBackOn(CommonUtilites.getCurrentDateInNewFormat());

		FreeLanceOnServiceEntity freeLanceOnServiceEntity = new FreeLanceOnServiceEntity();
		freeLanceOnServiceEntity.setJobId(freeLanceStarReviewFB.getJobId());
		freeLanceStarReviewFB.setFreeLanceOnServiceEntity(freeLanceOnServiceEntity);
		return freeLanceOnServiceDAO.saveFreeLanceStarReviewFB(freeLanceStarReviewFB);
	}

	/**
	 * To save Free Lance On Service Notification Details.
	 */
	@Override
	public FreeLanceOnServiceNotification saveFreeLanceOnServiceNotification(
			FreeLanceOnServiceNotification freeLanceOnServiceNotification) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = new FreeLanceOnServiceEntity();
		freeLanceOnServiceEntity.setJobId(freeLanceOnServiceNotification.getJobId());
		freeLanceOnServiceNotification.setFreeLanceOnServiceEntity(freeLanceOnServiceEntity);
		return freeLanceOnServiceDAO.saveFreeLanceOnServiceNotification(freeLanceOnServiceNotification);
	}

	/**
	 * To Get All Free Lance Service Details.
	 */
	@Override
	public ArrayList<FreeLanceOnServiceEntity> getAllFreelanceOnServiceDetails() {
		return freeLanceOnServiceDAO.getAllFreelanceOnServiceDetails();
	}

	/**
	 * Get the Free Lance on Service Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public FreeLanceOnServiceEntity getFreeLanceOnServiceDetailsByUserId(int userId) {
		return freeLanceOnServiceDAO.getFreeLanceOnServiceDetailsByUserId(userId);
	}

	/**
	 * To get FU on service Expiration Details.
	 */
	@Override
	public ArrayList<FreeLanceOnServiceExpirationDetailsView> getFUOnServiceExpirationDetails() {
		return freeLanceOnServiceDAO.getFUOnServiceExpirationDetails();
	}

	/**
	 * To Get FU Service Notification Details By UserId.
	 */
	@Override
	public ArrayList<FreeLanceOnServiceNotificationDetailsView> getFUOnServiceNotificationDetailsByUserId(int userId) {
		return freeLanceOnServiceDAO.getFUOnServiceNotificationDetailsByUserId(userId);
	}

	/**
	 * To Get FU user job details.
	 */

	@Override
	public ArrayList<FreelanceOnServiceAllJobView> getUserAllJobDetailsBySubCategory(String scategory) {
		return freeLanceOnServiceDAO.getUserAllJobDetailsBySubCategory(scategory);
	}

}

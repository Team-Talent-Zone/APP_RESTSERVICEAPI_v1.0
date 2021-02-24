package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceStarReviewFBEntity;
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
	 * To save Free Lance On Service Details.
	 */
	@Override
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		freeLanceOnServiceEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
		if (freeLanceOnServiceEntity.getResolvedvoliationreason() == null) {
			freeLanceOnServiceEntity.setIsjobaccepted(Boolean.FALSE);
			freeLanceOnServiceEntity.setIsjobactive(Boolean.FALSE);
		}
		freeLanceOnServiceEntity.setIsjobamtpaidtofu(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobamtpaidtocompany(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobcompleted(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobcancel(Boolean.FALSE);
		freeLanceOnServiceEntity.setIsjobamtpaidtocompany(Boolean.FALSE);
		freeLanceOnServiceEntity.setIslivelocationtracking(Boolean.FALSE);
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
		/*
		 * if (!freeLanceOnServiceEntity.isIsjobaccepted() &&
		 * !freeLanceOnServiceEntity.isIsjobcompleted()) {
		 * freeLanceOnServiceEntity.setIsjobaccepted(true);
		 * freeLanceOnServiceEntity.setJobaccepteddate(CommonUtilites.
		 * getCurrentDateInNewFormat()); }
		 */
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
		freeLanceStarReviewFB.setFeedbackon(CommonUtilites.getCurrentDateIndianFormat());
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
	public FreeLanceOnServiceEntity getAllFreelanceOnServiceDetailsByJobId(int jobId) {
		return freeLanceOnServiceDAO.getAllFreelanceOnServiceDetailsByJobId(jobId);
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

	@Override
	public boolean deleteFreelanceSVCDetails(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		freeLanceOnServiceDAO.deleteFreelanceSVCDetails(freeLanceOnServiceEntity);
		if (freeLanceOnServiceEntity.getServiceId() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<FreeLanceStarReviewFBEntity> getFUFeebackDetailsUserId(int userId) {
		return freeLanceOnServiceDAO.getFUFeebackDetailsUserId(userId);

	}
	
	@Override
	public FreeLanceStarReviewFBEntity getFUFeebackDetailsByJobId(int jobId) {
		return freeLanceOnServiceDAO.getFUFeebackDetailsByJobId(jobId);

	}

}

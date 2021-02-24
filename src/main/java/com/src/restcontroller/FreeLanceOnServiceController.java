package com.src.restcontroller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.constant.UserConstant;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceOnServiceNotification;
import com.src.entity.FreeLanceStarReviewFBEntity;

/**
 * The <code> FreeLanceOnServiceController </code> class defines managed beans
 * which provides back-end functionality on the
 * <code>Free Lance on Service.</code>
 * 
 * @author Shanoor
 *
 */
@Controller
public class FreeLanceOnServiceController extends AbstractRestManager {

	/**
	 * Method is to save Free Lance On Service Details.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveFreeLanceOnService/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceEntity> saveFreeLanceOnService(
			@RequestBody FreeLanceOnServiceEntity freeLanceOnServiceEntityObject) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = freeLanceOnServiceSVC
				.saveFreeLanceOnService(freeLanceOnServiceEntityObject);
		return new ResponseEntity<FreeLanceOnServiceEntity>(freeLanceOnServiceEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save or Update the Free Lance On Service.
	 * 
	 * @param saveOrUpdateFreeLanceOnService
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateFreeLanceOnService/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceEntity> saveOrUpdateFreeLanceOnService(
			@RequestBody FreeLanceOnServiceEntity freeLanceOnServiceEntityObject) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = freeLanceOnServiceSVC
				.saveOrUpdateFreeLanceOnService(freeLanceOnServiceEntityObject);
		return new ResponseEntity<FreeLanceOnServiceEntity>(freeLanceOnServiceEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save Free Lance Star Review FeedBack.
	 * 
	 * @param freeLanceStarReviewFBObject
	 * @return
	 */
	@RequestMapping(value = "/saveFreeLanceStarReviewFB/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceStarReviewFBEntity> saveFreeLanceStarReviewFB(
			@RequestBody FreeLanceStarReviewFBEntity freeLanceStarReviewFBObject) {
		FreeLanceStarReviewFBEntity freeLanceStarReviewFBEntity = freeLanceOnServiceSVC
				.saveFreeLanceStarReviewFB(freeLanceStarReviewFBObject);
		return new ResponseEntity<FreeLanceStarReviewFBEntity>(freeLanceStarReviewFBEntity, HttpStatus.OK);
	}

	/**
	 * Method to Save Free Lance On Service Notification.
	 * 
	 * @param saveFreeLanceOnServiceNotification
	 * @return
	 */
	@RequestMapping(value = "/saveFreeLanceOnServiceNotification/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceNotification> saveFreeLanceOnServiceNotification(
			@RequestBody FreeLanceOnServiceNotification freeLanceOnServiceNotificationObject) {
		FreeLanceOnServiceNotification freeLanceOnServiceNotificationEntity = freeLanceOnServiceSVC
				.saveFreeLanceOnServiceNotification(freeLanceOnServiceNotificationObject);
		return new ResponseEntity<FreeLanceOnServiceNotification>(freeLanceOnServiceNotificationEntity, HttpStatus.OK);
	}

	/**
	 * Get Freelance on Service Details by Job Id.
	 * 
	 */
	@RequestMapping(value = "/getAllFreelanceOnServiceDetailsByJobId/{jobId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceEntity> getAllFreelanceOnServiceDetailsByJobId(
			@PathVariable(UserConstant.JOB_ID) int jobId) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = freeLanceOnServiceSVC
				.getAllFreelanceOnServiceDetailsByJobId(jobId);
		return new ResponseEntity<FreeLanceOnServiceEntity>(freeLanceOnServiceEntity, HttpStatus.OK);
	}

	/**
	 * Get the FreeLance On Service Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getFreeLanceOnServiceDetailsByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceEntity> getFreeLanceOnServiceDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = freeLanceOnServiceSVC
				.getFreeLanceOnServiceDetailsByUserId(userId);
		return new ResponseEntity<FreeLanceOnServiceEntity>(freeLanceOnServiceEntity, HttpStatus.OK);
	}

	/**
	 * To delete the FreeLance On Service Details.
	 */
	@RequestMapping(value = "/deleteFreelanceSVCDetails/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteFreelanceSVCDetails(
			@RequestBody FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		boolean isDeleted = freeLanceOnServiceSVC.deleteFreelanceSVCDetails(freeLanceOnServiceEntity);
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);

	}
	
	/**
	 * Get UserFeedBack Details by userId.
	 * 
	 * @param userId
	 * @return list of user feedback details
	 */
	@RequestMapping(value = "/getFUFeebackDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreeLanceStarReviewFBEntity>> getFUFeebackDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<FreeLanceStarReviewFBEntity> freelanceUserEntity = freeLanceOnServiceSVC.getFUFeebackDetailsUserId(userId);
		return new ResponseEntity<ArrayList<FreeLanceStarReviewFBEntity>>(freelanceUserEntity, HttpStatus.OK);
	}
	
	/**
	 * Get UserFeedBack Details by jobId.
	 * 
	 * @param userId
	 * @return list of user feedback details
	 */
	@RequestMapping(value = "/getFUFeebackDetailsByJobId/{jobId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceStarReviewFBEntity> getFUFeebackDetailsByJobId(
			@PathVariable(UserConstant.JOB_ID) int jobId) {
		FreeLanceStarReviewFBEntity freelanceUserEntity = freeLanceOnServiceSVC.getFUFeebackDetailsByJobId(jobId);
		return new ResponseEntity<FreeLanceStarReviewFBEntity>(freelanceUserEntity, HttpStatus.OK);
	}

	
}

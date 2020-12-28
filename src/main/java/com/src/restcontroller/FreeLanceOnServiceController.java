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
	 * Get the Free Lancer On Service Details when service end date after 2 days
	 * 
	 */
	@RequestMapping(value = "/getFUOnServiceExpirationDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreeLanceOnServiceExpirationDetailsView>> getFUOnServiceExpirationDetails() {
		ArrayList<FreeLanceOnServiceExpirationDetailsView> listofFUOnServiceExpirations = freeLanceOnServiceSVC
				.getFUOnServiceExpirationDetails();
		return new ResponseEntity<ArrayList<FreeLanceOnServiceExpirationDetailsView>>(listofFUOnServiceExpirations,
				HttpStatus.OK);
	}

	/**
	 * Get Free Lance OnService Notification Details when userId
	 * 
	 * @param userId
	 * @return list of user details
	 * 
	 */
	@RequestMapping(value = "/getFUOnServiceNotificationDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreeLanceOnServiceNotificationDetailsView>> getFUOnServiceNotificationDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<FreeLanceOnServiceNotificationDetailsView> freeLanceOnServiceNotificationDetailsViews = freeLanceOnServiceSVC
				.getFUOnServiceNotificationDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<FreeLanceOnServiceNotificationDetailsView>>(
				freeLanceOnServiceNotificationDetailsViews, HttpStatus.OK);
	}

	/**
	 * Get User Details when isJobAvailable is false.
	 * 
	 * @param isJobAvailable
	 * @return list of user details
	 */
	@RequestMapping(value = "/getUserDetailsByJobAvailable/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceSearchView>> getUserDetailsByJobAvailable() {
		ArrayList<FreelanceOnServiceSearchView> freelanceUserEntity = freeLanceOnServiceSVC
				.getUserDetailsByJobAvailable();
		return new ResponseEntity<ArrayList<FreelanceOnServiceSearchView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get User Details when isJobAvailable is false and start on.
	 * 
	 * @param isJobAvailable
	 * @return list of user details
	 */
	@RequestMapping(value = "/getUserDetailsByJobAvailableByCreateOn/{jobCreatedOn}/{scategory}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelancerAvailableStartDateStoreProc>> getUserDetailsByJobAvailableByCreateOn(
			@PathVariable(UserConstant.JOB_CREATED_ON) String jobcreatedon,
			@PathVariable(UserConstant.JOB_SUBCATEGORY) String scategory) {
		ArrayList<FreelancerAvailableStartDateStoreProc> freelanceUserEntity = freeLanceOnServiceSVC
				.getUserDetailsByJobAvailableByCreateOn(jobcreatedon, scategory);
		return new ResponseEntity<ArrayList<FreelancerAvailableStartDateStoreProc>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All FU User Job Details
	 */

	@RequestMapping(value = "/getUserAllJobDetailsBySubCategory/{scategory}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllJobDetails(
			@PathVariable(UserConstant.JOB_SUBCATEGORY) String scategory) {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = freeLanceOnServiceSVC
				.getUserAllJobDetailsBySubCategory(scategory);
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All Job Details By UserId
	 */

	@RequestMapping(value = "/getUserAllJobDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllJobDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = freeLanceOnServiceSVC
				.getUserAllJobDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * List of Freelancers to whom company has to pay the job invoice amount
	 */

	@RequestMapping(value = "/getUserAllPendingPaymentOfFreelancer/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllPendingPaymentOfFreelancer() {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = freeLanceOnServiceSVC
				.getUserAllPendingPaymentOfFreelancer();
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get all Freelancer reviews given by client.
	 * 
	 * @param isJobAvailable
	 * @return list of user details
	 */
	@RequestMapping(value = "/getFUFeebackDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreeLanceTestimonialsDetailsView>> getFUFeebackDetails() {
		ArrayList<FreeLanceTestimonialsDetailsView> freelanceUserEntity = freeLanceOnServiceSVC.getFUFeebackDetails();
		return new ResponseEntity<ArrayList<FreeLanceTestimonialsDetailsView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get User Details when isJobAvailable is false.
	 * 
	 * @param isJobAvailable
	 * @return list of user details
	 */
	@RequestMapping(value = "/getFUFeebackDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreeLanceStarReviewFBEntity>> getFUFeebackDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<FreeLanceStarReviewFBEntity> freelanceUserEntity = freeLanceOnServiceSVC
				.getFUFeebackDetailsUserId(userId);
		return new ResponseEntity<ArrayList<FreeLanceStarReviewFBEntity>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All bell notification to the platform.
	 * 
	 * @return list of notification view details
	 */
	@RequestMapping(value = "/getAllBellNotificationDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<AllBellNotificationsView>> getAllBellNotificationDetails() {
		ArrayList<AllBellNotificationsView> allBellNotificationsViews = freeLanceOnServiceSVC
				.getAllBellNotificationDetails();
		return new ResponseEntity<ArrayList<AllBellNotificationsView>>(allBellNotificationsViews, HttpStatus.OK);
	}
}

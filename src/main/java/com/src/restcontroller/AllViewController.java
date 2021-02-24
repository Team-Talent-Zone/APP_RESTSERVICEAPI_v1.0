package com.src.restcontroller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.constant.NewServiceConstant;
import com.src.constant.UserConstant;
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

@Controller
public class AllViewController extends AbstractRestManager {

	@RequestMapping(value = "/getGraphFURatingData/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<GraphFURRatingView>> getGraphFURatingData() {
		ArrayList<GraphFURRatingView> data = allViewSvc.getGraphFURatingData();
		return new ResponseEntity<ArrayList<GraphFURRatingView>>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getGraphJobsData/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<GraphJobsDataView>> getGraphJobsData() {
		ArrayList<GraphJobsDataView> data = allViewSvc.getGraphJobsData();
		return new ResponseEntity<ArrayList<GraphJobsDataView>>(data, HttpStatus.OK);

	}

	@RequestMapping(value = "/getGraphSkillBasedData/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<GraphSkillBaseDataView>> getGraphSkillBasedData() {
		ArrayList<GraphSkillBaseDataView> data = allViewSvc.getGraphSkillBasedData();
		return new ResponseEntity<ArrayList<GraphSkillBaseDataView>>(data, HttpStatus.OK);

	}

	@RequestMapping(value = "/getGraphUserServiceData/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<GraphUserServiceDataView>> getGraphUserServiceData() {
		ArrayList<GraphUserServiceDataView> data = allViewSvc.getGraphUserServiceData();
		return new ResponseEntity<ArrayList<GraphUserServiceDataView>>(data, HttpStatus.OK);

	}

	@RequestMapping(value = "/getGraphSKVoliationData/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<GraphSkillWorkerVoliationDataView>> getGraphSKVoliationData() {
		ArrayList<GraphSkillWorkerVoliationDataView> data = allViewSvc.getGraphSKVoliationData();
		return new ResponseEntity<ArrayList<GraphSkillWorkerVoliationDataView>>(data, HttpStatus.OK);

	}

	/**
	 * Get All Bell Notification by userId
	 * 
	 */
	@RequestMapping(value = "/getAllBellNotifications/{uid}/{visibility}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<AllBellNotificationsView>> getAllBellNotifications(
			@PathVariable(NewServiceConstant.USER_SERVICE_DETAILS_UID) int uid,
			@PathVariable(NewServiceConstant.USER_SERVICE_DETAILS_VISIBLITY) String visibility) {
		ArrayList<AllBellNotificationsView> listofServiceExpirations = allViewSvc.getAllBellNotifications(uid,
				visibility);
		return new ResponseEntity<ArrayList<AllBellNotificationsView>>(listofServiceExpirations, HttpStatus.OK);
	}

	/**
	 * Get All Bell Notification by role code
	 * 
	 */
	@RequestMapping(value = "/getAllAdminBellNotifications/{visibility}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<AllBellNotificationsView>> getAllAdminBellNotifications(
			@PathVariable(NewServiceConstant.USER_SERVICE_DETAILS_VISIBLITY) String visibility) {
		ArrayList<AllBellNotificationsView> listofServiceExpirations = allViewSvc
				.getAllAdminBellNotifications(visibility);
		return new ResponseEntity<ArrayList<AllBellNotificationsView>>(listofServiceExpirations, HttpStatus.OK);
	}

	/**
	 * Get User Service Details when service end date after 2 days
	 * 
	 */
	@RequestMapping(value = "/getUserServiceExpirationDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceExpirationDetailsView>> getUserServiceExpirationDetails() {
		ArrayList<UserServiceExpirationDetailsView> listofServiceExpirations = allViewSvc
				.getUserServiceExpirationDetails();
		return new ResponseEntity<ArrayList<UserServiceExpirationDetailsView>>(listofServiceExpirations, HttpStatus.OK);
	}

	/**
	 * Get UserService Notification Details when userId
	 * 
	 * @param userId
	 * @return list of user details
	 * 
	 */
	@RequestMapping(value = "/getUserServiceNotificationDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceNotificationDetailsView>> getUserServiceNotificationDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<UserServiceNotificationDetailsView> userServiceNotificationDetailsViews = allViewSvc
				.getUserServiceNotificationDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<UserServiceNotificationDetailsView>>(userServiceNotificationDetailsViews,
				HttpStatus.OK);
	}

	/**
	 * Get the List of all User Service Details by UserId.
	 * 
	 * @param userId
	 */

	@RequestMapping(value = "/getAllUserServiceDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceActiveDetailsView>> getAllUserServiceDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<UserServiceActiveDetailsView> listofAllUserService = allViewSvc
				.getAllUserServiceDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<UserServiceActiveDetailsView>>(listofAllUserService, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllUserServiceDetailsView/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceActiveDetailsView>> getAllUserServiceDetailsView() {
		ArrayList<UserServiceActiveDetailsView> listofAllUserService = allViewSvc.getAllUserServiceDetailsView();
		return new ResponseEntity<ArrayList<UserServiceActiveDetailsView>>(listofAllUserService, HttpStatus.OK);
	}

	/**
	 * Get User Notification Details when userId
	 * 
	 * @param userId
	 * @return list of user details
	 * 
	 */
	@RequestMapping(value = "/getNotificationDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserNotificationDetailsView>> getNotificationDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<UserNotificationDetailsView> userNotificationDetailsEntityViews = allViewSvc
				.getNotificationDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<UserNotificationDetailsView>>(userNotificationDetailsEntityViews,
				HttpStatus.OK);
	}

	/**
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getPaymentFUDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<PaymentHistoryFUView>> getPaymentFUDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<PaymentHistoryFUView> paymentEntity = allViewSvc.getPaymentFUDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<PaymentHistoryFUView>>(paymentEntity, HttpStatus.OK);
	}

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getPaymentCBADetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<PaymentHistoryCBAView>> getPaymentCBADetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<PaymentHistoryCBAView> paymentEntity = allViewSvc.getPaymentCBADetailsByUserId(userId);
		return new ResponseEntity<ArrayList<PaymentHistoryCBAView>>(paymentEntity, HttpStatus.OK);
	}

	/**
	 * Get All New Service Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllNewServiceDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<AllActiveNewSeviceDetailsView>> getAllServiceDetails() {
		ArrayList<AllActiveNewSeviceDetailsView> listofAllServices = allViewSvc.getAllServiceDetails();
		return new ResponseEntity<ArrayList<AllActiveNewSeviceDetailsView>>(listofAllServices, HttpStatus.OK);
	}

	/**
	 * Get the Free Lancer On Service Details when service end date after 2 days
	 * 
	 */
	@RequestMapping(value = "/getFUOnServiceExpirationDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreeLanceOnServiceExpirationDetailsView>> getFUOnServiceExpirationDetails() {
		ArrayList<FreeLanceOnServiceExpirationDetailsView> listofFUOnServiceExpirations = allViewSvc
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
		ArrayList<FreeLanceOnServiceNotificationDetailsView> freeLanceOnServiceNotificationDetailsViews = allViewSvc
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
		ArrayList<FreelanceOnServiceSearchView> freelanceUserEntity = allViewSvc.getUserDetailsByJobAvailable();
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
		ArrayList<FreelancerAvailableStartDateStoreProc> freelanceUserEntity = allViewSvc
				.getUserDetailsByJobAvailableByCreateOn(jobcreatedon, scategory);
		return new ResponseEntity<ArrayList<FreelancerAvailableStartDateStoreProc>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All FU User Job Details By Category
	 */

	@RequestMapping(value = "/getUserAllJobDetailsBySubCategory/{scategory}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllJobDetails(
			@PathVariable(UserConstant.JOB_SUBCATEGORY) String scategory) {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = allViewSvc
				.getUserAllJobDetailsBySubCategory(scategory);
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All FU User Job Details
	 */

	@RequestMapping(value = "/getUserAllJobDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllJobDetails() {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = allViewSvc.getUserAllJobDetails();
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All Job Details By UserId (CBA)
	 */

	@RequestMapping(value = "/getUserAllJobDetailsByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllJobDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = allViewSvc
				.getUserAllJobDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * Get All Job Details By JobId  */

	@RequestMapping(value = "/getUserAllJobDetailsByJobId/{jobId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreelanceOnServiceJobPostedView> getUserAllJobDetailsByJobId(
			@PathVariable(UserConstant.JOB_ID) int jobId) {
		FreelanceOnServiceJobPostedView freelanceUserEntity = allViewSvc
				.getUserAllJobDetailsByJobId(jobId);
		return new ResponseEntity<FreelanceOnServiceJobPostedView>(freelanceUserEntity, HttpStatus.OK);
	}
	
	/**
	 * Get All Job Details By Freelancer Id
	 */

	@RequestMapping(value = "/getUserAllJobDetailsByFreelancerId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllJobDetailsByFreelancerId(
			@PathVariable(UserConstant.USERID) int userId) {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = allViewSvc
				.getUserAllJobDetailsByFreelancerId(userId);
		return new ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>>(freelanceUserEntity, HttpStatus.OK);
	}

	/**
	 * List of Freelancers to whom company has to pay the job invoice amount
	 */

	@RequestMapping(value = "/getUserAllPendingPaymentOfFreelancer/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<FreelanceOnServiceJobPostedView>> getUserAllPendingPaymentOfFreelancer() {
		ArrayList<FreelanceOnServiceJobPostedView> freelanceUserEntity = allViewSvc
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
		ArrayList<FreeLanceTestimonialsDetailsView> freelanceUserEntity = allViewSvc.getFUFeebackDetails();
		return new ResponseEntity<ArrayList<FreeLanceTestimonialsDetailsView>>(freelanceUserEntity, HttpStatus.OK);
	}

	

	/**
	 * Get All bell notification to the platform.
	 * 
	 * @return list of notification view details
	 */
	@RequestMapping(value = "/getAllBellNotificationDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<AllBellNotificationsView>> getAllBellNotificationDetails() {
		ArrayList<AllBellNotificationsView> allBellNotificationsViews = allViewSvc.getAllBellNotificationDetails();
		return new ResponseEntity<ArrayList<AllBellNotificationsView>>(allBellNotificationsViews, HttpStatus.OK);
	}
}

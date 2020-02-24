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
import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceExpirationDetailsView;
import com.src.entity.UserServiceNotfications;
import com.src.entity.UserServiceNotificationDetailsView;

/**
 * The <code> UserServiceDetailsController </code> class defines managed beans
 * which provides back-end functionality on the
 * <code>User Service Details</code> pages.
 * 
 * @author Shanoor
 *
 */
@Controller
public class UserServiceDetailsController extends AbstractRestManager {

	/**
	 * Method is to save User Service Details.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveUserServiceDetails/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceDetailsEntity> saveUserServiceDetails(
			@RequestBody UserServiceDetailsEntity userServiceDetailsObject) {
		UserServiceDetailsEntity UserServiceDetailsEntity = userServiceDetailsService
				.saveUserServiceDetails(userServiceDetailsObject);
		return new ResponseEntity<UserServiceDetailsEntity>(UserServiceDetailsEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save or Update the User Service Details.
	 * 
	 * @param saveOrUpdateUserSVCDetails
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateUserSVCDetails/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceDetailsEntity> saveOrUpdateUserSVCDetails(
			@RequestBody UserServiceDetailsEntity userServiceDetailsEntityObject) {
		UserServiceDetailsEntity userServiceDetailsEntity = userServiceDetailsService
				.saveOrUpdateUserSVCDetails(userServiceDetailsEntityObject);
		return new ResponseEntity<UserServiceDetailsEntity>(userServiceDetailsEntity, HttpStatus.OK);
	}

	/**
	 * Get the User Service Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getUserServiceDetailsByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceDetailsEntity> getUserServiceDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		UserServiceDetailsEntity userServiceDetailsEntity = userServiceDetailsService
				.getUserServiceDetailsByUserId(userId);
		return new ResponseEntity<UserServiceDetailsEntity>(userServiceDetailsEntity, HttpStatus.OK);
	}

	/**
	 * Get the User Service Details by Service Id.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getUserServiceDetailsByServiceId/{serviceId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceDetailsEntity> getUserServiceDetailsByServiceId(
			@PathVariable(UserConstant.SERVICEID) int serviceId) {
		UserServiceDetailsEntity userServiceDetailsEntity = userServiceDetailsService
				.getUserServiceDetailsByServiceId(serviceId);
		return new ResponseEntity<UserServiceDetailsEntity>(userServiceDetailsEntity, HttpStatus.OK);
	}

	/**
	 * Get All User Service Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllUserServiceDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceDetailsEntity>> getAllUserServiceDetails() {
		ArrayList<UserServiceDetailsEntity> listofAllUserService = userServiceDetailsService.getAllUserServiceDetails();
		return new ResponseEntity<ArrayList<UserServiceDetailsEntity>>(listofAllUserService, HttpStatus.OK);
	}

	/**
	 * Method is to User Service Notification.
	 * 
	 * @param saveUserServiceNotification
	 * @return
	 */
	@RequestMapping(value = "/saveUserServiceNotification/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceNotfications> saveUserServiceNotification(
			@RequestBody UserServiceNotfications userServiceNotficationObject) {
		UserServiceNotfications userServiceNotficationEntity = userServiceDetailsService
				.saveUserServiceNotification(userServiceNotficationObject);
		return new ResponseEntity<UserServiceNotfications>(userServiceNotficationEntity, HttpStatus.OK);
	}

	/**
	 * Get User Service Details when service end date after 2 days
	 * 
	 */
	@RequestMapping(value = "/getUserServiceExpirationDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceExpirationDetailsView>> getUserServiceExpirationDetails() {
		ArrayList<UserServiceExpirationDetailsView> listofServiceExpirations = userServiceDetailsService
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
		ArrayList<UserServiceNotificationDetailsView> userServiceNotificationDetailsViews = userServiceDetailsService
				.getUserServiceNotificationDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<UserServiceNotificationDetailsView>>(userServiceNotificationDetailsViews,
				HttpStatus.OK);
	}
	
	/**
	 * Get User Service Details when service is pending with payment
	 * 
	 */
	@RequestMapping(value = "/getUserServicePendingPayment/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserServiceDetailsEntity>> getUserServicePendingPayment() {
		ArrayList<UserServiceDetailsEntity> serviceDetailsEntities = userServiceDetailsService
				.getUserServicePendingPayment();
		return new ResponseEntity<ArrayList<UserServiceDetailsEntity>>(serviceDetailsEntities, HttpStatus.OK);
	}
}

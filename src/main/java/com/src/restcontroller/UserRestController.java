package com.src.restcontroller;

import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.constant.UserConstant;
import com.src.entity.FreeLanceDocumentsEntity;
import com.src.entity.FreeLanceHistoryEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserNotificationDetailsView;
import com.src.entity.UserNotificationEntity;

/**
 * The <code> UserRestController </code> class defines managed beans which
 * provides back-end functionality or the <code>UserDetails</code> pages.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */

@Controller
public class UserRestController extends AbstractRestManager {

	/**
	 * Get the User Details by UserName.
	 * 
	 * @param username
	 * @throws JSONException
	 */
	@RequestMapping(value = "/findByUsername/{username}/{password}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> findByUsername(@PathVariable(UserConstant.USERNAME) String username,
			@PathVariable(UserConstant.USERPSWD) String password) {
		UserEntity userEntity = userDetailsService.findByUsername(username, password);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Get the User Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getUserByUserId/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> getUserByUserId(@PathVariable(UserConstant.USERID) int userId) {
		UserEntity userEntity = userDetailsService.getUserByUserId(userId);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Get All User Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllUsers/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserEntity>> getAllUsers() {
		ArrayList<UserEntity> listofAllUsers = userDetailsService.getAllUsers();
		return new ResponseEntity<ArrayList<UserEntity>>(listofAllUsers, HttpStatus.OK);
	}

	/**
	 * Get User Details by the Role.
	 * 
	 * @param role
	 */
	@RequestMapping(value = "/getUsersByRole/{role}/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserEntity>> getUsersByRole(@PathVariable(UserConstant.ROLE) String role) {
		ArrayList<UserEntity> listOfBusinessAdminUsers = userDetailsService.getUsersByRole(role);
		return new ResponseEntity<ArrayList<UserEntity>>(listOfBusinessAdminUsers, HttpStatus.OK);
	}

	/**
	 * Update or Edit on user details.
	 * 
	 * @param userEntityObj
	 * @return user details
	 */
	@RequestMapping(value = "/saveorupdateuser/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> saveorupdateUserDetails(@RequestBody UserEntity userEntityObj) {
		UserEntity userEntity = userDetailsService.saveorupdateUserDetails(userEntityObj);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Save the User based on the role . Roles are (CBA , CSST , CSSM and FU ).
	 *
	 * 
	 * @param userEntityObject
	 * @return user details
	 */
	@RequestMapping(value = "/saveUser/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntityObject) {
		UserEntity userEntity = userDetailsService.saveUser(userEntityObject);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Save the User Notification history.
	 * 
	 * @param userEntityObject
	 * @return user notificaiton history details
	 */
	@RequestMapping(value = "/saveUserNotification/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserNotificationEntity> saveUserNotification(
			@RequestBody UserNotificationEntity userNotificationEntity) {
		UserNotificationEntity notificationEntity = userDetailsService.saveUserNotification(userNotificationEntity);
		return new ResponseEntity<UserNotificationEntity>(notificationEntity, HttpStatus.OK);
	}

	/**
	 * Check the userName if exist.
	 * 
	 * @param username
	 * @return user details
	 */
	@RequestMapping(value = "/checkusername/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> checkUsername(@PathVariable(UserConstant.USERNAME) String username) {
		UserEntity userEntity = userDetailsService.checkUsername(username);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Check the userName if not exist.
	 * 
	 * @param username
	 * @return boolean
	 */
	@RequestMapping(value = "/checkusernamenotexist/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkUsernameNotExist(@PathVariable(UserConstant.USERNAME) String username) {
		boolean isusernotexist = userDetailsService.checkUsernameNotExist(username);
		return new ResponseEntity<Boolean>(isusernotexist, HttpStatus.OK);
	}

	/**
	 * Saves the new password by encrypting.
	 * 
	 * @param username
	 * @return user details
	 */
	@RequestMapping(value = "/forgetPassword/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> forgetPassword(@PathVariable(UserConstant.USERNAME) String username) {
		return new ResponseEntity<UserEntity>(userDetailsService.forgetPassword(username), HttpStatus.OK);
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
		ArrayList<UserNotificationDetailsView> userNotificationDetailsEntityViews = userDetailsService
				.getNotificationDetailsByUserId(userId);
		return new ResponseEntity<ArrayList<UserNotificationDetailsView>>(userNotificationDetailsEntityViews,
				HttpStatus.OK);
	}

	/**
	 * 
	 * @param isrecoverypwd
	 * @return list of user details
	 */
	@RequestMapping(value = "/getUserByRecoveryPwd/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserEntity>> getUserByRecoveryPwd() {
		ArrayList<UserEntity> userEntity = userDetailsService.getUserByRecoveryPwd();
		return new ResponseEntity<ArrayList<UserEntity>>(userEntity, HttpStatus.OK);
	}

	/**
	 * Get User Freelance Details when incomplete profile.
	 * 
	 * @return list of user details
	 */
	@RequestMapping(value = "/getFUUserDetailsWhenInCompleteProfile/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserEntity>> getFUUserDetailsWhenInCompleteProfile() {
		ArrayList<UserEntity> freelanceUserEntities = userDetailsService.getFUUserDetailsWhenInCompleteProfile();
		return new ResponseEntity<ArrayList<UserEntity>>(freelanceUserEntities, HttpStatus.OK);
	}

	/**
	 * Method is to save FreeLancer History.
	 * 
	 * @param freeLanceHistoryEntityO
	 * @return
	 */
	@RequestMapping(value = "/saveFreeLanceHistory/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceHistoryEntity> saveFreeLanceHistory(
			@RequestBody FreeLanceHistoryEntity freeLanceHistoryEntity) {
		FreeLanceHistoryEntity historyEntity = userDetailsService.saveFreeLanceHistory(freeLanceHistoryEntity);
		return new ResponseEntity<FreeLanceHistoryEntity>(historyEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save FreeLancer Documents.
	 * 
	 * @param freeLanceDocumentsEntity
	 * @return
	 */
	@RequestMapping(value = "/saveFreeLanceDocument/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceDocumentsEntity> saveFreeLanceDocument(
			@RequestBody FreeLanceDocumentsEntity freeLanceDocumentsEntity) {
		FreeLanceDocumentsEntity docEntity = userDetailsService.saveFreeLanceDocument(freeLanceDocumentsEntity);
		return new ResponseEntity<FreeLanceDocumentsEntity>(docEntity, HttpStatus.OK);
	}

	/**
	 * Saves the new password by encrypting for admin signup.
	 * 
	 * @param username
	 * @return user details
	 */
	@RequestMapping(value = "/prepareAdminToSignUp/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> prepareAdminToSignUp(@PathVariable(UserConstant.USERNAME) String username) {
		return new ResponseEntity<UserEntity>(userDetailsService.prepareAdminToSignUp(username), HttpStatus.OK);
	}
}
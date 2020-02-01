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
import com.src.entity.UserEntity;

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
	@RequestMapping(value = "/getUser/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> loginUserByUsername(@PathVariable(UserConstant.USERNAME) String username)
			throws JSONException {
		UserEntity userEntity = userService.findByUsername(username);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Get the User Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getUserByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> getUserByUserId(@PathVariable(UserConstant.USERID) int userId) {
		UserEntity userEntity = userService.getUserByUserId(userId);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Get All User Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllUsers/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserEntity>> manageUsers() {
		ArrayList<UserEntity> listofAllUsers = userService.getAllUsers();
		return new ResponseEntity<ArrayList<UserEntity>>(listofAllUsers, HttpStatus.OK);
	}

	/**
	 * Get User Details by the Role.
	 * 
	 * @param role
	 */
	@RequestMapping(value = "/getUsersByRole/{role}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserEntity>> getUsersByRole(@PathVariable(UserConstant.ROLE) String role) {
		ArrayList<UserEntity> listOfBusinessAdminUsers = userService.getUsersByRole(role);
		return new ResponseEntity<ArrayList<UserEntity>>(listOfBusinessAdminUsers, HttpStatus.OK);
	}

	/**
	 * Update or Edit on user Details Screen.
	 * 
	 * @param userEntityObj
	 */
	@RequestMapping(value = "/saveorupdateuser/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> saveorupdateUserDetails(@RequestBody UserEntity userEntityObj) {
		UserEntity userEntity = userService.saveorupdateUserDetails(userEntityObj);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Save the CBA (client business administration and freelance ) User Details.
	 * 
	 * @param userEntityObject
	 * @return
	 */
	@RequestMapping(value = "/saveUser/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntityObject) {
		UserEntity userEntity = userService.saveUser(userEntityObject);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 */
	@RequestMapping(value = "/checkusername/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> checkUsername(@PathVariable(UserConstant.USERNAME) String username) {
		UserEntity userEntity = userService.checkUsername(username);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	/**
	 * Check the UserName from the Database.
	 * 
	 * @param username
	 */
	@RequestMapping(value = "/checkusernamenotexist/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkUsernameNotExist(@PathVariable(UserConstant.USERNAME) String username) {
		boolean isusernotexist = userService.checkUsernameNotExist(username);
		return new ResponseEntity<Boolean>(isusernotexist, HttpStatus.OK);
	}

	/**
	 * Saves the new password by encrypting.
	 * 
	 * @param username
	 */
	@RequestMapping(value = "/forgetPassword/{username}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> forgetPassword(@PathVariable(UserConstant.USERNAME) String username) {
		return new ResponseEntity<UserEntity>(userService.forgetPassword(username), HttpStatus.OK);
	}


	/**
	 * 
	 * @param isrecoverypwd
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value = "/getUserByRecoveryPwd/{isrecoverypwd}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserEntity>> getUserByRecoveryPwd(
			@PathVariable(UserConstant.ISRECOVERYPWD) Boolean isrecoverypwd) throws JSONException {
		ArrayList<UserEntity> userEntity = userService.getUserByRecoveryPwd(isrecoverypwd);
		return new ResponseEntity<ArrayList<UserEntity>>(userEntity, HttpStatus.OK);
	}
	

}
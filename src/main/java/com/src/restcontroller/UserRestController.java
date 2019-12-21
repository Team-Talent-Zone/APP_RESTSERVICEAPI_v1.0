package com.src.restcontroller;

import java.util.ArrayList;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.UserEntity;

@Controller
public class UserRestController extends AbstractRestController {
	final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@RequestMapping(value = "/getUser/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> loadUserByUsername(@PathVariable("username") String username)
			throws JSONException {
		UserEntity userEntity = userService.findByUsername(username);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> getUserByUserId(@PathVariable("userId") int userId) {
		UserEntity userEntity = userService.getUserByUserId(userId);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllUsers/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserEntity>> manageUsers() {
		ArrayList<UserEntity> listofAllUsers = userService.getAllUsers();
		return new ResponseEntity<ArrayList<UserEntity>>(listofAllUsers, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUsersByRole/{role}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserEntity>> getUsersByRole(@PathVariable("role") String role) {
		ArrayList<UserEntity> listOfBusinessAdminUsers = userService.getUsersByRole(role);
		return new ResponseEntity<ArrayList<UserEntity>>(listOfBusinessAdminUsers, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveorupdateuser", method = RequestMethod.POST)
	public ResponseEntity<UserEntity> saveorupdateUserDetails(@RequestBody UserEntity userEntityObj) {
		UserEntity userEntity = userService.saveorupdateUserDetails(userEntityObj);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveUser/", method = RequestMethod.POST)
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntityObject) {
		UserEntity userEntity = userService.saveUser(userEntityObject);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/checkusername/{username}/", method = RequestMethod.GET)
	public ResponseEntity<UserEntity> checkUsername(@PathVariable("username") String username) {
		return new ResponseEntity<UserEntity>(userService.checkUsername(username), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllUsersNotNotificatedToTeam", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserEntity>> getAllUsersNotNotificatedToTeam() {
		return new ResponseEntity<ArrayList<UserEntity>>(userService.getAllUsersNotNotificatedToTeam(), HttpStatus.OK);
	}
}
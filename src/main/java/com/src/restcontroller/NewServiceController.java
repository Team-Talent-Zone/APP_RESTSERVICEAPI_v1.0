package com.src.restcontroller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;
import com.src.entity.UserServiceDetailsEntity;

/**
 * The <code> NewServiceController </code> class defines managed beans which
 * provides back-end functionality or the <code>NewService</code> pages.
 * 
 * @author Shanoor
 *
 */
@Controller
public class NewServiceController extends AbstractRestManager {
	/**
	 * Method is to save New Service.
	 * 
	 * @param newServiceEntityObject
	 */
	@RequestMapping(value = "/saveNewService/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServiceEntity> saveNewService(@RequestBody NewServiceEntity newServiceEntityObject) {
		NewServiceEntity newServiceEntity = newServiceSvc.saveNewService(newServiceEntityObject);
		return new ResponseEntity<NewServiceEntity>(newServiceEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save or Update the New Service.
	 * 
	 * @param newServiceEntityObject
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateNewService/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServiceEntity> saveorupdateNewService(
			@RequestBody NewServiceEntity newServiceEntityObject) {
		NewServiceEntity newServiceEntity = newServiceSvc.saveOrUpdateNewService(newServiceEntityObject);
		return new ResponseEntity<NewServiceEntity>(newServiceEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save New Service History.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveNewServiceHistory/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServiceHistoryEntity> saveNewServiceHistory(
			@RequestBody NewServiceHistoryEntity newServiceHistoryObject) {
		NewServiceHistoryEntity newServiceHistoryEntity = newServiceSvc.saveNewServiceHistory(newServiceHistoryObject);
		return new ResponseEntity<NewServiceHistoryEntity>(newServiceHistoryEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save New Service History.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveNewServicePackage/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServicePackageEntity>> saveNewServicePackage(
			@RequestBody ArrayList<NewServicePackageEntity> servicePackageEntities) {
		ArrayList<NewServicePackageEntity> packageEntities = newServiceSvc
				.saveNewServicePackage(servicePackageEntities);
		return new ResponseEntity<ArrayList<NewServicePackageEntity>>(packageEntities, HttpStatus.OK);
	}

	/**
	 * Get All User Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllServiceDetails/", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServiceEntity>> getAllServiceDetails() {
		ArrayList<NewServiceEntity> listofAllServices = newServiceSvc.getAllServiceDetails();
		return new ResponseEntity<ArrayList<NewServiceEntity>>(listofAllServices, HttpStatus.OK);
	}

	/**
	 * Method is to save User Service Details.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveUserServiceDetails/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceDetailsEntity> saveUserServiceDetails(
			@RequestBody UserServiceDetailsEntity userServiceDetailsObject) {
		UserServiceDetailsEntity UserServiceDetailsEntity = newServiceSvc
				.saveUserServiceDetails(userServiceDetailsObject);
		return new ResponseEntity<UserServiceDetailsEntity>(UserServiceDetailsEntity, HttpStatus.OK);
	}
	
	/**
	 * Method is to save Free Lance On Service Details.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveFreeLanceOnService/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceEntity> saveFreeLanceOnService(
			@RequestBody FreeLanceOnServiceEntity freeLanceOnServiceEntityObject) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = newServiceSvc
				.saveFreeLanceOnService(freeLanceOnServiceEntityObject);
		return new ResponseEntity<FreeLanceOnServiceEntity>(freeLanceOnServiceEntity, HttpStatus.OK);
	}
	
	/**
	 * Method is to save or Update the User Service Details.
	 * 
	 * @param saveOrUpdateUserSVCDetails
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateUserSVCDetails/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserServiceDetailsEntity> saveOrUpdateUserSVCDetails(
			@RequestBody UserServiceDetailsEntity userServiceDetailsEntityObject) {
		UserServiceDetailsEntity userServiceDetailsEntity = newServiceSvc.saveOrUpdateUserSVCDetails(userServiceDetailsEntityObject);
		return new ResponseEntity<UserServiceDetailsEntity>(userServiceDetailsEntity, HttpStatus.OK);
	}
																	
	
	/**
	 * Method is to save or Update the Free Lance On Service.
	 * 
	 * @param saveOrUpdateFreeLanceOnService
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateFreeLanceOnService/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FreeLanceOnServiceEntity> saveOrUpdateFreeLanceOnService(
			@RequestBody FreeLanceOnServiceEntity freeLanceOnServiceEntityObject) {
		FreeLanceOnServiceEntity freeLanceOnServiceEntity = newServiceSvc.saveOrUpdateFreeLanceOnService(freeLanceOnServiceEntityObject);
		return new ResponseEntity<FreeLanceOnServiceEntity>(freeLanceOnServiceEntity, HttpStatus.OK);
	}

}

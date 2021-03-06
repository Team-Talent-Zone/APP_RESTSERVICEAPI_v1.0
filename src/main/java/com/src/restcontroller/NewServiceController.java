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

import com.src.constant.NewServiceConstant;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;

/**
 * The <code> NewServiceController </code> class defines managed beans which
 * provides back-end functionality on the <code>NewService</code> pages.
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
	@RequestMapping(value = "/saveNewService/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(value = "/saveOrUpdateNewService/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(value = "/saveNewServiceHistory/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServiceHistoryEntity> saveNewServiceHistory(
			@RequestBody NewServiceHistoryEntity newServiceHistoryObject) {
		NewServiceHistoryEntity newServiceHistoryEntity = newServiceSvc.saveNewServiceHistory(newServiceHistoryObject);
		return new ResponseEntity<NewServiceHistoryEntity>(newServiceHistoryEntity, HttpStatus.OK);
	}

	/**
	 * Get All New Service Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllNewServices/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServiceEntity>> getAllNewServices() {
		ArrayList<NewServiceEntity> listofAllServices = newServiceSvc.getAllNewServices();
		return new ResponseEntity<ArrayList<NewServiceEntity>>(listofAllServices, HttpStatus.OK);
	}
	


	/**
	 * Get New Service Details by service id.
	 *  
	 */
	@RequestMapping(value = "/getNewServiceDetailsByServiceId/{ourserviceId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServiceEntity> getNewServiceDetailsByServiceId(
			@PathVariable(NewServiceConstant.OURSERVICEID) int ourserviceId) {
		NewServiceEntity services = newServiceSvc.getNewServiceDetailsByServiceId(ourserviceId);
		return new ResponseEntity<NewServiceEntity>(services, HttpStatus.OK);
	}

	/**
	 * Get New Service Details by service name.
	 * 
	 */
	@RequestMapping(value = "/checkNewServiceIsExist/{name}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Boolean>  checkNewServiceIsExist(
			@PathVariable(NewServiceConstant.NAME) String name) {
		boolean isusernotexist  = newServiceSvc.checkNewServiceIsExist(name);
		return new ResponseEntity<Boolean>(isusernotexist, HttpStatus.OK);
	}

	/**
	 * Get All New Service Details by managerId.
	 * 
	 * @param managerId
	 */
	@RequestMapping(value = "/getAllNewServiceDetailsByManagerId/{managerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServiceHistoryEntity>> getAllNewServiceDetailsByManagerId(
			@PathVariable(NewServiceConstant.MANAGEID) int managerId) {
		return new ResponseEntity<ArrayList<NewServiceHistoryEntity>>(
				newServiceSvc.getAllNewServiceDetailsByManagerId(managerId), HttpStatus.OK);
	}

	/**
	 * Get All New Service Details by userId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getAllNewServiceDetailsByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServiceHistoryEntity>> getAllNewServiceDetailsByUserId(
			@PathVariable(NewServiceConstant.USERID) int userId) {
		return new ResponseEntity<ArrayList<NewServiceHistoryEntity>>(
				newServiceSvc.getAllNewServiceDetailsByUserId(userId), HttpStatus.OK);
	}

	/**
	 * Get All New Service Details created today - 1
	 * 
	 */
	@RequestMapping(value = "/getNewServiceDetailsCreated/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServiceEntity>> getNewServiceDetailsCreated() {
		ArrayList<NewServiceEntity> newServiceEntities = newServiceSvc.getNewServiceDetailsCreated();
		return new ResponseEntity<ArrayList<NewServiceEntity>>(newServiceEntities, HttpStatus.OK);
	}
}

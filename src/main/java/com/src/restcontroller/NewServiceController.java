package com.src.restcontroller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;

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
	 * Method is to save New Service History.
	 * 
	 * @param newServiceHistoryObject
	 * @return
	 */
	@RequestMapping(value = "/saveNewServicePackage/", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServicePackageEntity> saveNewServicePackage(
			@RequestBody NewServicePackageEntity newServicePackageObject) {
		NewServicePackageEntity newServicePackageEntity = newServiceSvc.saveNewServicePackage(newServicePackageObject);
		return new ResponseEntity<NewServicePackageEntity>(newServicePackageEntity, HttpStatus.OK);
	}
	

	/**
	 * Get All User Details from the List.
	 * 
	 */
	@RequestMapping(value = "/getAllServiceDetails/", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NewServiceEntity>> getAllServiceDetails() {
		ArrayList<NewServiceEntity> listofAllServices = newServiceSvc.getAllServiceDetails();
		return new ResponseEntity<ArrayList<NewServiceEntity>>(listofAllServices, HttpStatus.OK);
	}

}

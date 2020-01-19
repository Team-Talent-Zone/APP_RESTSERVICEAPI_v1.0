package com.src.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.NewServiceEntity;

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
	@RequestMapping(value = "/saveNewService/", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NewServiceEntity> saveNewService(@RequestBody NewServiceEntity newServiceEntityObject) {
	
		NewServiceEntity newServiceEntity = newServiceSvc.saveNewService(newServiceEntityObject);
		return new ResponseEntity<NewServiceEntity>(newServiceEntity, HttpStatus.OK);
	}
}

package com.src.restcontroller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.ReferenceStaticDataEntity;

@Controller
public class LookUpStaticDataController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(LookUpStaticDataController.class);

	@RequestMapping(value = "/getLookupStaticDataEntityBykey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceStaticDataEntity>> getLookupStaticDataEntityBykey(
			@PathVariable("key") String key) {
		ArrayList<ReferenceStaticDataEntity> staticData = referenceLookUpService.getLookupStaticDataEntityBykey(key);
		return new ResponseEntity<ArrayList<ReferenceStaticDataEntity>>(staticData, HttpStatus.OK);
	}

	@RequestMapping(value = "/getLookupStaticDataEntity/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceStaticDataEntity>> getLookupStaticDataEntity() {
		ArrayList<ReferenceStaticDataEntity> staticData = referenceLookUpService.getLookupStaticDataEntity();
		return new ResponseEntity<ArrayList<ReferenceStaticDataEntity>>(staticData, HttpStatus.OK);
	}

}
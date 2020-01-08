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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.ReferenceLookUpEntity;

@Controller
public class ReferenceLookUpController extends AbstractRestManager {
	final Logger logger = LoggerFactory.getLogger(ReferenceLookUpController.class);

	@RequestMapping(value = "/getReferenceLookupByKey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceLookUpEntity>> getReferenceLookupByKey(@PathVariable("key") String key)
			throws JSONException {
		ArrayList<ReferenceLookUpEntity> referenceLookUpEntities = referenceLookUpService.getReferenceLookupByKey(key);
		return new ResponseEntity<ArrayList<ReferenceLookUpEntity>>(referenceLookUpEntities, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllReferenceLookupData/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ReferenceLookUpEntity>> getAllReferenceLookupData() {
		ArrayList<ReferenceLookUpEntity> referenceLookUpEntities = referenceLookUpService.getAllReferenceLookupData();
		return new ResponseEntity<ArrayList<ReferenceLookUpEntity>>(referenceLookUpEntities, HttpStatus.OK);
	}

	@RequestMapping(value = "/getReferenceLookupByShortKey/{shortkey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReferenceLookUpEntity> getReferenceLookupByShortKey(@PathVariable("shortkey") String shortkey)
			throws JSONException {
		ReferenceLookUpEntity referenceLookUpEntity = referenceLookUpService.getReferenceLookupByShortKey(shortkey);
		return new ResponseEntity<ReferenceLookUpEntity>(referenceLookUpEntity, HttpStatus.OK);
	}

}
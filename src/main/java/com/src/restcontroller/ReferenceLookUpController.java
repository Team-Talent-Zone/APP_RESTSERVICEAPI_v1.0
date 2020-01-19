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

import com.src.entity.ReferenceLookUpEntity;
import com.src.entity.ReferenceLookUpMappingEntity;
import com.src.entity.ReferenceLookUpMappingSubCategoryEntity;

@Controller
public class ReferenceLookUpController extends AbstractRestManager {
	final Logger logger = LoggerFactory.getLogger(ReferenceLookUpController.class);

	@RequestMapping(value = "/getReferenceLookupByKey/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceLookUpEntity>> getReferenceLookupByKey(@PathVariable("key") String key) {
		ArrayList<ReferenceLookUpEntity> referenceLookUpEntities = referenceLookUpService.getReferenceLookupByKey(key);
		return new ResponseEntity<ArrayList<ReferenceLookUpEntity>>(referenceLookUpEntities, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllReferenceLookupData/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceLookUpEntity>> getAllReferenceLookupData() {
		ArrayList<ReferenceLookUpEntity> referenceLookUpEntities = referenceLookUpService.getAllReferenceLookupData();
		return new ResponseEntity<ArrayList<ReferenceLookUpEntity>>(referenceLookUpEntities, HttpStatus.OK);
	}

	@RequestMapping(value = "/getReferenceLookupByShortKey/{shortkey}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> getReferenceLookupByShortKey(@PathVariable("shortkey") String shortkey) {
		return new ResponseEntity<String>(referenceLookUpService.getReferenceLookupByShortKey(shortkey), HttpStatus.OK);
	}

	@RequestMapping(value = "/getReferenceLookupMappingByRefId/{refId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceLookUpMappingEntity>> getReferenceLookupMappingByRefId(
			@PathVariable("refId") int refId) {
		return new ResponseEntity<ArrayList<ReferenceLookUpMappingEntity>>(
				referenceLookUpService.getReferenceLookupMappingByRefId(refId), HttpStatus.OK);
	}

	@RequestMapping(value = "/getReferenceLookupMappingSubCategoryByMapId/{mapId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<ReferenceLookUpMappingSubCategoryEntity>> getReferenceLookupMappingSubCategoryByMapId(
			@PathVariable("mapId") int mapId) {
		return new ResponseEntity<ArrayList<ReferenceLookUpMappingSubCategoryEntity>>(
				referenceLookUpService.getReferenceLookupMappingSubCategoryByMapId(mapId), HttpStatus.OK);
	}

}
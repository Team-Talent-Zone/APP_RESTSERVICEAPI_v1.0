package com.src.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.ReferenceLookUpTemplateEntity;

@Controller
public class LookUpTemplatesController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(LookUpTemplatesController.class);

	@RequestMapping(value = "/getLookupTemplateEntityByShortkey/{shortkey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReferenceLookUpTemplateEntity> getLookupTemplateEntityByShortkey(
			@PathVariable("shortkey") String shortkey) {
		ReferenceLookUpTemplateEntity lookUpTemplates = lookUpTemplateService
				.getLookupTemplateEntityByShortkey(shortkey);
		return new ResponseEntity<ReferenceLookUpTemplateEntity>(lookUpTemplates, HttpStatus.OK);
	}

}
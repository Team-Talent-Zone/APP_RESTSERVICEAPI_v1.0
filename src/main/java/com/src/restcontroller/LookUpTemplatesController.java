package com.src.restcontroller;

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

import com.src.entity.LookUpTemplateEntity;

@Controller
public class LookUpTemplatesController extends AbstractRestManager {
	final Logger logger = LoggerFactory.getLogger(LookUpTemplatesController.class);

	@RequestMapping(value = "/getLookupTemplateByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LookUpTemplateEntity> getLookupTemplateByName(@PathVariable("name") String name)
			throws JSONException {
		LookUpTemplateEntity lookUpTemplates = lookUpTemplateService.getLookupTemplateByName(name);
		return new ResponseEntity<LookUpTemplateEntity>(lookUpTemplates, HttpStatus.OK);
	}

}
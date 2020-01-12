package com.src.restcontroller;

import java.io.File;

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

import com.src.entity.UtilEntity;
import com.src.helper.SendEmailHelper;

@Controller
public class UtilityController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(UtilityController.class);

	@RequestMapping(value = "/uploadAvatarsInS3/{inputFile}/{userid}", method = RequestMethod.GET)
	public ResponseEntity<String> uploadAvatarsInS3(@PathVariable("inputFile") File inputFile,
			@PathVariable("userid") int userid) {
		String avatarURL = utilService.uploadAvatarsInS3(inputFile, userid);
		return new ResponseEntity<String>(avatarURL, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadBgDocsInS3/{inputFile}/{userid}", method = RequestMethod.GET)
	public ResponseEntity<String> uploadBgDocsInS3(@PathVariable("inputFile") File inputFile,
			@PathVariable("userid") int userid) {
		String bgDocURL = utilService.uploadBgDocsInS3(inputFile, userid);
		return new ResponseEntity<String>(bgDocURL, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadWidgetPicsInS3/{inputFile}/{userid}", method = RequestMethod.GET)
	public ResponseEntity<String> uploadWidgetPicsInS3(@PathVariable("inputFile") File inputFile,
			@PathVariable("userid") int userid) {
		String widgetURL = utilService.uploadWidgetPicsInS3(inputFile, userid);
		return new ResponseEntity<String>(widgetURL, HttpStatus.OK);

	}

	@RequestMapping(value = "/autoSendEmail/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> autoSendEmail(@RequestBody UtilEntity utilEntity) throws JSONException {
		UtilEntity utilEntityResponse = utilService.sendEmail(utilEntity);
		return new ResponseEntity<UtilEntity>(utilEntityResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/sendEmail/", method = RequestMethod.PUT)
	public ResponseEntity<UtilEntity> sendEmail(@RequestBody Object obj, @RequestBody String templateURL,
			@RequestBody String shortKey) throws JSONException {

		SendEmailHelper emailHelper = new SendEmailHelper();
		UtilEntity utilEntity = emailHelper.returnUtilEntityObjByShortKey(obj, templateURL, shortKey);
		UtilEntity utilEntityResponse = utilService.sendEmail(utilEntity);
		return new ResponseEntity<UtilEntity>(utilEntityResponse, HttpStatus.OK);
	}

}
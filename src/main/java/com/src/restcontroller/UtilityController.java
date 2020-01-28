package com.src.restcontroller;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.UtilEntity;

@Controller
public class UtilityController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(UtilityController.class);

	@RequestMapping(value = "/uploadavatar/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadAvatarsInS3(@RequestBody String jsonStr) throws JSONException {
		JSONObject jObject = new JSONObject(jsonStr);
		File inputFile = new File(jObject.get("inputFilePath").toString());
		String avatarURL = utilService.uploadAvatarsInS3(inputFile, (Integer) jObject.get("userid"));
		return new ResponseEntity<String>(avatarURL, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadbgdocs/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadBgDocsInS3(@RequestBody String jsonStr) throws JSONException {
		JSONObject jObject = new JSONObject(jsonStr);
		File inputFile = new File(jObject.get("inputFilePath").toString());
		String bgDocURL = utilService.uploadBgDocsInS3(inputFile, (Integer) jObject.get("userid"));
		return new ResponseEntity<String>(bgDocURL, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadwidgets/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadWidgetPicsInS3(@RequestBody String jsonStr) throws JSONException {
		JSONObject jObject = new JSONObject(jsonStr);
		File inputFile = new File(jObject.get("inputFilePath").toString());
		String widgetURL = utilService.uploadWidgetPicsInS3(inputFile, (Integer) jObject.get("userid"));
		return new ResponseEntity<String>(widgetURL, HttpStatus.OK);

	}

	@RequestMapping(value = "/autosendemail/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> autoSendEmail(@RequestBody UtilEntity utilEntity) throws JSONException {
		UtilEntity utilEntityResponse = utilService.sendEmail(utilEntity);
		return new ResponseEntity<UtilEntity>(utilEntityResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/sendemail/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> sendEmail(@RequestBody Object obj, @RequestBody String templateURL,
			@RequestBody String shortKey) throws JSONException {
		UtilEntity utilEntity = emailHelper.returnUtilEntityObjByShortKey(obj, templateURL, shortKey);
		UtilEntity utilEntityResponse = utilService.sendEmail(utilEntity);
		return new ResponseEntity<UtilEntity>(utilEntityResponse, HttpStatus.OK);
	}

}
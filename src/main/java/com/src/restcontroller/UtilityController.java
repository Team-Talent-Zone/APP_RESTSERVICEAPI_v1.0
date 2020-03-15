package com.src.restcontroller;

import java.io.File;

import org.apache.commons.io.FileUtils;
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

import com.google.gson.Gson;
import com.src.entity.UploadUtilEntity;
import com.src.entity.UtilEntity;
import com.src.utils.CommonUtilites;

@Controller
public class UtilityController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(UtilityController.class);

	@RequestMapping(value = "/uploadavatar/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadAvatarsInS3(@RequestBody UploadUtilEntity uploadUtilEntity) throws Exception {
		String base64Image = uploadUtilEntity.getBase64image().split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		File tempFile = new File(CommonUtilites.genRandomAlphaNumeric() + "_avatar.png");
		FileUtils.writeByteArrayToFile(tempFile, imageBytes);

		Gson gson = new Gson();
		String avatarURL = utilService.uploadAvatarsInS3(tempFile, uploadUtilEntity.getUserid());
		return new ResponseEntity<String>(gson.toJson(avatarURL), HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadbgdocs/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadBgDocsInS3(@RequestBody UploadUtilEntity uploadUtilEntity)
			throws Exception {
		String base64Image = uploadUtilEntity.getBase64image().split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		File tempFile = new File(CommonUtilites.genRandomAlphaNumeric() + "_bgDoc.pdf");
		FileUtils.writeByteArrayToFile(tempFile, imageBytes);
		Gson gson = new Gson();
		String bgDocURL = utilService.uploadBgDocsInS3(tempFile, uploadUtilEntity.getUserid());
		return new ResponseEntity<String>(gson.toJson(bgDocURL), HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadwidgets/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadWidgetPicsInS3(@RequestBody UploadUtilEntity uploadUtilEntity)
			throws Exception {
		String base64Image = uploadUtilEntity.getBase64image().split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		File tempFile = new File(CommonUtilites.genRandomAlphaNumeric() + "_widget.png");
		FileUtils.writeByteArrayToFile(tempFile, imageBytes);
		Gson gson = new Gson();
		String widgetURL = utilService.uploadWidgetPicsInS3(tempFile, uploadUtilEntity.getUserid());
		return new ResponseEntity<String>(gson.toJson(widgetURL), HttpStatus.OK);

	}

	@RequestMapping(value = "/sendemail/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> sendEmail(@RequestBody UtilEntity utilEntity) throws Exception {
		UtilEntity utilEntityResponse = utilService.sendEmail(utilEntity);
		return new ResponseEntity<UtilEntity>(utilEntityResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/translatetext/{targetText}/{targetLanguage}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> translateText(@PathVariable String targetLanguage,
			@PathVariable String targetText) throws Exception {
		String translateText = utilService.translateText(targetLanguage, targetText);
		UtilEntity util = new UtilEntity();
		util.setTranslateresp(translateText);
		return new ResponseEntity<UtilEntity>(util, HttpStatus.OK);

	}

}
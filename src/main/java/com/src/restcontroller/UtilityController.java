package com.src.restcontroller;

import java.io.IOException;

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

/**
 * The <code> UtilityController </code> class defines managed beans which
 * provides back-end functionality or the <code>UtilEntity</code> pages.
 * 
 * @author Ishaq
 *
 */

@Controller
public class UtilityController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(UtilityController.class);

	/**This method is for uploading an avatar as a display image.
	 * 
	 * @param uploadUtilEntity
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadavatar/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadAvatarsInS3(@RequestBody UploadUtilEntity uploadUtilEntity) throws IOException {
		Gson gson = new Gson();
		String avatarURL = utilService.uploadAvatarsInS3(uploadUtilEntity);
		return new ResponseEntity<String>(gson.toJson(avatarURL), HttpStatus.OK);
	}

	/**
	 * This method is for uploading background verification documents.
	 * 
	 * @param uploadUtilEntity
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadbgdocs/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadBgDocsInS3(@RequestBody UploadUtilEntity uploadUtilEntity) throws IOException {
		Gson gson = new Gson();
		String bgDocURL = utilService.uploadBgDocsInS3(uploadUtilEntity);
		return new ResponseEntity<String>(gson.toJson(bgDocURL), HttpStatus.OK);
	}

	/**
	 * This method is for uploading widgets.
	 * 
	 * @param uploadUtilEntity
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadwidgets/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadWidgetPicsInS3(@RequestBody UploadUtilEntity uploadUtilEntity)
			throws IOException {
		Gson gson = new Gson();
		String widgetURL = utilService.uploadWidgetPicsInS3(uploadUtilEntity);
		return new ResponseEntity<String>(gson.toJson(widgetURL), HttpStatus.OK);

	}

	/**
	 * This method is for generating an email notification.
	 * 
	 * @param utilEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendemail/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> sendEmail(@RequestBody UtilEntity utilEntity) throws Exception {
		UtilEntity utilEntityResponse = utilService.sendEmail(utilEntity);
		return new ResponseEntity<UtilEntity>(utilEntityResponse, HttpStatus.OK);
	}

	/**
	 * This method is for translating text.
	 * 
	 * @param targetLanguage
	 * @param targetText
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/translatetext/{targetText}/{targetLanguage}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtilEntity> translateText(@PathVariable String targetLanguage,
			@PathVariable String targetText)  {
		
		String translateText = utilService.translateText(targetLanguage, targetText);
		UtilEntity util = new UtilEntity();
		util.setTranslateresp(translateText);
		return new ResponseEntity<UtilEntity>(util, HttpStatus.OK);

	}

}
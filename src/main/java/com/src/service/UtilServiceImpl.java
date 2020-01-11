package com.src.service;

import java.io.File;

import org.apache.velocity.VelocityContext;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.src.entity.UtilEntity;
import com.src.helper.UtilHelper;

@Service("utilManager")
public class UtilServiceImpl implements UtilService {

	final static Logger logger = LoggerFactory.getLogger(UtilServiceImpl.class);

	public UtilEntity sendEmail(UtilEntity utilEntity) throws JSONException {
		UtilHelper utilHelper = new UtilHelper();
		VelocityContext velocityContext = utilHelper.generateVelocityObject(utilEntity.getJsonArray());
		String htmlFormat = utilHelper.generateEmailInHtmlFormat(utilEntity.getTemplateURL(), velocityContext);
		if (htmlFormat != null) {
			utilEntity.setBody(htmlFormat);
			utilEntity = utilHelper.prepareEmail(utilEntity);
		}
		return utilEntity;
	}

	public String uploadAvatarsInS3(File inputFile, int userid) {
		UtilHelper utilHelper = new UtilHelper();
		return utilHelper.uploadAvatarsInS3(inputFile, userid);
	}

	public String uploadBgDocsInS3(File inputFile, int userid) {
		UtilHelper utilHelper = new UtilHelper();
		return utilHelper.uploadBgDocsInS3(inputFile, userid);
	}

	public String uploadWidgetPicsInS3(File inputFile, int userid) {
		UtilHelper utilHelper = new UtilHelper();
		return utilHelper.uploadWidgetPicsInS3(inputFile, userid);
	}


}

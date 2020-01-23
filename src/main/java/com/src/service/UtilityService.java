package com.src.service;

import java.io.File;

import org.json.JSONException;

import com.src.entity.UtilEntity;

public interface UtilityService {

	public UtilEntity sendEmail(UtilEntity utilEntity) throws JSONException;
	
	public String uploadAvatarsInS3(File inputFile, int userid);

	public String uploadBgDocsInS3(File inputFile, int userid);

	public String uploadWidgetPicsInS3(File inputFile, int userid);

}

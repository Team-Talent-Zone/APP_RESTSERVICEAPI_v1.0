package com.src.service;

import java.io.File;

import com.src.entity.UtilEntity;

public interface UtilityService {

	public UtilEntity sendEmail(UtilEntity utilEntity) throws Exception ;
	
	public String uploadAvatarsInS3(File inputFile, int userid);

	public String uploadBgDocsInS3(File inputFile, int userid);

	public String uploadWidgetPicsInS3(File inputFile, int userid);
	
}

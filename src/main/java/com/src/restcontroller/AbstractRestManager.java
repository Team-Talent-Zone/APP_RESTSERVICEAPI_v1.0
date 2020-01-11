package com.src.restcontroller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.src.service.LookUpTemplateService;
import com.src.service.ReferenceLookUpService;
import com.src.service.UserService;
import com.src.service.UtilService;

@Controller
class AbstractRestManager {

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;

	@Autowired
	protected UserService userService;

	@Autowired
	protected ReferenceLookUpService referenceLookUpService;

	@Autowired
	protected LookUpTemplateService lookUpTemplateService;

	@Autowired
	protected UtilService utilService;

}
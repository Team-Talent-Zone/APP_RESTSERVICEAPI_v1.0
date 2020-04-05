package com.src.restcontroller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.src.helper.SendEmailHelper;
import com.src.service.FreeLanceOnServiceSVC;
import com.src.service.NewSVCService;
import com.src.service.PaymentService;
import com.src.service.ReferenceLookUpService;
import com.src.service.UserService;
import com.src.service.UserServiceDetailsSVC;
import com.src.service.UtilityService;
import com.src.service.WidgetService;

/**
 * The <code> AbstractRestManager </code>interface used to provides
 * functionality details.
 *
 */
@Controller
class AbstractRestManager {

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;

	@Autowired
	protected UserService userDetailsService;

	@Autowired
	protected ReferenceLookUpService referenceLookUpService;

	@Autowired
	protected UtilityService utilService;

	@Autowired
	protected PaymentService paymentService;

	@Autowired
	protected NewSVCService newServiceSvc;
	
	@Autowired
	protected UserServiceDetailsSVC userServiceDetailsService;

	@Autowired
	protected FreeLanceOnServiceSVC freeLanceOnServiceSVC;

	@Autowired
	protected WidgetService widgetService;
	
 	SendEmailHelper emailHelper = new SendEmailHelper();

}
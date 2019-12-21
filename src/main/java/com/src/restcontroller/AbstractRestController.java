package com.src.restcontroller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.src.service.ContentService;
import com.src.service.PurchaseService;
import com.src.service.QuoteService;
import com.src.service.UserService;

@Controller
class AbstractRestController {

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;

	@Autowired
	protected UserService userService;

	@Autowired
	protected ContentService contentService;

	@Autowired
	protected PurchaseService purchaseService;

	@Autowired
	protected QuoteService quoteService;

}
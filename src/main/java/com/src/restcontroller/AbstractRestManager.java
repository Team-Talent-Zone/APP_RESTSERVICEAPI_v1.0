package com.src.restcontroller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
import com.src.service.UserService;

@Controller
class AbstractRestManager {

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;

	@Autowired
	protected UserService userService;
 

}
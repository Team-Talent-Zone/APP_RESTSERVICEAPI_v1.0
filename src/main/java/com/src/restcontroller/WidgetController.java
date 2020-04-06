package com.src.restcontroller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.WidgetForServiceEntity;
import com.src.entity.WidgetNotificationHistoryEntity;

/**
 * The <code> WidgetController </code> class defines managed beans which
 * provides back-end functionality on the <code>Widget</code> Details.
 * 
 * @author Shanoor.
 * @version 1.0
 *
 */
@Controller
public class WidgetController extends AbstractRestManager {
	/**
	 * Method is to save Widget.
	 * 
	 * @param widgetForServiceEntityObj
	 */
	@RequestMapping(value = "/saveWidgetService/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WidgetForServiceEntity> saveWidgetService(
			@RequestBody WidgetForServiceEntity widgetForServiceEntityObj) {
		WidgetForServiceEntity widgetForServiceEntity = widgetService.saveWidgetService(widgetForServiceEntityObj);
		return new ResponseEntity<WidgetForServiceEntity>(widgetForServiceEntity, HttpStatus.OK);
	}

	/**
	 * Method is to save or Update Widget.
	 * 
	 * @param newServiceEntityObject
	 */
	@RequestMapping(value = "/saveOrUpdateWidget/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WidgetForServiceEntity> saveOrUpdateWidget(
			@RequestBody WidgetForServiceEntity widgetForServiceEntityObj) {
		WidgetForServiceEntity newServiceEntity = widgetService.saveOrUpdateWidget(widgetForServiceEntityObj);
		return new ResponseEntity<WidgetForServiceEntity>(newServiceEntity, HttpStatus.OK);
	}

	/**
	 * Method is to get Complete Widget Details.
	 * 
	 */
	@RequestMapping(value = "/getAllWidgetDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<WidgetForServiceEntity>> getAllWidgetDetails() {
		ArrayList<WidgetForServiceEntity> listofAllWidget = widgetService.getAllWidgetDetails();
		return new ResponseEntity<ArrayList<WidgetForServiceEntity>>(listofAllWidget, HttpStatus.OK);
	}

	/**
	 * Method is to save Widget Notification History.
	 * 
	 * @param saveWidgetNotificationHistory
	 */
	@RequestMapping(value = "/saveWidgetNotificationHist/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WidgetNotificationHistoryEntity> saveWidgetNotificationHist(
			@RequestBody WidgetNotificationHistoryEntity widgetNotificationHistoryEntityObj) {
		WidgetNotificationHistoryEntity widgetNotificationHistoryEntity = widgetService
				.saveWidgetNotificationHist(widgetNotificationHistoryEntityObj);
		return new ResponseEntity<WidgetNotificationHistoryEntity>(widgetNotificationHistoryEntity, HttpStatus.OK);
	}

	/**
	 * Method is to Get Complete Widget Notification History.
	 * 
	 */
	@RequestMapping(value = "/getWidgetNotificationHist/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<WidgetNotificationHistoryEntity>> getWidgetNotificationHist() {
		ArrayList<WidgetNotificationHistoryEntity> listOfAllWidgetNotificationHistEntity = widgetService
				.getWidgetNotificationHist();
		return new ResponseEntity<ArrayList<WidgetNotificationHistoryEntity>>(listOfAllWidgetNotificationHistEntity,
				HttpStatus.OK);
	}
}

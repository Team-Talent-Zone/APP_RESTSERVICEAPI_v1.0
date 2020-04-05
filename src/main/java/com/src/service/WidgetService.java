package com.src.service;

import java.util.ArrayList;

import com.src.entity.WidgetForServiceEntity;
import com.src.entity.WidgetNotificationHistoryEntity;

/**
 * The <code> WidgetService </code> interface defines a business service for
 * retrieving <code>Widget Service</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface WidgetService {
	/**
	 * To save Widget details.
	 * 
	 * @param newServiceEntity
	 * @return
	 */
	public WidgetForServiceEntity saveWidgetService(WidgetForServiceEntity widgetForServiceEntity);

	/**
	 * To Edit and Save (update) the Widget Details.
	 * 
	 * @param newServiceEntity
	 */
	public WidgetForServiceEntity saveOrUpdateWidget(WidgetForServiceEntity widgetForServiceEntity);

	/**
	 * To Get the all Widget Details.
	 * 
	 */
	public ArrayList<WidgetForServiceEntity> getAllWidgetDetails();

	/**
	 * To save Widget Notification history details.
	 * 
	 * @param newServiceEntity
	 */
	public WidgetNotificationHistoryEntity saveWidgetNotificationHist(
			WidgetNotificationHistoryEntity widgetNotificationHistoryEntity);

	/**
	 * To Get the Complete Widget Notification History Details.
	 */
	public ArrayList<WidgetNotificationHistoryEntity> getWidgetNotificationHist();
}

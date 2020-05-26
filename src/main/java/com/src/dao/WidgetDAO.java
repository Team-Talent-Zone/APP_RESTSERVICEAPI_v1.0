package com.src.dao;

import java.util.ArrayList;

import com.src.entity.WidgetForServiceEntity;
import com.src.entity.WidgetNotificationHistoryEntity;

/**
 * The <code> WidgetDAO </code> interface defines a data access object for
 * retrieving <code>Widget</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface WidgetDAO {

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
	 * @return
	 */
	public void saveOrUpdateWidget(WidgetForServiceEntity widgetForServiceEntity);

	/**
	 * To Get the all Widget Details.
	 * 
	 * @return
	 */
	public WidgetForServiceEntity getAllWidgetDetails(int widgetId);

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

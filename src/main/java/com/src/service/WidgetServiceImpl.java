package com.src.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.WidgetForServiceEntity;
import com.src.entity.WidgetLayoutEntity;
import com.src.entity.WidgetNotificationHistoryEntity;
import com.src.utils.CommonUtilites;
import com.src.constant.WidgetConstant;

/**
 * The <code> WidgetServiceImpl </code> class provides the implementation for
 * the <code>Widget</code> business interface.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Service(WidgetConstant.WIDGETSERVICE)
@Transactional(rollbackFor = { Exception.class })
public class WidgetServiceImpl extends AbstractServiceManager implements WidgetService {

	/**
	 * This method is to save the widget details.
	 */
	@Override
	public WidgetForServiceEntity saveWidgetService(WidgetForServiceEntity widgetForServiceEntity) {
		widgetForServiceEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		Set<WidgetLayoutEntity> widgetLayoutEntities = new HashSet<WidgetLayoutEntity>();
		if (widgetForServiceEntity.getWidgetLayoutEntity() != null) {
			for (WidgetLayoutEntity widgetLayoutEntity : widgetForServiceEntity.getWidgetLayoutEntity()) {
				widgetLayoutEntities.add(widgetLayoutEntity);
				widgetLayoutEntity.setWidgetEntity(widgetForServiceEntity);
			}
			widgetForServiceEntity.setWidgetLayoutEntity(widgetLayoutEntities);
		}
		return widgetDAO.saveWidgetService(widgetForServiceEntity);

	}

	/**
	 * This method is to update the widget details.
	 */
	@Override
	public WidgetForServiceEntity saveOrUpdateWidget(WidgetForServiceEntity widgetForServiceEntity) {

		Set<WidgetLayoutEntity> widgetLayoutEntities = new HashSet<WidgetLayoutEntity>();

		if (widgetForServiceEntity.getWidgetLayoutEntity() != null) {
			for (WidgetLayoutEntity widgetLayoutEntity : widgetForServiceEntity.getWidgetLayoutEntity()) {
				widgetLayoutEntities.add(widgetLayoutEntity);
				widgetLayoutEntity.setWidgetEntity(widgetForServiceEntity);
			}
			widgetForServiceEntity.setWidgetLayoutEntity(widgetLayoutEntities);
		}

		widgetDAO.saveOrUpdateWidget(widgetForServiceEntity);
		return widgetForServiceEntity;
	}

	/**
	 * This Method is to get Complete Widget details.
	 */
	@Override
	public ArrayList<WidgetForServiceEntity> getAllWidgetDetails() {
		return widgetDAO.getAllWidgetDetails();
	}

	/**
	 * To save Widget Notification history details.
	 * 
	 * @param newServiceEntity
	 */
	@Override
	public WidgetNotificationHistoryEntity saveWidgetNotificationHist(
			WidgetNotificationHistoryEntity widgetNotificationHistoryEntity) {
		widgetNotificationHistoryEntity.setSenton(CommonUtilites.getCurrentDateInNewFormat());
		return widgetDAO.saveWidgetNotificationHist(widgetNotificationHistoryEntity);
	}

	/**
	 * To Get the Complete Widget Notification History Details.
	 */
	@Override
	public ArrayList<WidgetNotificationHistoryEntity> getWidgetNotificationHist() {
		return widgetDAO.getWidgetNotificationHist();
	}
}

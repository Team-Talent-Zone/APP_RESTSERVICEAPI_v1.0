package com.src.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.constant.UserConstant;
import com.src.constant.WidgetConstant;
import com.src.entity.WidgetForServiceEntity;
import com.src.entity.WidgetNotificationHistoryEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> WidgetDAOImpl </code> class handles data access operation for
 * <code>Widget</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class WidgetDAOImpl extends AbstractDAOManager implements WidgetDAO {
	final Logger LOGGER = LoggerFactory.getLogger(WidgetDAOImpl.class);

	/**
	 * This method id to save the widget details.
	 */
	@Transactional
	public WidgetForServiceEntity saveWidgetService(WidgetForServiceEntity widgetForServiceEntity) {
		LOGGER.info(WidgetConstant.INSIDE_SAVEWIDGET);
		int widgetSavedID = (Integer) sessionFactory.getCurrentSession().save(widgetForServiceEntity);
		LOGGER.debug(WidgetConstant.CONFIRM_SAVE_WIDGET + widgetSavedID);
		if (widgetSavedID > 0) {
			return widgetForServiceEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * This Method is to Update the widget.
	 */
	@Transactional
	public void saveOrUpdateWidget(WidgetForServiceEntity widgetForServiceEntity) {
		try {
			LOGGER.info(WidgetConstant.INSIDE_SAVEORUPDATE_WIDGET);
			sessionFactory.getCurrentSession().saveOrUpdate(widgetForServiceEntity);
			LOGGER.info(WidgetConstant.CONFIRMED_SAVEORUPDATE_WIDGET + widgetForServiceEntity.getWidgetId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	/**
	 * This method is to get the widget details.
	 */
	@SuppressWarnings({"unused" })
	@Transactional
	public WidgetForServiceEntity getAllWidgetDetails(int widgetId) {
		LOGGER.info(WidgetConstant.GETALLWIDGETDETAILS);

		WidgetForServiceEntity widgetForServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(WidgetForServiceEntity.class);
		criteria.add(Restrictions.eq(UserConstant.WIDGETID, widgetId));
		widgetForServiceEntity = (WidgetForServiceEntity) criteria.setMaxResults(1).uniqueResult();

		LOGGER.debug(WidgetConstant.INSIDE_GETALLWIDGET_DETAILS_DAO + widgetForServiceEntity.getWidgetId());
		if (widgetForServiceEntity != null) {
			return widgetForServiceEntity;
		}
		return null;
	}

	/**
	 * To save Widget Notification history details.
	 * 
	 * @param widgetNotificationHistoryEntity
	 */
	@Transactional
	public WidgetNotificationHistoryEntity saveWidgetNotificationHist(
			WidgetNotificationHistoryEntity widgetNotificationHistoryEntity) {
		LOGGER.info(WidgetConstant.INSIDE_SAVEWIDGETNOTIFICATIONHISTORY);
		int widgetNotificationHistSavedID = (Integer) sessionFactory.getCurrentSession()
				.save(widgetNotificationHistoryEntity);
		LOGGER.debug(WidgetConstant.CONFIRM_SAVE_WIDGETNOTIFICATIONHISTORY + widgetNotificationHistSavedID);
		if (widgetNotificationHistSavedID > 0) {
			return widgetNotificationHistoryEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To Get the Complete Widget Notification History Details.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<WidgetNotificationHistoryEntity> getWidgetNotificationHist() {
		LOGGER.info(WidgetConstant.GETALLWIDGETNOTIFICATIONHISTORYDETAILS);
		List<WidgetNotificationHistoryEntity> widgetNotificationHistoryEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(WidgetNotificationHistoryEntity.class);
		widgetNotificationHistoryEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = widgetNotificationHistoryEntity != null ? widgetNotificationHistoryEntity.size() : 0;
		LOGGER.debug(WidgetConstant.INSIDE_GETALLWIDGETNOTIFICATIONHISTORY_DETAILS_DAO + size);
		if (size > 0) {
			return (ArrayList<WidgetNotificationHistoryEntity>) widgetNotificationHistoryEntity;
		}
		return null;
	}

}

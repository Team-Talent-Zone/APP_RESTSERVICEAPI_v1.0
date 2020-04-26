package com.src.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.NewServiceEntity;
import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceEventHistoryEntity;
import com.src.entity.UserServiceExpirationDetailsView;
import com.src.entity.UserServiceNotfications;
import com.src.entity.UserServiceNotificationDetailsView;
import com.src.utils.CommonUtilites;

/**
 * The <code> UserServiceDetailsSVCImpl </code> class provides the
 * implementation for the <code>User Service Details</code> related business
 * interface.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Service(NewServiceConstant.USER_SERVICE_DETAILS_SERVICE)
@Transactional(rollbackFor = { Exception.class })
public class UserServiceDetailsSVCImpl extends AbstractServiceManager implements UserServiceDetailsSVC {

	/**
	 * To Save User Service Details.
	 */
	@Override
	public UserServiceDetailsEntity saveUserServiceDetails(UserServiceDetailsEntity userServiceDetailsEntity) {
		userServiceDetailsEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
		userServiceDetailsEntity.setIsactive(Boolean.TRUE);
		NewServiceEntity newServiceEntity = new NewServiceEntity();
		newServiceEntity.setOurserviceId(userServiceDetailsEntity.getOurserviceId());
		newServiceEntity.setUserId(userServiceDetailsEntity.getUserid());
		userServiceDetailsEntity.setNewService(newServiceEntity);

		Set<UserServiceEventHistoryEntity> userServiceEventHistory = new HashSet<UserServiceEventHistoryEntity>();
		for (UserServiceEventHistoryEntity eventHistoryEntity : userServiceDetailsEntity.getUserServiceEventHistory()) {
			eventHistoryEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
			eventHistoryEntity.setUserServiceDetailsEntity(userServiceDetailsEntity);
			userServiceEventHistory.add(eventHistoryEntity);
			eventHistoryEntity.setUserServiceDetailsEntity(userServiceDetailsEntity);

		}
		userServiceDetailsEntity.setUserServiceEventHistory(userServiceEventHistory);

		return userServiceDetailsDAO.saveUserServiceDetails(userServiceDetailsEntity);
	}

	/**
	 * To save or Update User Service Details.
	 */
	@Override
	public UserServiceDetailsEntity saveOrUpdateUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity) {
		NewServiceEntity newServiceEntity = new NewServiceEntity();
		newServiceEntity.setOurserviceId(userServiceDetailsEntity.getOurserviceId());
		userServiceDetailsEntity.setNewService(newServiceEntity);
		Set<UserServiceEventHistoryEntity> userServiceEventHistory = userServiceDetailsEntity
				.getUserServiceEventHistory();
		for (UserServiceEventHistoryEntity eventHistoryEntity : userServiceDetailsEntity.getUserServiceEventHistory()) {
			eventHistoryEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
			eventHistoryEntity.setUserServiceDetailsEntity(userServiceDetailsEntity);
			userServiceEventHistory.add(eventHistoryEntity);
			eventHistoryEntity.setUserServiceDetailsEntity(userServiceDetailsEntity);
		}
		userServiceDetailsEntity.setUserServiceEventHistory(userServiceEventHistory);

		userServiceDetailsDAO.saveOrUpdateUserSVCDetails(userServiceDetailsEntity);
		return userServiceDetailsEntity;
	}

	@Override
	public UserServiceEventHistoryEntity saveUserServiceEventHistory(UserServiceEventHistoryEntity eventHistoryEntity) {
		UserServiceDetailsEntity detailsEntity = new UserServiceDetailsEntity();
		detailsEntity.setServiceId(eventHistoryEntity.getServiceId());
		eventHistoryEntity.setUserServiceDetailsEntity(detailsEntity);
		userServiceDetailsDAO.saveUserServiceEventHistory(eventHistoryEntity);
		return eventHistoryEntity;
	}

	/**
	 * Get the User Service Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public UserServiceDetailsEntity getUserServiceDetailsByUserId(int userId) {
		return userServiceDetailsDAO.getUserServiceDetailsByUserId(userId);
	}

	/**
	 * Get the User Service Details by serviceId.
	 * 
	 * @param serviceId
	 */
	@Override
	public UserServiceDetailsEntity getUserServiceDetailsByServiceId(int serviceId) {
		return userServiceDetailsDAO.getUserServiceDetailsByServiceId(serviceId);
	}

	/**
	 * To Get All User Service Details.
	 */
	@Override
	public ArrayList<UserServiceDetailsEntity> getAllUserServiceDetails() {
		return userServiceDetailsDAO.getAllUserServiceDetails();
	}

	/**
	 * To Save User Service Notification.
	 */
	@Override
	public UserServiceNotfications saveUserServiceNotification(UserServiceNotfications userServiceNotfication) {
		UserServiceDetailsEntity userServiceDetailsEntity = new UserServiceDetailsEntity();
		userServiceDetailsEntity.setServiceId(userServiceNotfication.getServiceId());
		userServiceNotfication.setUserServiceDetailsEntity(userServiceDetailsEntity);
		userServiceDetailsDAO.saveUserServiceNotification(userServiceNotfication);
		return userServiceNotfication;
	}

	/**
	 * To get the user service Expiration Details.
	 */
	@Override
	public ArrayList<UserServiceExpirationDetailsView> getUserServiceExpirationDetails() {
		return userServiceDetailsDAO.getUserServiceExpirationDetails();
	}

	/**
	 * To get User service Notification Details by user id.
	 */
	public ArrayList<UserServiceNotificationDetailsView> getUserServiceNotificationDetailsByUserId(int userId) {
		return userServiceDetailsDAO.getUserServiceNotificationDetailsByUserId(userId);
	}

	/**
	 * To get User Service pending payments.
	 */
	@Override
	public ArrayList<UserServiceDetailsEntity> getUserServicePendingPayment() {
		return userServiceDetailsDAO.getUserServicePendingPayment();
	}

}

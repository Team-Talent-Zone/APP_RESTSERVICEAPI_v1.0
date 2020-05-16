package com.src.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.AllActiveNewSeviceDetailsView;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.utils.CommonUtilites;

/**
 * The <code> NewSVCServiceImpl </code> class provides the implementation for
 * the <code>New Service</code> related business interface.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Service(NewServiceConstant.NEW_SERVICE_SVC)
@Transactional(rollbackFor = { Exception.class })
public class NewSVCServiceImpl extends AbstractServiceManager implements NewSVCService {

	/**
	 * To save new service Details. 
	 */
	@Override 
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity) {
		newServiceEntity.setIsupgrade(Boolean.FALSE);
		newServiceEntity.setActive(Boolean.FALSE);
		newServiceEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		newServiceEntity.setUpdatedOn(CommonUtilites.getCurrentDateInNewFormat());
		
		Set<NewServiceHistoryEntity> newServiceHistoryEntities = new HashSet<NewServiceHistoryEntity>();

		if(newServiceEntity.getServiceHistory() != null) {
			for (NewServiceHistoryEntity serviceHistoryEntity : newServiceEntity.getServiceHistory()) {
				serviceHistoryEntity.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
				serviceHistoryEntity.setIslocked(Boolean.TRUE);
				newServiceHistoryEntities.add(serviceHistoryEntity);
				serviceHistoryEntity.setNewService(newServiceEntity);
			}
			newServiceEntity.setServiceHistory(newServiceHistoryEntities);
		}
		return newServiceRestDAO.saveNewService(newServiceEntity);
	}

	/**
	 * To save or Update New Service Details.
	 */
	@Override
	public NewServiceEntity saveOrUpdateNewService(NewServiceEntity newServiceEntity) {
		newServiceEntity.setUpdatedOn(CommonUtilites.getCurrentDateInNewFormat());
		if(newServiceEntity.isIsupgrade()) {
			newServiceEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		}
		Set<NewServiceHistoryEntity> newServiceHistoryEntities = new HashSet<NewServiceHistoryEntity>();

		if(newServiceEntity.getServiceHistory() != null) {
			for (NewServiceHistoryEntity serviceHistoryEntity : newServiceEntity.getServiceHistory()) {
				serviceHistoryEntity.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
				newServiceHistoryEntities.add(serviceHistoryEntity);
				serviceHistoryEntity.setNewService(newServiceEntity);
			}
			newServiceEntity.setServiceHistory(newServiceHistoryEntities);
		}
		
		newServiceRestDAO.saveOrUpdateNewService(newServiceEntity);
		return newServiceEntity;
	}

	/**
	 * To save New Service History Details.
	 */
	@Override
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity) {
		newServiceHistoryEntity.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
		NewServiceEntity newServiceEntity = new NewServiceEntity();
		newServiceEntity.setOurserviceId(newServiceHistoryEntity.getOurserviceId());
		newServiceHistoryEntity.setNewService(newServiceEntity);
		return newServiceRestDAO.saveNewServiceHistory(newServiceHistoryEntity);
	}

	/**
	 * To Get All Service Details.
	 */
	@Override
	public ArrayList<AllActiveNewSeviceDetailsView> getAllServiceDetails() {
		return newServiceRestDAO.getAllServiceDetails();
	}
	
	/**
	 * To Get All Service Details for Manage New Service Tab.
	 */
	@Override
	public ArrayList<NewServiceEntity> getAllNewServices() {
		return newServiceRestDAO.getAllNewServices();
	}

	/**
	 * Get All User Service Details by managerId.
	 * 
	 * @param managerId
	 */
	@Override
	public ArrayList<NewServiceHistoryEntity> getAllNewServiceDetailsByManagerId(int managerId) {
		return newServiceRestDAO.getAllNewServiceDetailsByManagerId(managerId);
	}

	/**
	 * Get All User Service Details by userId.
	 * 
	 * @param userId
	 */
	@Override
	public ArrayList<NewServiceHistoryEntity> getAllNewServiceDetailsByUserId(int userId) {
		return newServiceRestDAO.getAllNewServiceDetailsByUserId(userId);
	}

	/**
	 * Get All New Service Details created today - 1
	 */
	@Override
	public ArrayList<NewServiceEntity> getNewServiceDetailsCreated() {
		return newServiceRestDAO.getNewServiceDetailsCreated();
	}

	@Override
	public NewServiceEntity getNewServiceDetailsByServiceId(int ourserviceId) {
		return newServiceRestDAO.getNewServiceDetailsByServiceId(ourserviceId);
	}
	
	@Override
	public boolean checkNewServiceIsExist(String servicename) {
		return newServiceRestDAO.checkNewServiceIsExist(servicename);
	}
}

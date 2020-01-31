package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;
import com.src.entity.UserServiceDetailsEntity;
import com.src.entity.UserServiceEventHistoryEntity;
import com.src.utils.CommonUtilites;

/**
 * The <code> NewSVCServiceImpl </code> class provides the implementation for
 * the <code>New Service</code> related business interface.
 * 
 * @author Shanoor
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
		newServiceEntity.setUpgrade(Boolean.FALSE);
		newServiceEntity.setActive(Boolean.FALSE);
		newServiceEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		newServiceEntity.setUpdatedOn(CommonUtilites.getCurrentDateInNewFormat());

		NewServiceHistoryEntity inputHisEnty = newServiceEntity.getServiceHistory();
		inputHisEnty.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
		inputHisEnty.setLocked(Boolean.FALSE);
		inputHisEnty.setNewService(newServiceEntity);
		newServiceEntity.setServiceHistory(inputHisEnty);
		return newServiceRestDAO.saveNewService(newServiceEntity);
	}

	/**
	 * To save or Update New Service Details.
	 */
	@Override
	public NewServiceEntity saveOrUpdateNewService(NewServiceEntity newServiceEntity) {
		newServiceEntity.setUpdatedBy(CommonUtilites.getCurrentDateInNewFormat());
		NewServiceHistoryEntity inputHisEnty = newServiceEntity.getServiceHistory();
		inputHisEnty.setLocked(Boolean.FALSE);
		inputHisEnty.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
		inputHisEnty.setNewService(newServiceEntity);
		newServiceEntity.setServiceHistory(inputHisEnty);
		newServiceRestDAO.saveOrUpdateNewService(newServiceEntity);
		return newServiceEntity;
	}

	/**
	 * To save New Service History Details.
	 */
	@Override
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity) {
		newServiceHistoryEntity.setLocked(Boolean.TRUE);
		newServiceHistoryEntity.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
		NewServiceEntity newServiceEntity = new NewServiceEntity();
		newServiceEntity.setOurserviceId(newServiceHistoryEntity.getOurserviceId());
		newServiceHistoryEntity.setNewService(newServiceEntity);
		return newServiceRestDAO.saveNewServiceHistory(newServiceHistoryEntity);
	}

	/**
	 * To save New Service Package Details.
	 */
	@Override
	public ArrayList<NewServicePackageEntity> saveNewServicePackage(
			ArrayList<NewServicePackageEntity> newServicePackageEntity) {

		ArrayList<NewServicePackageEntity> entities = new ArrayList<NewServicePackageEntity>();
		for (NewServicePackageEntity packageEntity : newServicePackageEntity) {
			packageEntity.setActive(Boolean.TRUE);
			packageEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
			NewServicePackageEntity entity = newServiceRestDAO.saveNewServicePackage(packageEntity);
			entities.add(entity);
		}
		return entities;
	}

	/**
	 * To Get All Service Details.
	 */
	@Override
	public ArrayList<NewServiceEntity> getAllServiceDetails() {
		return newServiceRestDAO.getAllServiceDetails();
	}
  
	/**
	 * To Save User Service Details.
	 */
	@Override
	public UserServiceDetailsEntity saveUserServiceDetails(UserServiceDetailsEntity userServiceDetailsEntity) {
		userServiceDetailsEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		userServiceDetailsEntity.setActive(Boolean.TRUE);
		
		NewServiceEntity newServiceEntity = new NewServiceEntity();
		newServiceEntity.setOurserviceId(userServiceDetailsEntity.getOurserviceId());
		userServiceDetailsEntity.setNewService(newServiceEntity);

		UserServiceEventHistoryEntity userServiceEventHistory = userServiceDetailsEntity.getUserServiceEventHistory();
		userServiceEventHistory.setUpdatedOn(CommonUtilites.getCurrentDateInNewFormat());
		userServiceEventHistory.setUserServiceDetailsEntity(userServiceDetailsEntity);
		userServiceDetailsEntity.setUserServiceEventHistory(userServiceEventHistory);
		return newServiceRestDAO.saveUserServiceDetails(userServiceDetailsEntity);
	}
	
	/**
	 * To save Free Lance On Service Details.
	 */
	@Override
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		freeLanceOnServiceEntity.setUpdatedOn(CommonUtilites.getCurrentDateInNewFormat());
		freeLanceOnServiceEntity.setJobAccepted(Boolean.FALSE);
		freeLanceOnServiceEntity.setOutStandingAmtPaid(Boolean.FALSE);
		freeLanceOnServiceEntity.setJobCancel(Boolean.FALSE);
		freeLanceOnServiceEntity.setJobActive(Boolean.FALSE);
		freeLanceOnServiceEntity.setJobCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		UserServiceDetailsEntity userServiceDetailsEntity = new UserServiceDetailsEntity();
		userServiceDetailsEntity.setServiceId(freeLanceOnServiceEntity.getServiceId());
		freeLanceOnServiceEntity.setUserServiceDetails(userServiceDetailsEntity);
		return newServiceRestDAO.saveFreeLanceOnService(freeLanceOnServiceEntity);
	}

	@Override
	public UserServiceDetailsEntity saveOrUpdateUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FreeLanceOnServiceEntity saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		// TODO Auto-generated method stub
		return null;
	}


}

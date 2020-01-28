package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.NewServiceConstant;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;
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

	@Override
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity) {
		newServiceHistoryEntity.setLocked(Boolean.TRUE);
		newServiceHistoryEntity.setDecisionOn(CommonUtilites.getCurrentDateInNewFormat());
		NewServiceEntity newServiceEntity = new NewServiceEntity();
		newServiceEntity.setOurserviceId(newServiceHistoryEntity.getOurserviceId());
		newServiceHistoryEntity.setNewService(newServiceEntity);
		newServiceRestDAO.saveNewServiceHistory(newServiceHistoryEntity);
		return newServiceHistoryEntity;
	}

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

	@Override
	public ArrayList<NewServiceEntity> getAllServiceDetails() {
		return newServiceRestDAO.getAllServiceDetails();
	}

}

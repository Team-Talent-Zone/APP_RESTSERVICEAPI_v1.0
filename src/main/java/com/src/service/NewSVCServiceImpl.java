package com.src.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.utils.CommonUtilites;

/**
 * The <code> NewSVCServiceImpl </code> class provides the implementation for
 * the <code>New Service</code> related business interface.
 * 
 * @author Shanoor
 *
 */
@Service("newSVCService")
@Transactional(rollbackFor = { Exception.class })
public class NewSVCServiceImpl extends AbstractServiceManager implements NewSVCService {

	@Override
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity) {
		newServiceEntity.setUpgrade(Boolean.FALSE);
		newServiceEntity.setActive(Boolean.FALSE);
		newServiceEntity.setCreatedOn(CommonUtilites.getCurrentDateInNewFormat());
		newServiceEntity.setUpdatedOn(CommonUtilites.getCurrentDateInNewFormat());

		Set<NewServiceHistoryEntity> newServiceHistoryEntity = new HashSet<NewServiceHistoryEntity>();
		for (NewServiceHistoryEntity inputHisEnty : newServiceEntity.getServiceHistory()) {
			inputHisEnty.setDecisionBy(CommonUtilites.getCurrentDateInNewFormat());
			inputHisEnty.setLocked(Boolean.FALSE);
			newServiceHistoryEntity.add(inputHisEnty);
			inputHisEnty.setNewService(newServiceEntity);
		}
		newServiceEntity.setServiceHistory(newServiceHistoryEntity);
		return newServiceRestDAO.saveNewService(newServiceEntity);
	}

}

package com.src.service;

import com.src.entity.NewServiceEntity;

/**
 * The <code> NewSVCService </code> interface defines a business service for
 * retrieving <code>New Service</code>.
 * 
 * @author Shanoor
 *
 */
public interface NewSVCService {

	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity);

	public NewServiceEntity saveOrUpdateNewService(NewServiceEntity newServiceEntity);
	

}

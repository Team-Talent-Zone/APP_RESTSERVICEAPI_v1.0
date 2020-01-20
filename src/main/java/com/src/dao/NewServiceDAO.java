package com.src.dao;

import com.src.entity.NewServiceEntity;

/**
 * The <code> NewServiceDAO </code> interface defines a data access object for
 * retrieving <code>NewService</code>.
 * 
 * @author Shanoor
 *
 */
public interface NewServiceDAO {

	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity);

	public void saveOrUpdateNewService(NewServiceEntity newServiceEntity);

}

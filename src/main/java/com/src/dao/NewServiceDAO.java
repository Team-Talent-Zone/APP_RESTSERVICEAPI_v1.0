package com.src.dao;

import java.util.ArrayList;

import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;

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

	public void saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity);

	public NewServicePackageEntity saveNewServicePackage(NewServicePackageEntity newServicePackageEntity);

	public ArrayList<NewServiceEntity> getAllServiceDetails();
}

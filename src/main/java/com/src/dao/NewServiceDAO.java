package com.src.dao;

import java.util.ArrayList;

import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;
import com.src.entity.UserServiceDetailsEntity;

/**
 * The <code> NewServiceDAO </code> interface defines a data access object for
 * retrieving <code>NewService</code>.
 * 
 * @author Shanoor
 *
 */
public interface NewServiceDAO {

	/**
	 * To save New Service details.
	 * 
	 * @param newServiceEntity
	 * @return
	 */
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity);

	/**
	 * To save or Update the New Service Details.
	 * 
	 * @param newServiceEntity
	 */
	public void saveOrUpdateNewService(NewServiceEntity newServiceEntity);

	/**
	 * To save the New Service History Details.
	 * 
	 * @param newServiceHistoryEntity
	 * @return
	 */
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity);

	/**
	 * To Save the New Service Package Details.
	 * 
	 * @param newServicePackageEntity
	 * @return
	 */
	public NewServicePackageEntity saveNewServicePackage(NewServicePackageEntity newServicePackageEntity);

	/**
	 * To get All Service Details.
	 * 
	 * @return
	 */
	public ArrayList<NewServiceEntity> getAllServiceDetails();

	/**
	 * To save User Service Details.
	 * 
	 * @param userServiceDetailsEntity
	 * @return
	 */
	public UserServiceDetailsEntity saveUserServiceDetails(UserServiceDetailsEntity userServiceDetailsEntity);

	/**
	 * To save free Lance on Service.
	 * 
	 * @param freeLanceOnServiceEntity
	 * @return
	 */
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To save or Update the User Service Details.
	 * 
	 * @param newServiceEntity
	 */
	public void saveOrUpdateUserSVCDetails(UserServiceDetailsEntity userServiceDetailsEntity);

	/**
	 * To save or Update the Free Lance on Service Details.
	 * 
	 * @param newServiceEntity
	 */
	public void saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

}

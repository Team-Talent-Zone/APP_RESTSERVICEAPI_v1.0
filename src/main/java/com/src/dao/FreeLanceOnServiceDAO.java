package com.src.dao;

import com.src.entity.FreeLanceOnServiceEntity;

/**
 * The <code> FreeLanceOnServiceDAO </code> interface defines a data access
 * object for retrieving <code>Free Lance on Service</code>.
 * 
 * @author Shanoor
 *
 */
public interface FreeLanceOnServiceDAO {

	/**
	 * To save Free Lance on Service.
	 * 
	 * @param FreeLanceOnServiceEntity
	 * @return
	 */
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

	/**
	 * To edit and Update the Free Lance on Service.
	 * 
	 * @param freeLanceOnServiceEntity
	 * @return
	 */
	public void saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity);

}

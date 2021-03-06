/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.hr.service;

/**
 * <p>
 * This class is a wrapper for {@link HRExpenseAccountLocalService}.
 * </p>
 *
 * @author    Wesley Gong
 * @see       HRExpenseAccountLocalService
 * @generated
 */
public class HRExpenseAccountLocalServiceWrapper
	implements HRExpenseAccountLocalService {
	public HRExpenseAccountLocalServiceWrapper(
		HRExpenseAccountLocalService hrExpenseAccountLocalService) {
		_hrExpenseAccountLocalService = hrExpenseAccountLocalService;
	}

	/**
	* Adds the h r expense account to the database. Also notifies the appropriate model listeners.
	*
	* @param hrExpenseAccount the h r expense account
	* @return the h r expense account that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseAccount addHRExpenseAccount(
		com.liferay.hr.model.HRExpenseAccount hrExpenseAccount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.addHRExpenseAccount(hrExpenseAccount);
	}

	/**
	* Creates a new h r expense account with the primary key. Does not add the h r expense account to the database.
	*
	* @param hrExpenseAccountId the primary key for the new h r expense account
	* @return the new h r expense account
	*/
	public com.liferay.hr.model.HRExpenseAccount createHRExpenseAccount(
		long hrExpenseAccountId) {
		return _hrExpenseAccountLocalService.createHRExpenseAccount(hrExpenseAccountId);
	}

	/**
	* Deletes the h r expense account with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hrExpenseAccountId the primary key of the h r expense account
	* @throws PortalException if a h r expense account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHRExpenseAccount(long hrExpenseAccountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_hrExpenseAccountLocalService.deleteHRExpenseAccount(hrExpenseAccountId);
	}

	/**
	* Deletes the h r expense account from the database. Also notifies the appropriate model listeners.
	*
	* @param hrExpenseAccount the h r expense account
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHRExpenseAccount(
		com.liferay.hr.model.HRExpenseAccount hrExpenseAccount)
		throws com.liferay.portal.kernel.exception.SystemException {
		_hrExpenseAccountLocalService.deleteHRExpenseAccount(hrExpenseAccount);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the h r expense account with the primary key.
	*
	* @param hrExpenseAccountId the primary key of the h r expense account
	* @return the h r expense account
	* @throws PortalException if a h r expense account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseAccount getHRExpenseAccount(
		long hrExpenseAccountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.getHRExpenseAccount(hrExpenseAccountId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the h r expense accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of h r expense accounts
	* @param end the upper bound of the range of h r expense accounts (not inclusive)
	* @return the range of h r expense accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.hr.model.HRExpenseAccount> getHRExpenseAccounts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.getHRExpenseAccounts(start, end);
	}

	/**
	* Returns the number of h r expense accounts.
	*
	* @return the number of h r expense accounts
	* @throws SystemException if a system exception occurred
	*/
	public int getHRExpenseAccountsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.getHRExpenseAccountsCount();
	}

	/**
	* Updates the h r expense account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hrExpenseAccount the h r expense account
	* @return the h r expense account that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseAccount updateHRExpenseAccount(
		com.liferay.hr.model.HRExpenseAccount hrExpenseAccount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.updateHRExpenseAccount(hrExpenseAccount);
	}

	/**
	* Updates the h r expense account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hrExpenseAccount the h r expense account
	* @param merge whether to merge the h r expense account with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the h r expense account that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseAccount updateHRExpenseAccount(
		com.liferay.hr.model.HRExpenseAccount hrExpenseAccount, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hrExpenseAccountLocalService.updateHRExpenseAccount(hrExpenseAccount,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _hrExpenseAccountLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hrExpenseAccountLocalService.setBeanIdentifier(beanIdentifier);
	}

	public HRExpenseAccountLocalService getWrappedHRExpenseAccountLocalService() {
		return _hrExpenseAccountLocalService;
	}

	public void setWrappedHRExpenseAccountLocalService(
		HRExpenseAccountLocalService hrExpenseAccountLocalService) {
		_hrExpenseAccountLocalService = hrExpenseAccountLocalService;
	}

	private HRExpenseAccountLocalService _hrExpenseAccountLocalService;
}
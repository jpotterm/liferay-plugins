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

package com.liferay.hr.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the HRTimeOffPolicy service. Represents a row in the &quot;HRTimeOffPolicy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.hr.model.impl.HRTimeOffPolicyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.hr.model.impl.HRTimeOffPolicyImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRTimeOffPolicy
 * @see com.liferay.hr.model.impl.HRTimeOffPolicyImpl
 * @see com.liferay.hr.model.impl.HRTimeOffPolicyModelImpl
 * @generated
 */
public interface HRTimeOffPolicyModel extends BaseModel<HRTimeOffPolicy>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a h r time off policy model instance should use the {@link HRTimeOffPolicy} interface instead.
	 */

	/**
	 * Returns the primary key of this h r time off policy.
	 *
	 * @return the primary key of this h r time off policy
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this h r time off policy.
	 *
	 * @param primaryKey the primary key of this h r time off policy
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the hr time off policy ID of this h r time off policy.
	 *
	 * @return the hr time off policy ID of this h r time off policy
	 */
	public long getHrTimeOffPolicyId();

	/**
	 * Sets the hr time off policy ID of this h r time off policy.
	 *
	 * @param hrTimeOffPolicyId the hr time off policy ID of this h r time off policy
	 */
	public void setHrTimeOffPolicyId(long hrTimeOffPolicyId);

	/**
	 * Returns the group ID of this h r time off policy.
	 *
	 * @return the group ID of this h r time off policy
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this h r time off policy.
	 *
	 * @param groupId the group ID of this h r time off policy
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this h r time off policy.
	 *
	 * @return the company ID of this h r time off policy
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this h r time off policy.
	 *
	 * @param companyId the company ID of this h r time off policy
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this h r time off policy.
	 *
	 * @return the user ID of this h r time off policy
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this h r time off policy.
	 *
	 * @param userId the user ID of this h r time off policy
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this h r time off policy.
	 *
	 * @return the user uuid of this h r time off policy
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this h r time off policy.
	 *
	 * @param userUuid the user uuid of this h r time off policy
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this h r time off policy.
	 *
	 * @return the user name of this h r time off policy
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this h r time off policy.
	 *
	 * @param userName the user name of this h r time off policy
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this h r time off policy.
	 *
	 * @return the create date of this h r time off policy
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this h r time off policy.
	 *
	 * @param createDate the create date of this h r time off policy
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this h r time off policy.
	 *
	 * @return the modified date of this h r time off policy
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this h r time off policy.
	 *
	 * @param modifiedDate the modified date of this h r time off policy
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the hr time off type ID of this h r time off policy.
	 *
	 * @return the hr time off type ID of this h r time off policy
	 */
	public long getHrTimeOffTypeId();

	/**
	 * Sets the hr time off type ID of this h r time off policy.
	 *
	 * @param hrTimeOffTypeId the hr time off type ID of this h r time off policy
	 */
	public void setHrTimeOffTypeId(long hrTimeOffTypeId);

	/**
	 * Returns the hr user ID of this h r time off policy.
	 *
	 * @return the hr user ID of this h r time off policy
	 */
	public long getHrUserId();

	/**
	 * Sets the hr user ID of this h r time off policy.
	 *
	 * @param hrUserId the hr user ID of this h r time off policy
	 */
	public void setHrUserId(long hrUserId);

	/**
	 * Returns the hr user uuid of this h r time off policy.
	 *
	 * @return the hr user uuid of this h r time off policy
	 * @throws SystemException if a system exception occurred
	 */
	public String getHrUserUuid() throws SystemException;

	/**
	 * Sets the hr user uuid of this h r time off policy.
	 *
	 * @param hrUserUuid the hr user uuid of this h r time off policy
	 */
	public void setHrUserUuid(String hrUserUuid);

	/**
	 * Returns the accrue h r time off frequency type ID of this h r time off policy.
	 *
	 * @return the accrue h r time off frequency type ID of this h r time off policy
	 */
	public long getAccrueHRTimeOffFrequencyTypeId();

	/**
	 * Sets the accrue h r time off frequency type ID of this h r time off policy.
	 *
	 * @param accrueHRTimeOffFrequencyTypeId the accrue h r time off frequency type ID of this h r time off policy
	 */
	public void setAccrueHRTimeOffFrequencyTypeId(
		long accrueHRTimeOffFrequencyTypeId);

	/**
	 * Returns the reset h r time off frequency type ID of this h r time off policy.
	 *
	 * @return the reset h r time off frequency type ID of this h r time off policy
	 */
	public long getResetHRTimeOffFrequencyTypeId();

	/**
	 * Sets the reset h r time off frequency type ID of this h r time off policy.
	 *
	 * @param resetHRTimeOffFrequencyTypeId the reset h r time off frequency type ID of this h r time off policy
	 */
	public void setResetHRTimeOffFrequencyTypeId(
		long resetHRTimeOffFrequencyTypeId);

	/**
	 * Returns the effective date of this h r time off policy.
	 *
	 * @return the effective date of this h r time off policy
	 */
	public Date getEffectiveDate();

	/**
	 * Sets the effective date of this h r time off policy.
	 *
	 * @param effectiveDate the effective date of this h r time off policy
	 */
	public void setEffectiveDate(Date effectiveDate);

	/**
	 * Returns the inactive of this h r time off policy.
	 *
	 * @return the inactive of this h r time off policy
	 */
	public boolean getInactive();

	/**
	 * Returns <code>true</code> if this h r time off policy is inactive.
	 *
	 * @return <code>true</code> if this h r time off policy is inactive; <code>false</code> otherwise
	 */
	public boolean isInactive();

	/**
	 * Sets whether this h r time off policy is inactive.
	 *
	 * @param inactive the inactive of this h r time off policy
	 */
	public void setInactive(boolean inactive);

	/**
	 * Returns the hours allowed of this h r time off policy.
	 *
	 * @return the hours allowed of this h r time off policy
	 */
	public double getHoursAllowed();

	/**
	 * Sets the hours allowed of this h r time off policy.
	 *
	 * @param hoursAllowed the hours allowed of this h r time off policy
	 */
	public void setHoursAllowed(double hoursAllowed);

	/**
	 * Returns the hours base amount of this h r time off policy.
	 *
	 * @return the hours base amount of this h r time off policy
	 */
	public double getHoursBaseAmount();

	/**
	 * Sets the hours base amount of this h r time off policy.
	 *
	 * @param hoursBaseAmount the hours base amount of this h r time off policy
	 */
	public void setHoursBaseAmount(double hoursBaseAmount);

	/**
	 * Returns the hours to accrue of this h r time off policy.
	 *
	 * @return the hours to accrue of this h r time off policy
	 */
	public double getHoursToAccrue();

	/**
	 * Sets the hours to accrue of this h r time off policy.
	 *
	 * @param hoursToAccrue the hours to accrue of this h r time off policy
	 */
	public void setHoursToAccrue(double hoursToAccrue);

	/**
	 * Returns the carry over hours allowed of this h r time off policy.
	 *
	 * @return the carry over hours allowed of this h r time off policy
	 */
	public double getCarryOverHoursAllowed();

	/**
	 * Sets the carry over hours allowed of this h r time off policy.
	 *
	 * @param carryOverHoursAllowed the carry over hours allowed of this h r time off policy
	 */
	public void setCarryOverHoursAllowed(double carryOverHoursAllowed);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(HRTimeOffPolicy hrTimeOffPolicy);

	public int hashCode();

	public CacheModel<HRTimeOffPolicy> toCacheModel();

	public HRTimeOffPolicy toEscapedModel();

	public String toString();

	public String toXmlString();
}
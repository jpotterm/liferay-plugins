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

package com.liferay.microblogs.service.impl;

import com.liferay.microblogs.model.MicroblogsEntry;
import com.liferay.microblogs.model.MicroblogsEntryConstants;
import com.liferay.microblogs.service.base.MicroblogsEntryLocalServiceBaseImpl;
import com.liferay.microblogs.social.MicroblogsActivityKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Jonathan Lee
 */
public class MicroblogsEntryLocalServiceImpl
	extends MicroblogsEntryLocalServiceBaseImpl {

	 public MicroblogsEntry addMicroblogsEntry(
			long userId, String content, int type, long receiverUserId,
			long receiverMicroblogsEntryId, int socialRelationType,
			ServiceContext serviceContext)
	 	throws PortalException, SystemException {

		// Microblogs entry

		User user = userPersistence.findByPrimaryKey(userId);

		if (receiverUserId == 0) {
			receiverUserId = userId;
		}

		Date now = new Date();

		long microblogsEntryId = counterLocalService.increment();

		MicroblogsEntry microblogsEntry = microblogsEntryPersistence.create(
			microblogsEntryId);

		microblogsEntry.setCompanyId(user.getCompanyId());
		microblogsEntry.setUserId(user.getUserId());
		microblogsEntry.setUserName(user.getFullName());
		microblogsEntry.setCreateDate(now);
		microblogsEntry.setModifiedDate(now);
		microblogsEntry.setContent(content);
		microblogsEntry.setType(type);
		microblogsEntry.setReceiverUserId(receiverUserId);
		microblogsEntry.setReceiverMicroblogsEntryId(receiverMicroblogsEntryId);
		microblogsEntry.setSocialRelationType(socialRelationType);

		microblogsEntryPersistence.update(microblogsEntry, false);

		// Resources

		addMicroblogsEntryResources(microblogsEntry);

		// Asset

		AssetEntryLocalServiceUtil.updateEntry(
			userId, 0, MicroblogsEntry.class.getName(),
			microblogsEntryId, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames());

		// Social

		int actitivtyKey = MicroblogsActivityKeys.ADD_ENTRY;

		if (type == MicroblogsEntryConstants.TYPE_REPLY) {
			actitivtyKey = MicroblogsActivityKeys.REPLY_ENTRY;
		}
		else if (type == MicroblogsEntryConstants.TYPE_REPOST) {
			actitivtyKey =  MicroblogsActivityKeys.REPOST_ENTRY;
		}

		SocialActivityLocalServiceUtil.addActivity(
			userId, 0, MicroblogsEntry.class.getName(), microblogsEntryId,
			actitivtyKey, StringPool.BLANK, receiverUserId);

		return microblogsEntry;
	}

	public void addMicroblogsEntryResources(MicroblogsEntry microblogsEntry)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			microblogsEntry.getCompanyId(), 0, microblogsEntry.getUserId(),
			MicroblogsEntry.class.getName(),
			microblogsEntry.getMicroblogsEntryId(), false, true, true);
	}

	public void deleteMicroblogsEntry(long microblogsEntryId)
		throws PortalException, SystemException {

		MicroblogsEntry microblogsEntry =
			microblogsEntryPersistence.findByPrimaryKey(microblogsEntryId);

		deleteMicroblogsEntry(microblogsEntry);
	}

	public void deleteMicroblogsEntry(MicroblogsEntry microblogsEntry)
		throws PortalException, SystemException {

		// Microblogs entry

		microblogsEntryPersistence.remove(microblogsEntry);

		// Asset

		AssetEntryLocalServiceUtil.deleteEntry(
			MicroblogsEntry.class.getName(),
			microblogsEntry.getMicroblogsEntryId());

		// Social

		SocialActivityLocalServiceUtil.deleteActivities(
			MicroblogsEntry.class.getName(),
			microblogsEntry.getMicroblogsEntryId());
	}

	public void deleteUserMicroblogsEntries(long userId)
		throws PortalException, SystemException {

		List<MicroblogsEntry> microblogsEntries =
			microblogsEntryPersistence.findByUserId(userId);

		for (MicroblogsEntry microblogsEntry : microblogsEntries) {
			deleteMicroblogsEntry(microblogsEntry);
		}
	}

	public List<MicroblogsEntry> getCompanyMicroblogsEntries(
			long companyId, int start, int end)
		throws SystemException {

		return microblogsEntryPersistence.findByCompanyId(
			companyId, start, end);
	}

	public int getCompanyMicroblogsEntriesCount(long companyId)
		throws SystemException {

		return microblogsEntryPersistence.countByCompanyId(companyId);
	}

	public MicroblogsEntry getMicroblogsEntry(long microblogsEntryId)
		throws PortalException, SystemException {

		return microblogsEntryPersistence.findByPrimaryKey(microblogsEntryId);
	}

	public List<MicroblogsEntry> getReceiverMicroblogsEntryMicroblogsEntries(
			int type, long receiverMicroblogsEntryId, int start, int end)
		throws SystemException {

		return microblogsEntryPersistence.findByT_RMEI(
			type, receiverMicroblogsEntryId, start, end);
	}

	public int getReceiverMicroblogsEntryMicroblogsEntriesCount(
			int type, long receiverMicroblogsEntryId)
		throws SystemException {

		return microblogsEntryPersistence.countByT_RMEI(
			type, receiverMicroblogsEntryId);
	}

	public List<MicroblogsEntry> getReceiverUserMicroblogsEntries(
			int type, long receiverUserId, int start, int end)
		throws SystemException {

		return microblogsEntryPersistence.findByT_R(
			type, receiverUserId, start, end);
	}

	public int getReceiverUserMicroblogsEntriesCount(
			int type, long receiverUserId)
		throws SystemException {

		return microblogsEntryPersistence.countByT_R(type, receiverUserId);
	}

	public List<MicroblogsEntry> getUserMicroblogsEntries(
			long userId, int start, int end)
		throws SystemException {

		return microblogsEntryPersistence.findByUserId(userId, start, end);
	}

	public List<MicroblogsEntry> getUserMicroblogsEntries(
			long userId, int type, int start, int end)
		throws SystemException {

		return microblogsEntryPersistence.findByU_T(userId, type, start, end);
	}

	public int getUserMicroblogsEntriesCount(long userId)
		throws SystemException {

		return microblogsEntryPersistence.countByUserId(userId);
	}

	public int getUserMicroblogsEntriesCount(long userId, int type)
		throws SystemException {

		return microblogsEntryPersistence.countByU_T(userId, type);
	}

	public MicroblogsEntry updateMicroblogsEntry(
			long microblogsEntryId, String content, int socialRelationType,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Microblogs entry

		MicroblogsEntry microblogsEntry =
			microblogsEntryPersistence.findByPrimaryKey(microblogsEntryId);

		microblogsEntry.setModifiedDate(new Date());
		microblogsEntry.setContent(content);
		microblogsEntry.setSocialRelationType(socialRelationType);

		microblogsEntryPersistence.update(microblogsEntry, false);

		// Asset

		AssetEntryLocalServiceUtil.updateEntry(
			microblogsEntry.getUserId(), 0, MicroblogsEntry.class.getName(),
			microblogsEntryId, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames());

		return microblogsEntry;
	}

}
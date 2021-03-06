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

package com.liferay.vldap.server.directory.builder;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.vldap.server.directory.FilterConstraint;
import com.liferay.vldap.server.directory.SearchBase;
import com.liferay.vldap.server.directory.ldap.CommunityDirectory;
import com.liferay.vldap.server.directory.ldap.Directory;
import com.liferay.vldap.util.LdapUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.directory.shared.ldap.model.name.Dn;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public class CommunityBuilder extends DirectoryBuilder {

	@Override
	public boolean isValidAttribute(String attributeId, String value) {
		if (attributeId.equalsIgnoreCase("cn") ||
			attributeId.equalsIgnoreCase("description") ||
			attributeId.equalsIgnoreCase("member") ||
			attributeId.equalsIgnoreCase("ou")) {

			return true;
		}
		else if (attributeId.equalsIgnoreCase("objectclass")) {
			if (value.equalsIgnoreCase("groupOfNames") ||
				value.equalsIgnoreCase("organizationalUnit") ||
				value.equalsIgnoreCase("top") || value.equalsIgnoreCase("*")) {

				return true;
			}
		}

		return false;
	}

	@Override
	protected List<Directory> buildDirectories(
			SearchBase searchBase, List<FilterConstraint> filterConstraints)
		throws Exception {

		List<Directory> directories = new ArrayList<Directory>();

		List<Group> groups = getGroups(
			searchBase, filterConstraints);

		for (Group group: groups) {
			Directory directory = new CommunityDirectory(
				searchBase.getTop(), searchBase.getCompany(), group);

			directories.add(directory);
		}

		return directories;
	}

	protected List<Group> getGroups(
			SearchBase searchBase, List<FilterConstraint> filterConstraints)
		throws Exception {

		if (filterConstraints == null) {
			return GroupLocalServiceUtil.getCompanyGroups(
				searchBase.getCompanyId(), 0, (int)searchBase.getSizeLimit());
		}

		List<Group> groups = new ArrayList<Group>();

		for (FilterConstraint filterConstraint : filterConstraints) {
			if (!isValidFilterConstraint(filterConstraint)) {
				continue;
			}

			String name = filterConstraint.getValue("ou");

			if (name == null) {
				name = filterConstraint.getValue("cn");
			}

			String description = filterConstraint.getValue("description");

			String member = filterConstraint.getValue("member");

			String screenName = LdapUtil.getRdnValue(new Dn(member), 3);

			if (screenName != null) {
				User user = UserLocalServiceUtil.getUserByScreenName(
					searchBase.getCompanyId(), screenName);

				for (Group group : user.getGroups()) {
					if ((name != null) && !name.equals(group.getName())) {
						continue;
					}

					if ((description != null) &&
						!description.equals(group.getDescription())) {

						continue;
					}

					groups.add(group);
				}
			}
			else {
				groups.addAll(
					GroupLocalServiceUtil.search(
						searchBase.getCompanyId(), name, description,
						null, 0, (int)searchBase.getSizeLimit()));
			}
		}

		return groups;
	}

}
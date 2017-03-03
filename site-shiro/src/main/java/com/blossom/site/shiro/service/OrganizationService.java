package com.blossom.site.shiro.service;

import java.util.List;

import com.blossom.site.shiro.entity.Organization;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午4:05:06
 */
public interface OrganizationService {

	Organization createOrganization(Organization organization);

	Organization updateOrganization(Organization organization);

	void deleteOrganization(Long organizationId);

	Organization findOne(Long organizationId);

	List<Organization> findAll();

	Object findAllWithExclude(Organization excludeOraganization);

	void move(Organization source, Organization target);
}

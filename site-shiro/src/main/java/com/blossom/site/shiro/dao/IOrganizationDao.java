package com.blossom.site.shiro.dao;

import java.util.List;

import com.blossom.site.shiro.entity.Organization;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:27:33
 */
public interface IOrganizationDao {

	Organization createOrganization(Organization organization);

	Organization updateOrganization(Organization organization);

	void deleteOrganization(Long organizationId);

	Organization findOne(Long organizationId);

	List<Organization> findAll();

	List<Organization> findAllWithExclude(Organization excludeOraganization);

	void move(Organization source, Organization target);

}

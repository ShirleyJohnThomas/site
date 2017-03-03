package com.blossom.site.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blossom.site.shiro.dao.IOrganizationDao;
import com.blossom.site.shiro.entity.Organization;
import com.blossom.site.shiro.service.OrganizationService;

import java.util.List;


@Service("organizationServie")
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private IOrganizationDao organizationDaoImpl;

    public Organization createOrganization(Organization organization) {
        return organizationDaoImpl.createOrganization(organization);
    }

    public Organization updateOrganization(Organization organization) {
        return organizationDaoImpl.updateOrganization(organization);
    }

    public void deleteOrganization(Long organizationId) {
        organizationDaoImpl.deleteOrganization(organizationId);
    }

    public Organization findOne(Long organizationId) {
        return organizationDaoImpl.findOne(organizationId);
    }

    public List<Organization> findAll() {
        return organizationDaoImpl.findAll();
    }

    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        return organizationDaoImpl.findAllWithExclude(excludeOraganization);
    }

    public void move(Organization source, Organization target) {
        organizationDaoImpl.move(source, target);
    }
}

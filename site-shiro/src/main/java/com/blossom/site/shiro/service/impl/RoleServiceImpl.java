package com.blossom.site.shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blossom.site.shiro.dao.IRoleDao;
import com.blossom.site.shiro.entity.Role;
import com.blossom.site.shiro.service.ResourceService;
import com.blossom.site.shiro.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午4:14:48
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRoleDao roleDaoImpl;
    @Autowired
    private ResourceService resourceService;

    public Role createRole(Role role) {
        return roleDaoImpl.createRole(role);
    }

    public Role updateRole(Role role) {
        return roleDaoImpl.updateRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDaoImpl.deleteRole(roleId);
    }

    public Role findOne(Long roleId) {
        return roleDaoImpl.findOne(roleId);
    }

    public List<Role> findAll() {
        return roleDaoImpl.findAll();
    }

    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }
}

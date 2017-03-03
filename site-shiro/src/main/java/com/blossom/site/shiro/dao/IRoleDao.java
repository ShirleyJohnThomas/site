package com.blossom.site.shiro.dao;

import java.util.List;

import com.blossom.site.shiro.entity.Role;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:26:46
 */
public interface IRoleDao {

	Role createRole(Role role);

	Role updateRole(Role role);

	void deleteRole(Long roleId);

	Role findOne(Long roleId);

	List<Role> findAll();

}

package com.blossom.site.shiro.service;

import java.util.List;
import java.util.Set;

import com.blossom.site.shiro.entity.Role;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午4:04:49
 */
public interface RoleService {

	Role createRole(Role role);

	Role updateRole(Role role);

	void deleteRole(Long roleId);

	Role findOne(Long roleId);

	List<Role> findAll();

	/**
	 * 根据角色编号得到角色标识符列表
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<String> findRoles(Long... roleIds);

	/**
	 * 根据角色编号得到权限字符串列表
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<String> findPermissions(Long[] roleIds);
}

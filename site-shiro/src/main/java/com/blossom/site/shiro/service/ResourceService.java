package com.blossom.site.shiro.service;

import java.util.List;
import java.util.Set;

import com.blossom.site.shiro.entity.Resource;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午4:04:58
 */
public interface ResourceService {

	Resource createResource(Resource resource);

	Resource updateResource(Resource resource);

	void deleteResource(Long resourceId);

	Resource findOne(Long resourceId);

	List<Resource> findAll();

	/**
	 * 得到资源对应的权限字符串
	 * 
	 * @param resourceIds
	 * @return
	 */
	Set<String> findPermissions(Set<Long> resourceIds);

	/**
	 * 根据用户权限得到菜单
	 * 
	 * @param permissions
	 * @return
	 */
	List<Resource> findMenus(Set<String> permissions);
}

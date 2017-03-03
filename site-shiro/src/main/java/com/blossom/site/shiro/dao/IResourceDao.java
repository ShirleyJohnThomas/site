package com.blossom.site.shiro.dao;

import java.util.List;

import com.blossom.site.shiro.entity.Resource;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:27:12
 */
public interface IResourceDao {

	Resource createResource(Resource resource);

	Resource updateResource(Resource resource);

	void deleteResource(Long resourceId);

	Resource findOne(Long resourceId);

	List<Resource> findAll();

}

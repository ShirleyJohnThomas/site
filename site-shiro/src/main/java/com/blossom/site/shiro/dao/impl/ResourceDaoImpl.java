package com.blossom.site.shiro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.blossom.site.shiro.dao.IResourceDao;
import com.blossom.site.shiro.entity.Resource;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:28:54
 */
@Repository
public class ResourceDaoImpl implements IResourceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:47
	 * @see com.blossom.site.shiro.dao.IResourceDao#createResource(com.blossom.site.shiro.entity.Resource)
	 */
	public Resource createResource(final Resource resource) {
		final String sql = "insert into sys_resource(name, type, url, permission, parent_id, parent_ids, available) values(?,?,?,?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, resource.getName());
                psst.setString(count++, resource.getType().name());
                psst.setString(count++, resource.getUrl());
                psst.setString(count++, resource.getPermission());
                psst.setLong(count++, resource.getParentId());
                psst.setString(count++, resource.getParentIds());
                psst.setBoolean(count++, resource.getAvailable());
                return psst;
            }
        }, keyHolder);
        resource.setId(keyHolder.getKey().longValue());
        return resource;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:47
	 * @see com.blossom.site.shiro.dao.IResourceDao#updateResource(com.blossom.site.shiro.entity.Resource)
	 */
	public Resource updateResource(Resource resource) {
		 final String sql = "update sys_resource set name=?, type=?, url=?, permission=?, parent_id=?, parent_ids=?, available=? where id=?";
	        jdbcTemplate.update(
	                sql,
	                resource.getName(), resource.getType().name(), resource.getUrl(), resource.getPermission(), resource.getParentId(), resource.getParentIds(), resource.getAvailable(), resource.getId());
	        return resource;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:47
	 * @see com.blossom.site.shiro.dao.IResourceDao#deleteResource(java.lang.Long)
	 */
	public void deleteResource(Long resourceId) {
		Resource resource = findOne(resourceId);
        final String deleteSelfSql = "delete from sys_resource where id=?";
        jdbcTemplate.update(deleteSelfSql, resourceId);
        final String deleteDescendantsSql = "delete from sys_resource where parent_ids like ?";
        jdbcTemplate.update(deleteDescendantsSql, resource.makeSelfAsParentIds() + "%");
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:47
	 * @see com.blossom.site.shiro.dao.IResourceDao#findOne(java.lang.Long)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Resource findOne(Long resourceId) {
		final String sql = "select id, name, type, url, permission, parent_id, parent_ids, available from sys_resource where id=?";
        List<Resource> resourceList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Resource.class), resourceId);
        if(resourceList.size() == 0) {
            return null;
        }
        return resourceList.get(0);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:47
	 * @see com.blossom.site.shiro.dao.IResourceDao#findAll()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Resource> findAll() {
		 final String sql = "select id, name, type, url, permission, parent_id, parent_ids, available from sys_resource order by concat(parent_ids, id) asc";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Resource.class));
	}

}

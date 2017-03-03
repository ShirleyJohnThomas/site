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

import com.blossom.site.shiro.dao.IRoleDao;
import com.blossom.site.shiro.entity.Role;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:28:32
 */
@Repository
public class RoleDaoImpl implements IRoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:52
	 * @see com.blossom.site.shiro.dao.IRoleDao#createRole(com.blossom.site.shiro.entity.Role)
	 */
	public Role createRole(final Role role) {
		final String sql = "insert into sys_role(role, description, resource_ids, available) values(?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, role.getRole());
                psst.setString(count++, role.getDescription());
                psst.setString(count++, role.getResourceIdsStr());
                psst.setBoolean(count++, role.getAvailable());
                return psst;
            }
        }, keyHolder);
        role.setId(keyHolder.getKey().longValue());
        return role;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:52
	 * @see com.blossom.site.shiro.dao.IRoleDao#updateRole(com.blossom.site.shiro.entity.Role)
	 */
	public Role updateRole(Role role) {
		 final String sql = "update sys_role set role=?, description=?, resource_ids=?, available=? where id=?";
	        jdbcTemplate.update(
	                sql,
	                role.getRole(), role.getDescription(), role.getResourceIdsStr(), role.getAvailable(), role.getId());
	        return role;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:52
	 * @see com.blossom.site.shiro.dao.IRoleDao#deleteRole(java.lang.Long)
	 */
	public void deleteRole(Long roleId) {
		final String sql = "delete from sys_role where id=?";
        jdbcTemplate.update(sql, roleId);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:52
	 * @see com.blossom.site.shiro.dao.IRoleDao#findOne(java.lang.Long)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Role findOne(Long roleId) {
		 final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role where id=?";
	        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Role.class), roleId);
	        if(roleList.size() == 0) {
	            return null;
	        }
	        return roleList.get(0);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:52
	 * @see com.blossom.site.shiro.dao.IRoleDao#findAll()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Role> findAll() {
		final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Role.class));
	}

}

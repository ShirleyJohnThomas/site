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

import com.blossom.site.shiro.dao.IUserDao;
import com.blossom.site.shiro.entity.User;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:28:06
 */
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:30:58
	 * @see com.blossom.site.shiro.dao.IUserDao#createUser(com.blossom.site.shiro.entity.User)
	 */
	public User createUser(final User user) {
		final String sql = "INSERT INTO sys_user(id,organization_id,username,password,salt,role_ids,locked) VALUES(?,?,?,?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement pStatement = connection.prepareStatement(sql,new String[]{"id"});
				int count = 1;
				pStatement.setLong(count++, user.getOrganizationId());
				pStatement.setString(count++, user.getUsername());
				pStatement.setString(count++, user.getPassword());
				pStatement.setString(count++, user.getSalt());
				pStatement.setString(count++, user.getRoleIdsStr());
				pStatement.setString(count++, user.getLocked()+"");
				return pStatement;
			}
		},keyHolder);
		user.setId(keyHolder.getKey().longValue());
		return user;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:30:58
	 * @see com.blossom.site.shiro.dao.IUserDao#updateUser(com.blossom.site.shiro.entity.User)
	 */
	public User updateUser(User user) {
		 String sql = "update sys_user set organization_id=?,username=?, password=?, salt=?, role_ids=?, locked=? where id=?";
	        jdbcTemplate.update(
	                sql,
	                user.getOrganizationId(), user.getUsername(), user.getPassword(), user.getSalt(), user.getRoleIdsStr(), user.getLocked(), user.getId());
	        return user;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:30:58
	 * @see com.blossom.site.shiro.dao.IUserDao#deleteUser(java.lang.Long)
	 */
	public void deleteUser(Long userId) {
		String sql = "delete from sys_user where id=?";
        jdbcTemplate.update(sql, userId);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:30:58
	 * @see com.blossom.site.shiro.dao.IUserDao#findOne(java.lang.Long)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User findOne(Long userId) {
		 String sql = "select id, organization_id, username, password, salt, role_ids as roleIdsStr, locked from sys_user where id=?";
	        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), userId);
	        if(userList.size() == 0) {
	            return null;
	        }
	        return userList.get(0);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:30:58
	 * @see com.blossom.site.shiro.dao.IUserDao#findAll()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> findAll() {
		String sql = "select id, organization_id, username, password, salt, role_ids as roleIdsStr, locked from sys_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:30:58
	 * @see com.blossom.site.shiro.dao.IUserDao#findByUsername(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User findByUsername(String username) {
		String sql = "select id, organization_id, username, password, salt, role_ids as roleIdsStr, locked from sys_user where username=?";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), username);
        if(userList.size() == 0) {
            return null;
        }
        return userList.get(0);
	}

}

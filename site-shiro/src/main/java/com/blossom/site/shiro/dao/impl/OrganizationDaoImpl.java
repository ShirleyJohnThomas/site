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

import com.blossom.site.shiro.dao.IOrganizationDao;
import com.blossom.site.shiro.entity.Organization;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:29:20
 */
@Repository
public class OrganizationDaoImpl implements IOrganizationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#createOrganization(com.blossom.site.shiro.entity.Organization)
	 */
	public Organization createOrganization(final Organization organization) {
		final String sql = "insert into sys_organization( name, parent_id, parent_ids, available) values(?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, organization.getName());
                psst.setLong(count++, organization.getParentId());
                psst.setString(count++, organization.getParentIds());
                psst.setBoolean(count++, organization.getAvailable());
                return psst;
            }
        }, keyHolder);
        organization.setId(keyHolder.getKey().longValue());
        return organization;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#updateOrganization(com.blossom.site.shiro.entity.Organization)
	 */
	public Organization updateOrganization(Organization organization) {
		final String sql = "update sys_organization set name=?, parent_id=?, parent_ids=?, available=? where id=?";
        jdbcTemplate.update(
                sql,
                organization.getName(), organization.getParentId(), organization.getParentIds(), organization.getAvailable(), organization.getId());
        return organization;
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#deleteOrganization(java.lang.Long)
	 */
	public void deleteOrganization(Long organizationId) {
		 Organization organization = findOne(organizationId);
	        final String deleteSelfSql = "delete from sys_organization where id=?";
	        jdbcTemplate.update(deleteSelfSql, organizationId);
	        final String deleteDescendantsSql = "delete from sys_organization where parent_ids like ?";
	        jdbcTemplate.update(deleteDescendantsSql, organization.makeSelfAsParentIds() + "%");
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#findOne(java.lang.Long)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Organization findOne(Long organizationId) {
		final String sql = "select id, name, parent_id, parent_ids, available from sys_organization where id=?";
        List<Organization> organizationList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), organizationId);
        if(organizationList.size() == 0) {
            return null;
        }
        return organizationList.get(0);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#findAll()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Organization> findAll() {
		 final String sql = "select id, name, parent_id, parent_ids, available from sys_organization";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class));
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#findAllWithExclude(com.blossom.site.shiro.entity.Organization)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Organization> findAllWithExclude(Organization excludeOraganization) {
		final String sql = "select id, name, parent_id, parent_ids, available from sys_organization where id!=? and parent_ids not like ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), excludeOraganization.getId(), excludeOraganization.makeSelfAsParentIds() + "%");
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月3日 下午3:32:41
	 * @see com.blossom.site.shiro.dao.IOrganizationDao#move(com.blossom.site.shiro.entity.Organization, com.blossom.site.shiro.entity.Organization)
	 */
	public void move(Organization source, Organization target) {
		 String moveSourceSql = "update sys_organization set parent_id=?,parent_ids=? where id=?";
	        jdbcTemplate.update(moveSourceSql, target.getId(), target.getParentIds(), source.getId());
	        String moveSourceDescendantsSql = "update sys_organization set parent_ids=concat(?, substring(parent_ids, length(?))) where parent_ids like ?";
	        jdbcTemplate.update(moveSourceDescendantsSql, target.makeSelfAsParentIds(), source.makeSelfAsParentIds(), source.makeSelfAsParentIds() + "%");
	}

}

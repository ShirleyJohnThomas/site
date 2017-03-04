package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description: 用户角色实体
 * @author Blossom
 * @time 2017年3月4日 下午10:32:20
 */
public class UserRoleEntity implements Serializable {

	private static final long serialVersionUID = -8798849182232624033L;

	private Integer userRoleId;
	private Integer userId;
	private Integer roleId;
	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}
	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:05:24
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRoleEntity [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午11:05:28
	 * @param userRoleId
	 * @param userId
	 * @param roleId
	 */
	public UserRoleEntity(Integer userRoleId, Integer userId, Integer roleId) {
		super();
		this.userRoleId = userRoleId;
		this.userId = userId;
		this.roleId = roleId;
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午11:05:30
	 */
	public UserRoleEntity() {
		
		super();
		
	}
	
	
	
}

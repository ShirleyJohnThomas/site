package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description:用户组实体
 * @author Blossom
 * @time 2017年3月4日 下午10:34:12
 */
public class UserGroupEntity implements Serializable {

	private static final long serialVersionUID = -8968024008300215330L;

	private Integer userGroupId;
	private Integer userId;
	private Integer groupId;
	/**
	 * @return the userGroupId
	 */
	public Integer getUserGroupId() {
		return userGroupId;
	}
	/**
	 * @param userGroupId the userGroupId to set
	 */
	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
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
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	
	
}

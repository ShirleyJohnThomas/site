package com.blossom.author.entity;

import java.io.Serializable;


/**
 * @Description: 组角色实体
 * @author Blossom
 * @time 2017年3月4日 下午10:28:09
 */
public class GroupRoleEntity implements Serializable {

	private static final long serialVersionUID = -2123882957266136891L;

	//组角色编号
	private Integer groupRoleId;
	//组编号
	private Integer groupId;
	//角色编号
	private Integer roleId;
	/**
	 * @return the groupRoleId
	 */
	public Integer getGroupRoleId() {
		return groupRoleId;
	}
	/**
	 * @param groupRoleId the groupRoleId to set
	 */
	public void setGroupRoleId(Integer groupRoleId) {
		this.groupRoleId = groupRoleId;
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
	 * @time 2017年3月4日 下午10:51:04
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GroupRoleEntity [groupRoleId=" + groupRoleId + ", groupId=" + groupId + ", roleId=" + roleId + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:51:07
	 */
	public GroupRoleEntity() {
		
		super();
		
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:51:10
	 * @param groupRoleId
	 * @param groupId
	 * @param roleId
	 */
	public GroupRoleEntity(Integer groupRoleId, Integer groupId, Integer roleId) {
		super();
		this.groupRoleId = groupRoleId;
		this.groupId = groupId;
		this.roleId = roleId;
	}
	
	
	
}

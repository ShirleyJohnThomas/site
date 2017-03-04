package com.blossom.author.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 角色实体
 * @author Blossom
 * @time 2017年3月4日 下午10:29:36
 */
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = -6955944925040712896L;

	// 角色编号
	private Integer roleId;
	// 角色父编号
	private Integer fatherRoleId;
	// 角色名称
	private String roleName;
	// 创建时间
	private Date createTime;
	// 角色说明
	private String roleDescription;

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the fatherRoleId
	 */
	public Integer getFatherRoleId() {
		return fatherRoleId;
	}

	/**
	 * @param fatherRoleId
	 *            the fatherRoleId to set
	 */
	public void setFatherRoleId(Integer fatherRoleId) {
		this.fatherRoleId = fatherRoleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription
	 *            the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午10:57:48
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleEntity [roleId=" + roleId + ", fatherRoleId=" + fatherRoleId + ", roleName=" + roleName
				+ ", createTime=" + createTime + ", roleDescription=" + roleDescription + "]";
	}

	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:57:51
	 * @param roleId
	 * @param fatherRoleId
	 * @param roleName
	 * @param createTime
	 * @param roleDescription
	 */
	public RoleEntity(Integer roleId, Integer fatherRoleId, String roleName, Date createTime, String roleDescription) {
		super();
		this.roleId = roleId;
		this.fatherRoleId = fatherRoleId;
		this.roleName = roleName;
		this.createTime = createTime;
		this.roleDescription = roleDescription;
	}

	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:57:54
	 */
	public RoleEntity() {

		super();

	}

}

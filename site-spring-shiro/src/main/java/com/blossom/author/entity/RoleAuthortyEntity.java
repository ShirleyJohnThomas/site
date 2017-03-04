package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description: 角色权限实体
 * @author Blossom
 * @time 2017年3月4日 下午10:30:39
 */
public class RoleAuthortyEntity implements Serializable {

	private static final long serialVersionUID = -429332272365887690L;

	private Integer roleAuthortyId;
	private Integer authortyId;
	private Integer roleId;
	private Integer authortyType;

	/**
	 * @return the roleAuthortyId
	 */
	public Integer getRoleAuthortyId() {
		return roleAuthortyId;
	}

	/**
	 * @param roleAuthortyId
	 *            the roleAuthortyId to set
	 */
	public void setRoleAuthortyId(Integer roleAuthortyId) {
		this.roleAuthortyId = roleAuthortyId;
	}

	/**
	 * @return the authortyId
	 */
	public Integer getAuthortyId() {
		return authortyId;
	}

	/**
	 * @param authortyId
	 *            the authortyId to set
	 */
	public void setAuthortyId(Integer authortyId) {
		this.authortyId = authortyId;
	}

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
	 * @return the authortyType
	 */
	public Integer getAuthortyType() {
		return authortyType;
	}

	/**
	 * @param authortyType
	 *            the authortyType to set
	 */
	public void setAuthortyType(Integer authortyType) {
		this.authortyType = authortyType;
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午10:59:29
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleAuthortyEntity [roleAuthortyId=" + roleAuthortyId + ", authortyId=" + authortyId + ", roleId="
				+ roleId + ", authortyType=" + authortyType + "]";
	}

	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:59:32
	 */
	public RoleAuthortyEntity() {

		super();

	}

	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:59:40
	 * @param roleAuthortyId
	 * @param authortyId
	 * @param roleId
	 * @param authortyType
	 */
	public RoleAuthortyEntity(Integer roleAuthortyId, Integer authortyId, Integer roleId, Integer authortyType) {
		super();
		this.roleAuthortyId = roleAuthortyId;
		this.authortyId = authortyId;
		this.roleId = roleId;
		this.authortyType = authortyType;
	}

}

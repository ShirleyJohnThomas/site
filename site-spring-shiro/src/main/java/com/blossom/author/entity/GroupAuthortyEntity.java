package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description: 组权限模型
 * @author Blossom
 * @time 2017年3月4日 下午10:27:20
 */
public class GroupAuthortyEntity implements Serializable {

	private static final long serialVersionUID = 4870626529860407623L;

	//组权限编号
	private Integer groupAuthortyId;
	//组编号
	private Integer groupId;
	//权限编号
	private Integer authortyId;
	//权限类型
	private Integer authortyType;
	/**
	 * @return the groupAuthortyId
	 */
	public Integer getGroupAuthortyId() {
		return groupAuthortyId;
	}
	/**
	 * @param groupAuthortyId the groupAuthortyId to set
	 */
	public void setGroupAuthortyId(Integer groupAuthortyId) {
		this.groupAuthortyId = groupAuthortyId;
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
	 * @return the authortyId
	 */
	public Integer getAuthortyId() {
		return authortyId;
	}
	/**
	 * @param authortyId the authortyId to set
	 */
	public void setAuthortyId(Integer authortyId) {
		this.authortyId = authortyId;
	}
	/**
	 * @return the authortyType
	 */
	public Integer getAuthortyType() {
		return authortyType;
	}
	/**
	 * @param authortyType the authortyType to set
	 */
	public void setAuthortyType(Integer authortyType) {
		this.authortyType = authortyType;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午10:44:52
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GroupAuthortyEntity [groupAuthortyId=" + groupAuthortyId + ", groupId=" + groupId + ", authortyId="
				+ authortyId + ", authortyType=" + authortyType + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:44:55
	 * @param groupAuthortyId
	 * @param groupId
	 * @param authortyId
	 * @param authortyType
	 */
	public GroupAuthortyEntity(Integer groupAuthortyId, Integer groupId, Integer authortyId, Integer authortyType) {
		super();
		this.groupAuthortyId = groupAuthortyId;
		this.groupId = groupId;
		this.authortyId = authortyId;
		this.authortyType = authortyType;
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:44:58
	 */
	public GroupAuthortyEntity() {
		
		super();
		
	}
	
	
	
}

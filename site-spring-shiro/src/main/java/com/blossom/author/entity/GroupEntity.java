package com.blossom.author.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 组实体
 * @author Blossom
 * @time 2017年3月4日 下午10:25:51
 */
public class GroupEntity implements Serializable {

	private static final long serialVersionUID = 1335823506344076240L;

	//组编号
	private Integer groupId;
	//组名称
	private String groupName;
	//组父编号
	private Integer fatherGroupId;
	//创建时间
	private Date createTime;
	//组说明
	private String groupDescription;
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
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the fatherGroupId
	 */
	public Integer getFatherGroupId() {
		return fatherGroupId;
	}
	/**
	 * @param fatherGroupId the fatherGroupId to set
	 */
	public void setFatherGroupId(Integer fatherGroupId) {
		this.fatherGroupId = fatherGroupId;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the groupDescription
	 */
	public String getGroupDescription() {
		return groupDescription;
	}
	/**
	 * @param groupDescription the groupDescription to set
	 */
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午10:42:36
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GroupEntity [groupId=" + groupId + ", groupName=" + groupName + ", fatherGroupId=" + fatherGroupId
				+ ", createTime=" + createTime + ", groupDescription=" + groupDescription + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:42:39
	 * @param groupId
	 * @param groupName
	 * @param fatherGroupId
	 * @param createTime
	 * @param groupDescription
	 */
	public GroupEntity(Integer groupId, String groupName, Integer fatherGroupId, Date createTime,
			String groupDescription) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.fatherGroupId = fatherGroupId;
		this.createTime = createTime;
		this.groupDescription = groupDescription;
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:42:43
	 */
	public GroupEntity() {
		
		super();
		
	}
	
	
	
}

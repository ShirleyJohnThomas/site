package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description:组织实体
 * @author Blossom
 * @time 2017年3月4日 下午10:29:03
 */
public class OriginizationEntity implements Serializable {

	private static final long serialVersionUID = 2013286838915856030L;

	//组织编号
	private Integer organizationId;
	//组织父编号
	private Integer fatherOrganizationId;
	//组织名称
	private String organizationName;
	//组织说明
	private String organizationDescription;
	/**
	 * @return the organizationId
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * @return the fatherOrganizationId
	 */
	public Integer getFatherOrganizationId() {
		return fatherOrganizationId;
	}
	/**
	 * @param fatherOrganizationId the fatherOrganizationId to set
	 */
	public void setFatherOrganizationId(Integer fatherOrganizationId) {
		this.fatherOrganizationId = fatherOrganizationId;
	}
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the organizationDescription
	 */
	public String getOrganizationDescription() {
		return organizationDescription;
	}
	/**
	 * @param organizationDescription the organizationDescription to set
	 */
	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:53:46
	 * @param organizationId
	 * @param fatherOrganizationId
	 * @param organizationName
	 * @param organizationDescription
	 */
	public OriginizationEntity(Integer organizationId, Integer fatherOrganizationId, String organizationName,
			String organizationDescription) {
		super();
		this.organizationId = organizationId;
		this.fatherOrganizationId = fatherOrganizationId;
		this.organizationName = organizationName;
		this.organizationDescription = organizationDescription;
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:53:49
	 */
	public OriginizationEntity() {
		
		super();
		
	}
	
	
	
}

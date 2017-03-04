package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description: 权限实体
 * @author Blossom
 * @time 2017年3月4日 下午10:21:35
 */
public class AuthortyEntity implements Serializable {

	private static final long serialVersionUID = 7883277785727469415L;

	//权限编号
	private Integer authortyId;
	//权限父编号
	private Integer fatherAuthoryId;
	//权限名称
	private String authoryName;
	//权限说明
	private String authoryDescription;
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
	 * @return the fatherAuthoryId
	 */
	public Integer getFatherAuthoryId() {
		return fatherAuthoryId;
	}
	/**
	 * @param fatherAuthoryId the fatherAuthoryId to set
	 */
	public void setFatherAuthoryId(Integer fatherAuthoryId) {
		this.fatherAuthoryId = fatherAuthoryId;
	}
	/**
	 * @return the authoryName
	 */
	public String getAuthoryName() {
		return authoryName;
	}
	/**
	 * @param authoryName the authoryName to set
	 */
	public void setAuthoryName(String authoryName) {
		this.authoryName = authoryName;
	}
	/**
	 * @return the authoryDescription
	 */
	public String getAuthoryDescription() {
		return authoryDescription;
	}
	/**
	 * @param authoryDescription the authoryDescription to set
	 */
	public void setAuthoryDescription(String authoryDescription) {
		this.authoryDescription = authoryDescription;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午10:39:06
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthortyEntity [authortyId=" + authortyId + ", fatherAuthoryId=" + fatherAuthoryId + ", authoryName="
				+ authoryName + ", authoryDescription=" + authoryDescription + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:39:19
	 */
	public AuthortyEntity() {
		
		super();
		
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午10:39:24
	 * @param authortyId
	 * @param fatherAuthoryId
	 * @param authoryName
	 * @param authoryDescription
	 */
	public AuthortyEntity(Integer authortyId, Integer fatherAuthoryId, String authoryName, String authoryDescription) {
		super();
		this.authortyId = authortyId;
		this.fatherAuthoryId = fatherAuthoryId;
		this.authoryName = authoryName;
		this.authoryDescription = authoryDescription;
	}
	
	
	
}

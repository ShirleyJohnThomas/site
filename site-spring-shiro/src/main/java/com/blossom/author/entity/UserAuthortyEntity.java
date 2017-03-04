package com.blossom.author.entity;

import java.io.Serializable;

/**
 * @Description: 用户权限实体
 * @author Blossom
 * @time 2017年3月4日 下午10:33:27
 */
public class UserAuthortyEntity implements Serializable {

	private static final long serialVersionUID = -3820411664775035321L;

	private Integer userAuthortyId;
	private Integer userId;
	private Integer authortyId;
	private String authortyType;
	/**
	 * @return the userAuthortyId
	 */
	public Integer getUserAuthortyId() {
		return userAuthortyId;
	}
	/**
	 * @param userAuthortyId the userAuthortyId to set
	 */
	public void setUserAuthortyId(Integer userAuthortyId) {
		this.userAuthortyId = userAuthortyId;
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
	public String getAuthortyType() {
		return authortyType;
	}
	/**
	 * @param authortyType the authortyType to set
	 */
	public void setAuthortyType(String authortyType) {
		this.authortyType = authortyType;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:03:41
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAuthortyEntity [userAuthortyId=" + userAuthortyId + ", userId=" + userId + ", authortyId="
				+ authortyId + ", authortyType=" + authortyType + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午11:03:44
	 */
	public UserAuthortyEntity() {
		
		super();
		
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午11:03:47
	 * @param userAuthortyId
	 * @param userId
	 * @param authortyId
	 * @param authortyType
	 */
	public UserAuthortyEntity(Integer userAuthortyId, Integer userId, Integer authortyId, String authortyType) {
		super();
		this.userAuthortyId = userAuthortyId;
		this.userId = userId;
		this.authortyId = authortyId;
		this.authortyType = authortyType;
	}
	
	
	
}

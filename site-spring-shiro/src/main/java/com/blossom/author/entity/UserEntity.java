package com.blossom.author.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户实体
 * @author Blossom
 * @time 2017年3月4日 下午10:31:33
 */
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -7390803801085285813L;

	private Integer userId;
	private Integer organizationId;
	private String longinAccount;
	private String loginPassword;
	private String userName;
	private String telephone;
	private String email;
	private Date createTime;
	private Date loginTime;
	private Date lastLoginTime;
	private Integer loginCount;
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
	 * @return the longinAccount
	 */
	public String getLonginAccount() {
		return longinAccount;
	}
	/**
	 * @param longinAccount the longinAccount to set
	 */
	public void setLonginAccount(String longinAccount) {
		this.longinAccount = longinAccount;
	}
	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}
	/**
	 * @param loginPassword the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @return the loginCount
	 */
	public Integer getLoginCount() {
		return loginCount;
	}
	/**
	 * @param loginCount the loginCount to set
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:02:01
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", organizationId=" + organizationId + ", longinAccount="
				+ longinAccount + ", loginPassword=" + loginPassword + ", userName=" + userName + ", telephone="
				+ telephone + ", email=" + email + ", createTime=" + createTime + ", loginTime=" + loginTime
				+ ", lastLoginTime=" + lastLoginTime + ", loginCount=" + loginCount + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午11:02:05
	 */
	public UserEntity() {
		
		super();
		
	}
	/**
	 * @author Blossom
	 * @time 2017年3月4日 下午11:02:08
	 * @param userId
	 * @param organizationId
	 * @param longinAccount
	 * @param loginPassword
	 * @param userName
	 * @param telephone
	 * @param email
	 * @param createTime
	 * @param loginTime
	 * @param lastLoginTime
	 * @param loginCount
	 */
	public UserEntity(Integer userId, Integer organizationId, String longinAccount, String loginPassword,
			String userName, String telephone, String email, Date createTime, Date loginTime, Date lastLoginTime,
			Integer loginCount) {
		super();
		this.userId = userId;
		this.organizationId = organizationId;
		this.longinAccount = longinAccount;
		this.loginPassword = loginPassword;
		this.userName = userName;
		this.telephone = telephone;
		this.email = email;
		this.createTime = createTime;
		this.loginTime = loginTime;
		this.lastLoginTime = lastLoginTime;
		this.loginCount = loginCount;
	}
	
	
	
}

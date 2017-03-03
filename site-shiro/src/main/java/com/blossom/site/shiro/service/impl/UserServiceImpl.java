package com.blossom.site.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blossom.site.shiro.dao.IUserDao;
import com.blossom.site.shiro.entity.User;
import com.blossom.site.shiro.service.RoleService;
import com.blossom.site.shiro.service.UserService;

import java.util.*;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午4:09:30
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserDao userDaoImpl;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private RoleService roleService;

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user) {
		// 加密密码
		passwordHelper.encryptPassword(user);
		return userDaoImpl.createUser(user);
	}

	public User updateUser(User user) {
		return userDaoImpl.updateUser(user);
	}

	public void deleteUser(Long userId) {
		userDaoImpl.deleteUser(userId);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword) {
		User user = userDaoImpl.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDaoImpl.updateUser(user);
	}

	public User findOne(Long userId) {
		return userDaoImpl.findOne(userId);
	}

	public List<User> findAll() {
		return userDaoImpl.findAll();
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userDaoImpl.findByUsername(username);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Set<String> findRoles(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Set<String> findPermissions(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
	}

}

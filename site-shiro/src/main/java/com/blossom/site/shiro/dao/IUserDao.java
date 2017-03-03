package com.blossom.site.shiro.dao;

import java.util.List;

import com.blossom.site.shiro.entity.User;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午3:26:23
 */
public interface IUserDao {

	User createUser(User user);

	User updateUser(User user);

	void deleteUser(Long userId);

	User findOne(Long userId);

	List<User> findAll();

	User findByUsername(String username);

}

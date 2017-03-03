package com.blossom.site.shiro.service;

import java.util.List;
import java.util.Set;

import com.blossom.site.shiro.entity.User;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午4:04:39
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     */
     User createUser(User user);

     User updateUser(User user);

     void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
     void changePassword(Long userId, String newPassword);


    User findOne(Long userId);

    List<User> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);

}

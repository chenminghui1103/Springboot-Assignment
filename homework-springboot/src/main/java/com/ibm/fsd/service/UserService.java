package com.ibm.fsd.service;

import com.ibm.fsd.domain.User;

import java.util.List;

/**
 * 用户管理Service
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 保存单个用户
     *
     * @param user 用户信息
     */
    void save(User user);

    /**
     * 保存用户集合
     *
     * @param list 用户信息列表
     */
    void save(List<User> list);

    /**
     * Find User by Login Name
     *
     * @return 用户
     */
    User findByLoginName(String loginName);

    boolean isLoginNameExist(String loginName);
}

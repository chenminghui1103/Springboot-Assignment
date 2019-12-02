package com.ibm.fsd.service.impl;

import com.ibm.fsd.repository.UserRepository;
import com.ibm.fsd.domain.User;
import com.ibm.fsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 用户管理Service实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }

    @Override
    public boolean isLoginNameExist(String loginName) {
        boolean isLoginNameExist = false;
        User user = this.findByLoginName(loginName);
        if(!ObjectUtils.isEmpty(user)) {
            isLoginNameExist = true;
        }
        return isLoginNameExist;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<User> list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                /*if (i % 2 == 1) {
                    throw new RuntimeException();
                }*/
                userRepository.save(list.get(i));
            }
        }
    }
}

package com.ibm.fsd.repository;

import com.ibm.fsd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户管理Repository
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLoginName(String loginName);
}

package com.ibm.fsd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户实体
 * 和数据库中t_user表映射
 */
@Entity
@Table(name = "t_user")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "password")
    private String password;
    @Column(name = "real_name")
    private String realName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @Column(name = "role")
    private String role;
}

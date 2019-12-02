package com.ibm.fsd.controller;

import com.ibm.fsd.domain.User;
import com.ibm.fsd.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用于管理Controller
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{login-user-name}")
    public User findUserByLoginUserName(@PathVariable("login-user-name") String loginUserName) {
        return userService.findByLoginName(loginUserName);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> save(@RequestBody User user){
        Boolean result = Boolean.FALSE;
        log.info("user = " + user);
        if(userService.isLoginNameExist(user.getLoginName())){
            return new ResponseEntity("The User Login Name is already Exist!",HttpStatus.EXPECTATION_FAILED);
        }
        userService.save(user);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user){
        Boolean result = Boolean.FALSE;
        User dbUser = userService.findByLoginName(user.getLoginName());
        if(!ObjectUtils.isEmpty(dbUser)){
            user.setId(dbUser.getId());
            userService.save(user);
            result = Boolean.TRUE;
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> Login(@RequestBody User user) {
        Boolean result = Boolean.FALSE;
        log.info("user = " + user);
        User dbUser = userService.findByLoginName(user.getLoginName());
        if(!ObjectUtils.isEmpty(dbUser)){
            if(dbUser.getPassword().equals(user.getPassword())){
                result = Boolean.TRUE;
            }
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/init")
    public String initUser() {
        User u1 = new User();
        u1.setLoginName("zhangsan");
        u1.setPassword("zhangsan");
        u1.setRealName("张三");
        u1.setPhone("16666666666");
        u1.setEmail("zhangsan@163.com");
        u1.setRole("1");
        u1.setBirth(new Date());

        User u2 = new User();
        u2.setLoginName("lisi");
        u2.setPassword("lisi");
        u2.setRealName("李四");
        u2.setPhone("17777777777");
        u2.setEmail("zhangsan@tencent.com");
        u2.setRole("2");
        u2.setBirth(new Date());

        User u3 = new User();
        u3.setLoginName("wangwu");
        u3.setPassword("wangwu");
        u3.setRealName("王五");
        u3.setPhone("18888888888");
        u3.setEmail("wangwu@dmall.com");
        u3.setRole("2");
        u3.setBirth(new Date());

        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        userService.save(list);
        return "save multi user success!";
    }
}

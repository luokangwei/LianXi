package com.org;

import com.org.mapper.UserMapper;
import com.org.pojo.User;
import com.org.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OaApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @Test
    public void test02(){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

}

package com.cw.test.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SpringbootTestApplicationTests {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAllUsers();
        System.out.println("清空user表");
    }

    @Test
    public void test() throws Exception {
        System.out.println("插入5个用户");
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
        // 查数据库，应该有5个用户

        Assert.assertEquals(5, userService.getAllUsers().intValue());
        // 删除两个用户
        userService.deleteByName("a");
        userService.deleteByName("e");
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }
}

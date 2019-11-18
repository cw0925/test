package com.cw.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")

    public String hello(){
        // 通过jdbcTemplate查询数据库
        String sql = "SELECT name FROM user WHERE id = ?";
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);
        return "Hello " + mobile;
    }

}

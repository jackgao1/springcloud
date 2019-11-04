package com.gaoxin.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @GetMapping("demo")
    public Object getData(){
        return jdbcTemplate.queryForList("select * from tb_item");
    }
}

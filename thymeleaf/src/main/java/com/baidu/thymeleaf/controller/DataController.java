package com.baidu.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataController {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    //教程：https://www.cnblogs.com/nicknailo/p/8947643.html
//    @RequestMapping(value = "/show", method = RequestMethod.GET)
//    public String show(Model model) {
//        System.out.println(jdbcTemplate.queryForMap("select * from t_ga_fwjbxx").toString());
//        model.addAttribute("uid", "123456789");
//        model.addAttribute("name", "Jerry");
//        return "index";
//    }
//
//    @GetMapping("get")
//    @ResponseBody
//    public Object get() {
//        return jdbcTemplate.queryForList("select * from t_ga_fwjbxx");
//    }

    @GetMapping("test")
    @ResponseBody
    public Object test() {
        return "aa";
    }
}

package com.baidu.server1.controller;

import com.baidu.server1.service.Server1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @Autowired
    private Server1Service server1Service;

    @GetMapping("get")
    private Object get(@RequestParam("msg") String msg) {
        return "这是1的数据"+msg;
    }

    //服务之间通讯
    @GetMapping("getServer2")
    public Object getServer1(String msg) {
        return server1Service.getServer2(msg);
    }
}

package com.baidu.server1.controller;

import com.baidu.server1.service.Server1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @Autowired
    private Server1 server1;

    @GetMapping("get")
    private Object get(@RequestParam("msg") String msg) {
        return getServer1(msg);
    }

    //服务之间通讯
    @GetMapping("getServer2")
    public Object getServer1(String msg) {
        return server1.getServer2(msg);
    }

    @GetMapping("oa")
    private Object oa(@RequestParam("msg") String msg) {
        return getServer1(msg);
    }

}

package com.baidu.server2.controller;

import com.baidu.server2.service.Server2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Server2Controller {
    @Autowired
    private Server2 server2;

    @GetMapping("get")
    private Object get(@RequestParam("msg") String msg) {
        return "这是2的数据"+msg;
    }

    //服务之间通讯
    @GetMapping("getServer1")
    public Object getServer1(String msg) {
        return server2.getServer1(msg);
    }
}

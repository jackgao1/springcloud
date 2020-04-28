package com.baidu.server2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Server2 {
    @Autowired
    private RestTemplate restTemplate;

    public Object getServer1(String msg){
        return restTemplate.getForObject("http://server1/get?msg"+msg,String.class);
    }
}

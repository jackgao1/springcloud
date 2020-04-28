package com.baidu.server1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Server1 {
    @Autowired
    private RestTemplate restTemplate;

    public Object getServer2(String msg){
        return restTemplate.getForObject("http://server2/get?msg"+msg,String.class);
    }
}

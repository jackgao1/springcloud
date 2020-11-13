package com.baidu.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@SpringBootApplication
public class Oauth2Application extends AuthorizationServerConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}

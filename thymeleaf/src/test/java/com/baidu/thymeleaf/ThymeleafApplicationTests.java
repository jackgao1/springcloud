package com.baidu.thymeleaf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.codec.binary.Base64;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafApplicationTests {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        jdbcTemplate.queryForList("select * from T_GA_FWJBXX");
    }

    @Test
    public void test2() {
        byte[] bytes = jdbcTemplate.queryForObject("select zp from t_syrk_photo where rid='340123196610252084342032510433437'", byte[].class);
        String s = Base64.encodeBase64String(bytes);
        System.out.println(s);
    }
}


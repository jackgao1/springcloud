package com.baidu.server1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Server1ApplicationTests {

    @Autowired
    @Qualifier("my1JdbcTemplate")
    protected JdbcTemplate my1JdbcTemplate;
    @Autowired
    @Qualifier("my2JdbcTemplate")
    protected JdbcTemplate my2JdbcTemplate;

    @Test
    public void contextLoads() {
        System.out.println(my1JdbcTemplate.queryForMap("select * from user").toString());
        System.out.println(my2JdbcTemplate.queryForMap("select * from user").toString());
    }
}

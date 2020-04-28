package com.baidu.tsetserver.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TokenController {

    Logger logger = LoggerFactory.getLogger(TokenController.class);

    @Autowired
    private  Md5TokenGenerator tokenGenerator;

    @Autowired
    private UserDao userDao;

    @GetMapping("/welcome")
    public String Welcome(){

        return "welcome TokenController ";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseTemplate Login(String username, String password) {

        logger.info("用户名username为:"+username+   "密码password为:"+password);
        User user = userDao.getUser(username,password);
        logger.info("从数据库查出来的用户user为:"+user);

        JSONObject obj = new JSONObject();
        if (user != null) {
            String token = SetRedisData(username, password);
            obj.put("status", "用户登录成功");
            obj.put("token", token);
        } else {
            obj.put("status", "用户登录失败");
        }
        return ResponseTemplate.builder().code(200).message("用户登录成功").data(obj).build();

    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @AuthToken
    public ResponseTemplate test() {
        logger.info("**************测试start**************");

        return ResponseTemplate.builder().code(200).message("测试成功").data("测试数据").build();
    }
    /**
     * 在redis中进行数据的绑定
     * @Title: SetRedisData
     * @Description: TODO
     * @param username
     * @param password
     * @return
     * @author chengshengqing  2019年7月2日
     */
    private String SetRedisData(String username, String password) {
        //此处主要设置你的redis的ip和端口号，我的redis是在本地
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String token = tokenGenerator.generate(username, password);
        jedis.set(username, token);
        //设置key过期时间，到期会自动删除
        jedis.expire(username, CommonUtil.TOKEN_EXPIRE_TIME);
        //将token和username以键值对的形式存入到redis中进行双向绑定
        jedis.set(token, username);
        jedis.expire(token, CommonUtil.TOKEN_EXPIRE_TIME);
        Long currentTime = System.currentTimeMillis();
        jedis.set(token + username, currentTime.toString());
        //用完关闭
        jedis.close();
        return token;
    }
}
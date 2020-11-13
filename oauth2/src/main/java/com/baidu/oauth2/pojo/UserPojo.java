package com.baidu.oauth2.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/26$ 下午9:29$
 * @Description: 用户表实体
 */

@Data
public class UserPojo implements Serializable {

    private Integer id;
    private String name;
    private String mobile;
    private String mail;
    private String pwd;

    public UserPojo() {
    }
}

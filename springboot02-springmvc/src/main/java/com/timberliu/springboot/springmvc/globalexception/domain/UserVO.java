package com.timberliu.springboot.springmvc.globalexception.domain;

/**
 * @date: 2020/5/26
 * @author: Timber
 */
public class UserVO {

    private Integer id;

    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

}

package com.timberliu.dubbo.dto;

import java.io.Serializable;

/**
 * created by Timber in 2020/7/25
 */
public class UserDTO implements Serializable {

    private Integer id;

    private String name;

    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}

package com.learn.web.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RUSLAN77 on  23.02.2018 in Ukraine
 */
public class User {
    private Integer userId;
    private String userName;
    private Integer departmentId;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int age;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;

    }

    public User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void setName(String userName) {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


}
package com.learn.web.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RUSLAN77 on  29.01.2018 in Ukraine
 */
public class Department {
    private Integer id;
    private String name;

//    public Department(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Department() {

    }

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


    private static Map<Integer, User> userMap = new HashMap<>();

    public static void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public static Collection getUsers() {
        return userMap.values();
    }

    public static Integer getNewUserId() {
        int maxId = 0;
        for (Integer integer : userMap.keySet()) {
            if (integer > maxId) {
                maxId = integer;
            }
        }
        return maxId + 1;

    }

    public static User getUserById(Integer id) {
        return userMap.get(id);
    }

    public static void removeUser (Integer paramId){
        userMap.remove(paramId);
    }
}


package com.learn.web.service;

import com.learn.web.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  14.03.2018 in Ukraine
 */
public interface UserService {

    User getUserById(Integer id) throws ClassNotFoundException, SQLException;

    List<User> getUser() throws ClassNotFoundException, SQLException;

    List<User> getUsers(Integer departmentId) throws ClassNotFoundException, SQLException;

    void addUser(User user) throws ClassNotFoundException, SQLException;

    void removeUser(Integer id) throws ClassNotFoundException, SQLException;

    void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException;
}

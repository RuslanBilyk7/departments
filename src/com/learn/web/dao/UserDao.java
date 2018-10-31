package com.learn.web.dao;


import com.learn.web.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  13.03.2018 in Ukraine
 */
public interface UserDao {
    User getUserById(Integer id) throws ClassNotFoundException, SQLException;

    List<User> getUsers(Integer departmentId) throws ClassNotFoundException, SQLException;

    void addUser(User department) throws ClassNotFoundException, SQLException;

    void removeUser(Integer id) throws ClassNotFoundException, SQLException;

    void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException;
}

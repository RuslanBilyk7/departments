package com.learn.web.service.impl;

import com.learn.web.dao.UserDao;
import com.learn.web.model.User;
import com.learn.web.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  14.03.2018 in Ukraine
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Integer id) throws ClassNotFoundException, SQLException {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUser() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public List<User> getUsers(Integer departmentId) throws ClassNotFoundException, SQLException {
        return userDao.getUsers(departmentId);
    }

    @Override
    public void addUser(User user) throws ClassNotFoundException, SQLException {
        userDao.addUser(user);
    }

    @Override
    public void removeUser(Integer id) throws ClassNotFoundException, SQLException {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException {
        userDao.updateUser(id, name, age);
    }
}

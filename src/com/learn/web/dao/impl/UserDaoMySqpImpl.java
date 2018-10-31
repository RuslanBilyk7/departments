package com.learn.web.dao.impl;

import com.learn.web.dao.UserDao;
import com.learn.web.model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RUSLAN77 on  14.03.2018 in Ukraine
 */
public class UserDaoMySqpImpl implements UserDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/departments";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement prst = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Integer id)
            throws ClassNotFoundException, SQLException {
        ResultSet rs = null;

        User user = null;

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "SELECT id, name, age, departmentId FROM users where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("id"));
                user.setUserName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setDepartmentId(rs.getInt("departmentId"));
                return user;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return user;
    }

    @Override
    public List<User> getUsers(Integer departmentId) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        List<User> users;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

            String sql = "SELECT id, name, age FROM users WHERE departmentId = " + departmentId + " ORDER BY name";
            rs = stmt.executeQuery(sql);

            users = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                User user = new User();
                user.setUserId(id);
                user.setAge(age);
                user.setUserName(name);
                users.add(user);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        return users;
    }

    @Override
    public void addUser(User user)
            throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "INSERT INTO users(name,age,departmentId) VALUES(?,?,?)";
            prst = conn.prepareStatement(sql);
            prst.setString(1, user.getUserName());
            prst.setInt(2, user.getAge());
            prst.setInt(3, user.getDepartmentId());
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }

    @Override
    public void removeUser(Integer id) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "DELETE FROM users WHERE id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }

    }

    @Override
    public void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "UPDATE users SET name=?,age=? WHERE id=?";
            prst = conn.prepareStatement(sql);
            prst.setString(1, name);
            prst.setInt(2, age);
            prst.setInt(3, id);

//            prst.setString(3, departmentId);????????

            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }
}

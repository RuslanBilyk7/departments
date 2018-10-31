package com.learn.web.dao.impl;

import com.learn.web.dao.DepartmentDao;
import com.learn.web.model.Department;
import java.sql.*;
import java.util.*;

public class DepartmentDaoMySqlImpl implements DepartmentDao {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/departments";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement prst = null;
    //Для использования SQL запросов существуют 3 типа объектов:
    //1.Statement: используется для простых случаев без параметров
    //2.PreparedStatement: предварительно компилирует запросы,
    //которые могут содержать входные параметры
      // ? - место вставки нашего значеня

    //3.CallableStatement: используется для вызова хранимых функций,
    // которые могут содержать входные и выходные параметры


    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department getDepartmentById(Integer id)
            throws ClassNotFoundException, SQLException {
        ResultSet rs = null;

        Department department = null;

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            /*Для соединения с базой данных используют класс Connection:
Connection dbh = DriverManager.getConnection(url, user, passwd);
Здесь url - это строка, по которой JDBC определяет куда, где и чем устанавливать соединение. Она имеет следующий формат:
jdbc:postgresql:база_данных
jdbc:postgresql://сервер/база_данных
jdbc:postgresql://сервер:порт/база_данных*/

            String sql = "SELECT id, name FROM departments where id = ?";
            //sq1 это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать
            //метод next() , с помощью которого переходим к следующему элементу

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

                rs = preparedStatement.executeQuery();

            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return department;
    }

    @Override
    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        List<Department> departments;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

            String sql = "SELECT id, name FROM departments ORDER BY name";
            rs = stmt.executeQuery(sql);

            departments = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Department department = new Department();
                department.setId(id);
                department.setName(name);
                departments.add(department);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        return departments;
    }

    @Override
    public void addDepartment(Department department)
            throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "INSERT INTO departments(name) VALUES(?)";

            //Создаём соединение
            prst = conn.prepareStatement(sql);
            prst.setString(1, department.getName());


          /*  executeQuery () --- Обычно используется для чтения содержимого базы данных. Результат будет в виде ResultSet . Обычно используется инструкция SELECT.

            executeUpdate () --- Обычно это используется для изменения баз данных. В общем случае DROP TABLE или DATABASE, INSERT to TABLE, UPDATE TABLE, DELETE из операторов TABLE будут использоваться в этом. Вывод будет в форме int . Это значение int обозначает количество строк, на которые влияет запрос.

           execute () --- Если вы не знаете, какой метод будет использоваться для выполнения операторов SQL, этот метод можно использовать. Это вернет логическое значение . TRUE указывает, что результатом является ResultSet и FALSE указывает, что оно имеет значение int, которое обозначает количество строк, затронутых запросом.*/

            //если функция вставляет или обновляет, то используется метод executeUpdate
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }

    @Override
    public void removeDepartment(Integer id) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "DELETE FROM departments WHERE id = ?";
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
    public void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "UPDATE departments SET name=? WHERE id=?";
            prst = conn.prepareStatement(sql);
            prst.setInt(2, id);
            prst.setString(1, name);
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }
}
package com.learn.web.dao;

import com.learn.web.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  12.03.2018 in Ukraine
 */
public interface DepartmentDao {

    Department getDepartmentById(Integer id) throws ClassNotFoundException, SQLException;

    List<Department> getDepartments() throws ClassNotFoundException, SQLException;

    void addDepartment(Department department) throws ClassNotFoundException, SQLException;

    void removeDepartment(Integer id) throws ClassNotFoundException, SQLException;

    void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException;
}

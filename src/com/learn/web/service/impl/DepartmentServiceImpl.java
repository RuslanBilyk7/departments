package com.learn.web.service.impl;

import com.learn.web.dao.DepartmentDao;
import com.learn.web.model.Department;
import com.learn.web.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  12.03.2018 in Ukraine
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;


    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department getDepartmentById(Integer id) throws ClassNotFoundException, SQLException {
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
        return departmentDao.getDepartments();
    }

    @Override
    public void addDepartment(Department department) throws ClassNotFoundException, SQLException {
        departmentDao.addDepartment(department);
    }

    @Override
    public void removeDepartment(Integer id) throws ClassNotFoundException, SQLException {
        departmentDao.removeDepartment(id);
    }

    @Override
    public void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException {
        departmentDao.updateDepartment(id, name);
    }
}

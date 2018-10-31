package com.learn.web.servlets;

import com.learn.web.dao.impl.DepartmentDaoMySqlImpl;
import com.learn.web.holder.DepartmentsHolder;
import com.learn.web.model.Department;
import com.learn.web.service.DepartmentService;
import com.learn.web.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RUSLAN77 on  29.01.2018 in Ukraine
 */
@WebServlet("/departmentsServlet")
public class DepartmentsServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentDaoMySqlImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        DepartmentsHolder.addDepartment(new Department(1, "fdfd"));
        try {
            req.setAttribute("listOfDepartments", departmentService.getDepartments());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("departmentsList.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}

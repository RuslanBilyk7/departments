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

/**
 * Created by RUSLAN77 on  23.02.2018 in Ukraine
 */
@WebServlet("/removeDepartments")
public class RemoveDepartmentsServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentDaoMySqlImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("departmentId");
        if (paramId != null) {
            Integer id = Integer.valueOf(paramId);
            try {
                departmentService.removeDepartment(id);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/departmentsServlet");
    }
}

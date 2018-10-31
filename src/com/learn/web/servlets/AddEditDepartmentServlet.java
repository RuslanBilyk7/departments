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
@WebServlet("/addEditDepartment")
public class AddEditDepartmentServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentDaoMySqlImpl());
    private Department department;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("departmentId");
        if (paramId != null) {
            Integer departmentId = Integer.valueOf(paramId);
            Department department = null;
            try {
                department = departmentService.getDepartmentById(departmentId);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("department", department);
        }
        req.getRequestDispatcher("addEditDepartment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentName = req.getParameter("departmentName");

        String departmentId = req.getParameter("departmentId");
        if (departmentId == null || departmentId.isEmpty()) {
            Department department = new Department();
            department.setName(departmentName);

            if (departmentName != null) {

                try {
                    departmentService.addDepartment(department);

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
//                DepartmentsHolder.addDepartment(department);
            }
        } else {
            Integer id = Integer.valueOf(departmentId);
            try {
                departmentService.updateDepartment(id, departmentName);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
//            DepartmentsHolder.getDepartmentById(id).setName(departmentName);
        }

        resp.sendRedirect("/departmentsServlet");
    }
//        req.getRequestDispatcher("/departmentsList").forward(req, resp);

}


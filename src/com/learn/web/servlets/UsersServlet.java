package com.learn.web.servlets;

import com.learn.web.dao.impl.DepartmentDaoMySqlImpl;
import com.learn.web.dao.impl.UserDaoMySqpImpl;
import com.learn.web.holder.DepartmentsHolder;
import com.learn.web.model.Department;
import com.learn.web.model.User;
import com.learn.web.service.DepartmentService;
import com.learn.web.service.UserService;
import com.learn.web.service.impl.DepartmentServiceImpl;
import com.learn.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usersServlet")
/**
 * Created by RUSLAN77 on  23.02.2018 in Ukraine
 */
public class UsersServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl(new UserDaoMySqpImpl());
    private DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentDaoMySqlImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String departmentId = req.getParameter("departmentId");
            if (departmentId != null) {
                req.setAttribute("listOfUsers", userService.getUsers(Integer.valueOf(departmentId)));
                req.setAttribute("departmentId", departmentId);
                req.setAttribute("departmentName", departmentService.getDepartmentById(Integer.valueOf(departmentId)).getName());

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.learn.web.servlets;


import com.learn.web.dao.impl.UserDaoMySqpImpl;
import com.learn.web.holder.DepartmentsHolder;
import com.learn.web.model.Department;
import com.learn.web.model.User;
import com.learn.web.service.UserService;
import com.learn.web.service.impl.UserServiceImpl;

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
@WebServlet("/addEditUser")
public class AddEditUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl(new UserDaoMySqpImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParam = req.getParameter("userId");
        String departmentId = req.getParameter("departmentId");

        if (userIdParam != null) {
            Integer userId = Integer.valueOf(userIdParam);
            User user = null;    //EDIT
            try {
                user = userService.getUserById(userId);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("user", user);

        }
        req.setAttribute("departmentId", departmentId);
        req.getRequestDispatcher("addEditUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userId = req.getParameter("userId");
        String departmentId = req.getParameter("departmentId");
        String age = req.getParameter("age");

        if (userId == null || userId.isEmpty()) {
            User user = new User();
            user.setUserName(userName);
            user.setAge (Integer.valueOf(age));
            user.setDepartmentId(Integer.valueOf(departmentId));
            try {
                userService.addUser(user);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            Integer id = Integer.valueOf(userId);
            try {
                userService.updateUser(id, userName, Integer.valueOf(age));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        resp.sendRedirect("/usersServlet?departmentId="+departmentId);
//        req.getRequestDispatcher("/usersServlet").forward(req, resp);
    }
//        req.getRequestDispatcher("/departmentsList").forward(req, resp);

}


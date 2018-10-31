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

/**
 * Created by RUSLAN77 on  23.02.2018 in Ukraine
 */
@WebServlet("/removeUsers")
public class RemoveUsersServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl(new UserDaoMySqpImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentId = req.getParameter("departmentId");
        String paramId = req.getParameter("userId");
        if (paramId != null) {
            Integer id = Integer.valueOf(paramId);
            try {
                userService.removeUser(id);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
//            DepartmentsHolder.removeDepartment(id);
        }
        resp.sendRedirect("/usersServlet?departmentId="+Integer.valueOf(departmentId));
    }
}

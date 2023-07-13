package com.example.demo.controllers;

import com.example.demo.hibernate_dao.UserService;
import com.example.demo.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUsers", value = "/admin_users")
public class AdminUsers extends HttpServlet {
    UserService userService;
    List<User> users;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        users = userService.getAllUsers();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("content", "admin_users.jsp");
        request.setAttribute("usersListJsp", users);
        request.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

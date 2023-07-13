package com.example.demo.controllers;

import com.example.demo.hibernate_dao.OrderService;
import com.example.demo.hibernate_dao.UserService;
import com.example.demo.models.Order;
import com.example.demo.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserAccount", value = "/user_account")
public class UserAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("userId");
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        User user = userService.getUserById(userId);
        List<Order> orderList = orderService.getOrderByUser(user);

        request.setAttribute("user", user);
        request.setAttribute("orderList", orderList);
        request.setAttribute("title", "Личный кабинет");
        request.setAttribute("content", "user_account.jsp");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

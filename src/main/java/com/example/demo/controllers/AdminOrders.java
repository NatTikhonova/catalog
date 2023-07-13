package com.example.demo.controllers;

import com.example.demo.hibernate_dao.OrderService;
import com.example.demo.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrders", value = "/admin_orders")
public class AdminOrders extends HttpServlet {
    OrderService orderService;
    List<Order> orders;

    @Override
    public void init() throws ServletException {
        orderService = new OrderService();
        orders = orderService.getAllOrder();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("content", "admin_orders.jsp");
        request.setAttribute("ordersListJsp", orders);
        request.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

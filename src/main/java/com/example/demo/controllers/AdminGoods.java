package com.example.demo.controllers;

import com.example.demo.hibernate_dao.GoodService;
import com.example.demo.models.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminGoods", value = "/admin_goods")
public class AdminGoods extends HttpServlet {
    GoodService goodService;
    List<Good> goods;

    @Override
    public void init() throws ServletException {
        goodService = new GoodService();
        goods = goodService.getAllGoods();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("content", "admin_goods.jsp");
        request.setAttribute("goodsListJsp", goods);
        request.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

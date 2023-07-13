package com.example.demo.controllers;

import com.example.demo.hibernate_dao.GoodService;
import com.example.demo.models.Good;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Catalog", value = "/catalog")
public class Catalog extends HttpServlet {
    GoodService goodService;
    List<Good> goods;

    @Override
    public void init() {
        goodService = new GoodService();
        goods = goodService.getAllGoods();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);

        request.setAttribute("goodsListJsp", goods);
        request.setAttribute("title", "Каталог");
        request.setAttribute("content", "catalog.jsp");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

package com.example.demo.controllers;

import com.example.demo.hibernate_dao.GoodService;
import com.example.demo.models.Good;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CardGood", value = "/cardGood")
public class CardGood extends HttpServlet {
    GoodService goodService = new GoodService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        if (id != null){
            Good good = goodService.getGoodById(Integer.parseInt(id));
            request.setAttribute("good", good);
            request.setAttribute("title", good.getName());
            request.setAttribute("content", "cardGood.jsp");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}

package com.example.demo.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Authorization", value = "/authorization")
public class Authorization extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if(action != null) {
            if (action.equals("del")){
                HttpSession session = request.getSession(false);
                session.invalidate();
                response.sendRedirect("/catalog");
            }
        } else {
            request.setAttribute("title", "Авторизация");
            request.setAttribute("content", "authorization.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

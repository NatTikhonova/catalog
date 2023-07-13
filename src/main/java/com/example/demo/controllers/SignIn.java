package com.example.demo.controllers;

import com.example.demo.hibernate_dao.CartService;
import com.example.demo.hibernate_dao.UserService;
import com.example.demo.models.FormCheck;
import com.example.demo.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignIn", value = "/sign-in")
public class SignIn extends HttpServlet {
    private static final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CartService cartService = new CartService();
        String signInEmail = request.getParameter("signInEmail");
        String signInPassword = request.getParameter("signInPassword");

        if (FormCheck.isSuccessCheck(FormCheck.EMAIL_RULE, signInEmail)
                && FormCheck.isSuccessCheck(FormCheck.PASSWORD_RULE, signInPassword)){
            User user = userService.getByEmail(signInEmail);
            if (user != null){
                if (user.getPassword().equals(signInPassword)){
                    response.getWriter().print("Авторизация прошла успешно!");
                    HttpSession session = request.getSession(false);
                    cartService.addUserToCart(session, user);
                    session.setAttribute("userId", user.getUserId());
                    session.setAttribute("isAdmin", user.getIsAdmin());
                } else {
                    response.getWriter().print("Не верный пароль");
                }
            } else {
                response.getWriter().print("Пользователь не найден");
            }
        } else {
            response.getWriter().print("Некорректные данные");
        }
    }
}

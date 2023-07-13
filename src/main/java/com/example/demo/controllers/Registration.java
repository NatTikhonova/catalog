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

@WebServlet(name = "Registration", value = "/registration")
public class Registration extends HttpServlet {
    private static final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CartService cartService = new CartService();
        String regFirstName = request.getParameter("regFirstName");
        String regLastName = request.getParameter("regLastName");
        String regEmail = request.getParameter("regEmail");
        String regPhone = request.getParameter("regPhone");
        String regPassword = request.getParameter("regPassword");
        System.out.println(userService.getByEmail(regEmail));

        boolean isFirstName = !regEmail.isEmpty() && FormCheck.isSuccessCheck(FormCheck.NAME_RULE, regFirstName);
        boolean isLastName = regLastName.isEmpty() || FormCheck.isSuccessCheck(FormCheck.NAME_RULE, regLastName);
        boolean isEmail = !regEmail.isEmpty() && FormCheck.isSuccessCheck(FormCheck.EMAIL_RULE, regEmail);
        boolean isPhone = regPhone.isEmpty() || FormCheck.isSuccessCheck(FormCheck.NUMBER_RULE, regPhone);
        boolean isPassword = !regPassword.isEmpty() && FormCheck.isSuccessCheck(FormCheck.PASSWORD_RULE, regPassword);

        if (isFirstName && isLastName && isEmail && isPhone && isPassword) {
            if (userService.getByEmail(regEmail) != null) {
                response.getWriter().print("Пользователь с данной почтой уже зарегистрирован");
            } else {
                User user = new User(regFirstName, regLastName, regPhone, regEmail, regPassword, false);
                userService.saveUser(user);
                if (user.getUserId() != 0) {
                    response.getWriter().print("Регистрация прошла успешно!");
                    HttpSession session = request.getSession(false);
                    cartService.addUserToCart(session, user);
                    session.setAttribute("userId", user.getUserId());
                    session.setAttribute("isAdmin", user.getIsAdmin());
                } else {
                    response.getWriter().print("Ошибка записи данных");
                }
            }
        } else {
            response.getWriter().print("Некорректные данные");
        }
    }
}

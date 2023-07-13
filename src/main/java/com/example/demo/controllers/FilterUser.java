package com.example.demo.controllers;

import com.example.demo.hibernate_dao.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class FilterUser implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest requestHttp = (HttpServletRequest) request;
        HttpServletResponse responseHttp = (HttpServletResponse) response;
        HttpSession session = requestHttp.getSession(false);
        UserService userService = new UserService();

        if (session != null && session.getAttribute("userId") != null) {
            String name = userService.getUserById((Integer) session.getAttribute("userId")).getFirstName();
            if (session.getAttribute("isAdmin").equals(true)) {
                requestHttp.setAttribute("authorization", "aut_admin_user.jsp");
            } else {
                requestHttp.setAttribute("authorization", "aut_yes_user.jsp");
            }
            if (name != null) {
                requestHttp.setAttribute("userFirstName", name);
            }
        } else {
            requestHttp.setAttribute("authorization", "aut_no_user.jsp");
        }

        chain.doFilter(request, response);
    }
}

package com.example.demo.controllers;

import com.example.demo.hibernate_dao.CartService;
import com.example.demo.hibernate_dao.UserService;
import com.example.demo.models.Cart;
import com.example.demo.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "FilterCart")
public class FilterCart implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest requestHttp = (HttpServletRequest) request;
        HttpServletResponse responseHttp = (HttpServletResponse) response;
        HttpSession session = requestHttp.getSession(false);
        CartService cartService = new CartService();
        UserService userService = new UserService();
        List<Cart> cartList = null;

        if (session != null) {
            if (session.getAttribute("userId") != null) {
                User user = userService.getUserById((Integer) session.getAttribute("userId"));
                cartList = cartService.getCartByUserId(user);
            } else {
                cartList = cartService.getCartBySessionId(session.getId());
            }
        }
        requestHttp.setAttribute("countCart", cartService.countCart(cartList));
        chain.doFilter(request, response);
    }
}
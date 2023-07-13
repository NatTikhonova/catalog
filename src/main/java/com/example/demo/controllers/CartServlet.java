package com.example.demo.controllers;

import com.example.demo.hibernate_dao.*;
import com.example.demo.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Cart", value = "/cart")
public class CartServlet extends HttpServlet {
    List<Cart> cartList;
    private static final CartService cartService = new CartService();
    HttpSession session;
    private static final UserService userService = new UserService();
    User user;
    private static final OrderService orderService = new OrderService();
    GoodOrderService goodOrderService;
    private static final GoodService goodService = new GoodService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        session = request.getSession(false);
        if (session.getAttribute("userId") != null) {
            user = userService.getUserById((Integer) session.getAttribute("userId"));
            cartList = cartService.getCartByUserId(user);
        } else {
            cartList = cartService.getCartBySessionId(session.getId());
        }

        int sum = 0;
        for (Cart cart : cartList) {
            sum += cart.getGood().getPrice() * cart.getCount();
        }

        request.setAttribute("title", "Корзина");
        request.setAttribute("content", "cart.jsp");
        request.setAttribute("cartListJsp", cartList);
        request.setAttribute("totalCartValue", sum);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        session = request.getSession(false);

        String actionCart = request.getParameter("actionCart");

        switch (actionCart) {
            case "addCart":
                String sessionId = session.getId();
                int goodId = Integer.parseInt(request.getParameter("goodId"));
                String actionGood = request.getParameter("actionGood");
                Good good = goodService.getGoodById(goodId);

                if (good != null) {
                    Cart cartOld = cartService.searchCart(good, sessionId, user);
                    if (cartOld != null) {
                        cartOld.setCount(cartOld.getCount() + 1);
                        cartService.updateCart(cartOld);
                        response.getWriter().print("Товар обновлён");
                    } else {
                        Cart cartNew = new Cart(user, sessionId, good);
                        cartService.saveCart(cartNew);
                        if (cartNew.getCartId() != 0) {
                            response.getWriter().print("Товар добавлен");
                        } else {
                            response.getWriter().print("Ошибка добавления товара в корзину");
                        }
                    }
                } else {
                    response.getWriter().print("Товар не найден");
                }

                break;

            case "deleteCart":
                int cartId = Integer.parseInt(request.getParameter("id"));
                for (Cart cart : cartList) {
                    if (cart.getCartId() == cartId) {
                        cartService.deleteCart(cart);
                        response.getWriter().print("Товар удален");
                    }
                }
                break;
            case "newOrder":
                if (cartList.size() == 0) {
                    response.getWriter().print("Добавьте товары в корзину");
                } else if (user == null) {
                    response.getWriter().print("Для оформления заказа требуется авторизация!");
                } else {
                    int sum = 0;
                    for (Cart cart : cartList) {
                        sum += cart.getGood().getPrice() * cart.getCount();
                    }
                    Order order = new Order(user, sum);
                    orderService.saveOrder(order);
                    if (order.getOrderId() != 0) {
                        goodOrderService = new GoodOrderService();
                        for (Cart cart : cartList) {
                            GoodOrder goodOrder = new GoodOrder(order, cart.getGood(), cart.getCount());
                            goodOrderService.saveGoodOrder(goodOrder);
                            if (goodOrder.getGoodOrderId() != 0) {
                                cartService.deleteCart(cart);
                            } else {
                                response.getWriter().print("Ошибка оформления заказа");
                            }
                        }
                        response.getWriter().print("Оформлен заказ №" + order.getOrderId());
                    }
                }
                break;
        }
    }
}

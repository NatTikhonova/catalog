package com.example.demo.hibernate_dao;

import com.example.demo.models.Cart;
import com.example.demo.models.Good;
import com.example.demo.models.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CartService {
    private final CartDao cartDao = new CartDao();

    public Cart getCartById(int id) {
        return cartDao.getById(id);
    }

    public void saveCart(Cart Cart) {
        cartDao.save(Cart);
    }

    public void deleteCart(Cart Cart) {
        cartDao.delete(Cart);
    }

    public void updateCart(Cart Cart) {
        cartDao.update(Cart);
    }

    public List<Cart> getAllCarts() {
        return cartDao.getAll();
    }

    public List<Cart> getCartByUserId(User user) {
        return cartDao.getByCartId(user);
    }

    public List<Cart> getCartBySessionId(String sessionId) {
        return cartDao.getBySessionId(sessionId);
    }

    public Cart searchCart(Good good, String sessionId, User user) {
        return cartDao.searchCart(good, sessionId, user);
    }

    public int countCartByUser(User user) {
        List<Cart> list = getCartByUserId(user);
        int sum = 0;
        if (list != null) {
            for (Cart cart : list) {
                sum += cart.getCount();
            }
        }
        return sum;
    }

    public int countCartBySessionId(String sessionId) {
        List<Cart> list = getCartBySessionId(sessionId);
        int sum = 0;
        if (list != null) {
            for (Cart cart : list) {
                sum += cart.getCount();
            }
        }
        return sum;
    }

    public int countCart(List<Cart> list) {
        int sum = 0;
        if (list != null) {
            for (Cart cart : list) {
                sum += cart.getCount();
            }
        }
        return sum;
    }

    public void addUserToCart(HttpSession session, User user){
        List<Cart> cartList = getCartBySessionId(session.getId());
        if (cartList != null){
            for (Cart cart : cartList) {
                cart.setUser(user);
                updateCart(cart);
            }
        }
    }
}
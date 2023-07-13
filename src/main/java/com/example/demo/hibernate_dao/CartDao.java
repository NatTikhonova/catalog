package com.example.demo.hibernate_dao;

import com.example.demo.models.Cart;
import com.example.demo.models.Good;
import com.example.demo.models.User;
import org.hibernate.query.Query;

import java.util.List;

public class CartDao extends AbstractDao<Cart>{
    public CartDao() {
        super(Cart.class);
    }

    public Cart searchCart(Good good, String sessionId, User user) {
        Query<Cart> query;
        if (user == null){
            String hql = "from Cart WHERE good= :cartGoodId AND sessionId= :cartSessionId";
            query = getOpenSession().createQuery(hql, Cart.class);
            query.setParameter("cartGoodId",good);
            query.setParameter("cartSessionId",sessionId);
        } else {
            String hql = "from Cart WHERE good= :cartGoodId AND user= :cartUserId";
            query = getOpenSession().createQuery(hql, Cart.class);
            query.setParameter("cartGoodId", good);
            query.setParameter("cartUserId", user);
        }
        return query.uniqueResult();
    }

    public List<Cart> getByCartId(User user) {
        String hql = "from Cart WHERE user= :userId";
        Query<Cart> query = getOpenSession().createQuery(hql, Cart.class);
        query.setParameter("userId",user);
        return query.list();
    }
    public List<Cart> getBySessionId(String sessionId) {
        String hql = "from Cart WHERE sessionId= :sessionId";
        Query<Cart> query = getOpenSession().createQuery(hql, Cart.class);
        query.setParameter("sessionId",sessionId);
        return query.list();
    }
}
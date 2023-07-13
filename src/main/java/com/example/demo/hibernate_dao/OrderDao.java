package com.example.demo.hibernate_dao;

import com.example.demo.models.GoodOrder;
import com.example.demo.models.Order;
import com.example.demo.models.User;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDao extends AbstractDao<Order>{
    public OrderDao() {
        super(Order.class);
    }

    public GoodOrder getGoodOrderById(int id) {
        return getOpenSession().get(GoodOrder.class, id);
    }

    public List<Order> getOrderByUser(User user) {
        String hql = "from Order WHERE user= :user ORDER BY orderId desc";
        Query<Order> query = getOpenSession().createQuery(hql, Order.class);
        query.setParameter("user",user);
        return query.list();
    }
}
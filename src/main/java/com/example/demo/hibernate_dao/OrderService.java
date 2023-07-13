package com.example.demo.hibernate_dao;


import com.example.demo.models.GoodOrder;
import com.example.demo.models.Order;
import com.example.demo.models.User;

import java.util.List;

public class OrderService {
    private final OrderDao orderDao = new OrderDao();

    public Order getOrderById (int id){
        return orderDao.getById(id);
    }

    public void saveOrder(Order order) {
        orderDao.save(order);
    }

    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    public List<Order> getAllOrder() {
        return orderDao.getAll();
    }

    public GoodOrder getGoodOrderById(int id) {
        return orderDao.getGoodOrderById(id);
    }
    public List<Order> getOrderByUser(User user) {
        return orderDao.getOrderByUser(user);
    }
}

package com.example.demo.hibernate_dao;

import com.example.demo.models.GoodOrder;
import com.example.demo.models.Order;

import java.util.List;

public class GoodOrderService {
    private final GoodOrderDao goodOrderDao = new GoodOrderDao();

    public GoodOrder getGoodOrderById (int id){
        return goodOrderDao.getById(id);
    }

    public void saveGoodOrder(GoodOrder goodOrder) {
        goodOrderDao.save(goodOrder);
    }

    public void deleteGoodOrder(GoodOrder goodOrder) {
        goodOrderDao.delete(goodOrder);
    }

    public void updateGoodOrder(GoodOrder goodOrder) {
        goodOrderDao.update(goodOrder);
    }

    public List<GoodOrder> getAllGoodsOrder() {
        return goodOrderDao.getAll();
    }

    public List<GoodOrder> getGoodOrderByOrder(Order order) {
        return goodOrderDao.getGoodOrderByOrder(order);
    }
}

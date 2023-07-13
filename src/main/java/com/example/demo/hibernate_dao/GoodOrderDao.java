package com.example.demo.hibernate_dao;

import com.example.demo.models.GoodOrder;
import com.example.demo.models.Order;
import org.hibernate.query.Query;

import java.util.List;

public class GoodOrderDao extends AbstractDao<GoodOrder>{
    public GoodOrderDao() {
        super(GoodOrder.class);
    }

    public List<GoodOrder> getGoodOrderByOrder(Order order) {
        String hql = "from GoodOrder WHERE order= :order";
        Query<GoodOrder> query = getOpenSession().createQuery(hql, GoodOrder.class);
        query.setParameter("order",order);
        return query.list();
    }
}

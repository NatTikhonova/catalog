package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "goods_order")
public class GoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="good_order_id")
    private int goodOrderId;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="good_id", nullable = false)
    private Good good;

    @Column(name="count", nullable = false)
    private int count;

    public GoodOrder() {
    }

    public GoodOrder(Order order, Good good, int count) {
        this.order = order;
        this.good = good;
        this.count = count;
    }

    public int getGoodOrderId() {
        return goodOrderId;
    }

    public void setGoodOrderId(int goodOrderId) {
        this.goodOrderId = goodOrderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GoodOrder{" +
                "goodOrderId=" + goodOrderId +
                ", order=" + order +
                ", good=" + good +
                ", count=" + count +
                '}';
    }
}

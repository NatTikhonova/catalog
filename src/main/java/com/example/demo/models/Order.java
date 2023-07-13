package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="status", length = 120)
    private String status = "Новый";

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_creation")
    private Date dateСreation;

    @Column(name="total_order_value")
    private Integer price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodOrder> goods;

    public Order() {
    }

    public Order(User user, int price) {
        this.user = user;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateСreation() {
        return dateСreation;
    }

    public void setDateСreation(Date dateСreation) {
        this.dateСreation = dateСreation;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<GoodOrder> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodOrder> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", status=" + status +
                ", dateСreation=" + dateСreation +
                ", price=" + price +
                '}';
    }
}

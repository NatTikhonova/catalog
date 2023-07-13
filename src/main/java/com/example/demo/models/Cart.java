package com.example.demo.models;

import javax.persistence.*;
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "session_id", length = 120, nullable = false)
    private String sessionId;

    @ManyToOne
    @JoinColumn(name = "good_id", nullable = false)
    private Good good;

    @Column(name = "count", nullable = false)
    private int count;

    public Cart() {
    }

    public Cart(User user, String sessionId, Good good) {
        this.user = user;
        this.sessionId = sessionId;
        this.good = good;
        this.count = 1;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", sessionId='" + sessionId + '\'' +
                ", good=" + good +
                ", count=" + count +
                '}';
    }
}

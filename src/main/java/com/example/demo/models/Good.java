package com.example.demo.models;

import javax.persistence.*;
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private int goodId;
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Column(name = "info", nullable = false)
    private String info;
    @Column(name = "price", nullable = false, length = 20)
    private int price;
    @Column(name = "volume", nullable = false, length = 20)
    private int volume;
    @Column(name = "brand_name", nullable = false, length = 20)
    private String brandGoods;
    @Column(name = "type_product", nullable = false, length = 20)
    private String typeProduct;
    @Column(name = "gender", nullable = false, length = 120)
    private String gender;
    @Column(name = "good_img", nullable = false, length = 250)
    private String goodImg;

    public Good() {
    }

    public Good(String name, String info, int price, int volume, String brandGoods, String typeProduct, String gender, String goodImg) {
        this.name = name;
        this.info = info;
        this.volume = volume;
        this.price = price;
        this.brandGoods = brandGoods;
        this.typeProduct = typeProduct;
        this.gender = gender;
        this.goodImg = goodImg;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrandGoods() {
        return brandGoods;
    }

    public void setBrandName(String brandGoods) {
        this.brandGoods = brandGoods;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", brandGoods=" + brandGoods +
                ", typeProduct='" + typeProduct + '\'' +
                ", gender='" + gender + '\'' +
                ", goodImg='" + goodImg + '\'' +
                '}';
    }
}

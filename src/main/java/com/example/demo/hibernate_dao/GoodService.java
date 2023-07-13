package com.example.demo.hibernate_dao;

import com.example.demo.models.Good;

import java.util.List;

public class GoodService {
    private final GoodDao goodDao = new GoodDao();

    public Good getGoodById (int id){
        return goodDao.getById(id);
    }

    public void saveGood(Good good) {
        goodDao.save(good);
    }

    public void deleteGood(Good good) {
        goodDao.delete(good);
    }

    public void updateGood(Good good) {
        goodDao.update(good);
    }

    public List<Good> getAllGoods() {
        return goodDao.getAll();
    }

}
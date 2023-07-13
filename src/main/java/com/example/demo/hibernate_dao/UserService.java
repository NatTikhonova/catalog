package com.example.demo.hibernate_dao;

import com.example.demo.models.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public User getUserById (int id){
        return userDao.getById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getByEmail(String email){
        return userDao.getByEmail(email);
    }

    public User getByPhone(String phone){
        return userDao.getByPhone(phone);
    }

    public List<User> getByFio(String first, String last) {
        return userDao.getByFio(first,last);
    }
}

package com.example.demo.hibernate_dao;

import com.example.demo.models.User;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(User.class);
    }

    public User getByEmail(String email) {
        String hql = "from User WHERE email= :userEmail";
        Query<User> query = getOpenSession().createQuery(hql, User.class);
        query.setParameter("userEmail",email);
        return query.uniqueResult();
    }

    public User getByPhone(String phoneUser) {
        String hql = "from User WHERE phone= :userPhone";
        Query<User> query = getOpenSession().createQuery(hql, User.class);
        query.setParameter("userPhone",phoneUser);
        return query.uniqueResult();
    }

    public List<User> getByFio(String first, String last) {
        String hql = "from User WHERE firstName= :userFirstName and lastName= :userLastName";
        Query<User> query = getOpenSession().createQuery(hql, User.class);
        query.setParameter("userFirstName",first);
        query.setParameter("userLastName",last);
        return query.list();
    }
}

package com.Airbnb.app.DAO;

import com.Airbnb.app.jdbc.HibernatedbUtil;
import com.Airbnb.app.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public class UserDAOHibernate implements UserDAO{

    private SessionFactory sessionFactory = HibernatedbUtil.getSessionFactory();
    private User user = new User();

    private static final String getUserByLogin =
            "FROM User u WHERE u.email = ? AND u.password = ?";

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public User get(Integer id) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            user = session.get(User.class, id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        Session session = sessionFactory.openSession();
        boolean updated = false;

        try {
            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
            updated = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return updated;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = sessionFactory.openSession();
        boolean deleted = false;

        try {
            session.beginTransaction();

            user = session.load(User.class, id);
            session.delete(user);

            session.getTransaction().commit();
            deleted = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return deleted;
    }

    @Override
    public User getByLoginPassword(String login, String password) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            user = (User) session.createQuery(getUserByLogin).setString(0, login).setString(1, password).uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        List<User> userList = Collections.emptyList();

        try {
            session.beginTransaction();
            userList = session.createQuery("FROM user").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userList;
    }

    @Override
    public List<User> getAllClients() {
        return null;
    }

    @Override
    public List<User> getAllHosts() {
        return null;
    }
}

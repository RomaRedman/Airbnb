package com.Airbnb.app.DAO;

import com.Airbnb.app.jdbc.HibernatedbUtil;
import com.Airbnb.app.model.Apartment;
import org.hibernate.*;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;
/**
 * Created by romanroma on 10.10.15.
 */
public class ApartmentDAOHibernate implements ApartmentDAO {

    private SessionFactory sessionFactory = HibernatedbUtil.getSessionFactory();
    private Apartment apartment = new Apartment();

    @Override
    public void save(Apartment apartment) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.save(apartment);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Apartment get(Integer id) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            apartment = session.get(Apartment.class, id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return apartment;
    }

    @Override
    public boolean update(Apartment apartment) {
        Session session = sessionFactory.openSession();
        boolean updated = false;

        try {
            session.beginTransaction();

            session.update(apartment);

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

            apartment = session.load(Apartment.class, id);
            session.delete(apartment);

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
    public List<Apartment> getAll() {
        Session session = sessionFactory.openSession();
        List<Apartment> list = Collections.emptyList();

        try {
            session.beginTransaction();
            list = (List<Apartment>)session.createSQLQuery("SELECT * FROM Apartment").addEntity(Apartment.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    @Override
    public List<Apartment> getAllByCity(String city) {
        return null;
    }

    @Override
    public List<Apartment> getAllByUser(Integer id) {
        return null;
    }
}

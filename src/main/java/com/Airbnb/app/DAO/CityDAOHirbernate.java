package com.Airbnb.app.DAO;

import com.Airbnb.app.jdbc.HibernatedbUtil;
import com.Airbnb.app.model.City;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by romanroma on 19.11.15.
 */
public class CityDAOHirbernate implements CityDAO{

    private SessionFactory sessionFactory = HibernatedbUtil.getSessionFactory();
    private City city = new City();

    @Override
    public void save(City city) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.save(city);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public City get(Integer id) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            city = session.get(City.class, id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return city;
    }

    @Override
    public boolean update(City city) {
        Session session = sessionFactory.openSession();
        boolean updated = false;

        try {
            session.beginTransaction();

            session.update(city);

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

            city = session.load(City.class, id);
            session.delete(city);

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
    public List<City> getAll() {
        return null;
    }

    @Override
    public City getByName(String name) {
        return null;
    }
}

package com.Airbnb.app.DAO;

import com.Airbnb.app.jdbc.HibernatedbUtil;
import com.Airbnb.app.model.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public class ReservationDAOHibernate implements ReservationDAO {

    private SessionFactory sessionFactory = HibernatedbUtil.getSessionFactory();
    private Reservation reservation= new Reservation();

    private static final String getAllBetweenDatesQuery =
            "FROM Reservation R WHERE R.start >= ? AND R.end <= ?";

    @Override
    public void save(Reservation reservation) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.save(reservation);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Reservation get(Integer id) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            reservation = session.get(Reservation.class, id);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return reservation;
    }

    @Override
    public boolean update(Reservation reservation) {
        Session session = sessionFactory.openSession();
        boolean updated = false;

        try {
            session.beginTransaction();

            session.update(reservation);

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

            reservation = session.load(Reservation.class, id);
            session.delete(reservation);

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
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public List<Reservation> getAllByApartment(Integer apartmentId) {
        return null;
    }

    @Override
    public List<Reservation> getAllByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Reservation> getAllBetweenDates(Date start, Date end) {
        return null;
    }
}

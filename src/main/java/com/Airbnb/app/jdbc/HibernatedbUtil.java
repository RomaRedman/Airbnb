package com.Airbnb.app.jdbc;

import com.Airbnb.app.model.Apartment;
import com.Airbnb.app.model.City;
import com.Airbnb.app.model.Reservation;
import com.Airbnb.app.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by romanroma on 19.11.15.
 */
public class HibernatedbUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Apartment.class)
                    .addAnnotatedClass(Reservation.class);


            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

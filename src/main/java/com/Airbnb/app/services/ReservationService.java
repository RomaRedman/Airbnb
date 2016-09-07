package com.Airbnb.app.services;

import com.Airbnb.app.DAO.ApartmentDAO;
import com.Airbnb.app.DAO.ApartmentDAOHibernate;
import com.Airbnb.app.DAO.ReservationDAO;
import com.Airbnb.app.DAO.ReservationDAOHibernate;
import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;
import com.Airbnb.app.model.City;
import com.Airbnb.app.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 18.10.15.
 */
public class ReservationService {
    ApartmentDAO apartmentDAO = new ApartmentDAOHibernate();
    ReservationDAO reservationDAO = new ReservationDAOHibernate();

    public void save (User user, City city, ApartType apartType){

        Apartment apartment = new Apartment (user, city, apartType);
        createApartment(apartment);
    }

    public void createApartment (Apartment apartment){
        apartmentDAO.save(apartment);
    }

    public void deleteApartment (int id){
        apartmentDAO.delete(id);
    }

    public List<Apartment> getAllApartment (){
        return null;
    }

    public Apartment getApartmentById (int id){
        return null;
    }

    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo){

    }

    public List<Integer> searchPossibleApartment (String city, ApartType apartType, Date dateFrom, Date dateTo) {
        return null;
    }
}
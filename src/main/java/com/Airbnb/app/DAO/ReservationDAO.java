package com.Airbnb.app.DAO;

import com.Airbnb.app.model.Reservation;

import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 28.09.15.
 */
public interface ReservationDAO {
    /*public void makeReservation (int apartmentId, Date dateFrom, Date dateTo) throws SQLException;
    public List<Integer> searchPossibleApartment (String city, ApartType apartType,
                                                       Date dateFrom, Date dateTo) throws SQLException;*/
    public void save(Reservation reservation);
    public Reservation get(Integer id);
    public boolean update(Reservation reservation);
    public boolean delete(Integer id);
    public List<Reservation> getAll();
    public List<Reservation> getAllByApartment(Integer apartmentId);
    public List<Reservation> getAllByUser(Integer userId);
    public List<Reservation> getAllBetweenDates(Date start, Date end);
}

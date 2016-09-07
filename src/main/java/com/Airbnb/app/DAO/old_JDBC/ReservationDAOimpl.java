/*
package com.Airbnb.app.DAO.old_JDBC;

import com.Airbnb.app.DAO.ApartmentDAO;
import com.Airbnb.app.DAO.ApartmentDAOHibernate;
import com.Airbnb.app.DAO.ReservationDAO;
import com.Airbnb.app.jdbc.JDBCdbUtil;
import com.Airbnb.app.model.ApartType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

*/
/**
 * Created by romanroma on 19.11.15.
 *//*

public class ReservationDAOimpl implements ReservationDAO{
    ApartmentDAO apartmentDAO = new ApartmentDAOHibernate();
    private List<Integer> apartmentsList = new ArrayList<>();
    private java.sql.Date dateF;
    private java.sql.Date dateT;

    private String addReservationQuery = "INSERT INTO reservation (apartmentId, userId, dateFrom, dateTo) VALUES " +
            "( ?, (SELECT apartment.userId FROM apartment WHERE apartment.idApartment = ?), ?, ?)";
    private String getPossibleApartmentQuery = "SELECT ap.idApartment FROM apartment AS ap " +
            "LEFT JOIN reservation AS res ON ap.idApartment = res.apartmentId AND " +
            "(res.dateFrom > ? OR res.dateTo < ?) WHERE " +
            " cityId = ? AND apartmentTypeId = ?";

    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo) throws SQLException {
        dateF = new java.sql.Date(dateFrom.getTime());
        dateT = new java.sql.Date(dateTo.getTime());
        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(addReservationQuery);
            psttmnt.setInt (1, apartmentId);
            psttmnt.setInt (2, apartmentId);
            psttmnt.setDate(3, dateT);
            psttmnt.setDate(4, dateF);
            psttmnt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> searchPossibleApartment (String city, ApartType apartType, Date dateFrom, Date dateTo)
            throws SQLException {
        dateF = new java.sql.Date(dateFrom.getTime());
        dateT = new java.sql.Date(dateTo.getTime());
        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(getPossibleApartmentQuery);
            psttmnt.setDate(1, dateF);
            psttmnt.setDate(2, dateT);
            psttmnt.setInt(3, apartmentDAO.getCityId(city));
            psttmnt.setInt(4, apartmentDAO.getApartmentTypeId(apartType));

            ResultSet result = psttmnt.executeQuery();
            while (result.next()){
                apartmentsList.add(result.getInt(1));
            }
            return apartmentsList;
        }
    }
}
*/

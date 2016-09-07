package com.Airbnb.app.DAO;

import com.Airbnb.app.model.Apartment;
import java.util.List;
/**
 * Created by romanroma on 10.10.15.
 */
public interface ApartmentDAO {
    /*public void addApartment(Apartment apartment) throws SQLException;
    public void deleteApartment (int id) throws SQLException;
    public Apartment getApartmentById (int id) throws SQLException;
    public int checkUniqueCity (String city) throws SQLException;
    public int addUniqueCity (String city) throws SQLException;
    public int getCityId (String City) throws SQLException;
    public int getApartmentTypeId (ApartType apartmentType) throws SQLException;
    public List<Apartment> getAllApartment () throws SQLException;
    public int checkExistingApartment (int userId, String city, ApartType apartType) throws SQLException;*/
    public void save(Apartment apartment);
    public boolean delete(Integer id);
    public Apartment get(Integer id);
    public boolean update(Apartment apartment);
    public List<Apartment> getAll();
    public List<Apartment> getAllByCity(String city);
    public List<Apartment> getAllByUser(Integer id);
}

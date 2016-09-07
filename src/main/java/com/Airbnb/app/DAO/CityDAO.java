package com.Airbnb.app.DAO;

import com.Airbnb.app.model.City;

import java.util.List;

/**
 * Created by romanroma on 19.11.15.
 */
public interface CityDAO {
    public void save(City city);
    public City get(Integer id);
    public boolean update(City city);
    public boolean delete(Integer id);
    public List<City> getAll();
    public City getByName(String name);
}

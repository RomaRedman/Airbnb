package com.Airbnb.app.DAO;

import com.Airbnb.app.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public interface UserDAO {
    /*public void addUser (User user) throws SQLException;
    public void deleteUser (int id) throws SQLException;
    public User getUserById (int id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public List<User> getAllClients()throws SQLException;
    public List<User>getAllHosts() throws SQLException;
    public int checkExistingUser (String email) throws SQLException;
    public User getUserByLogin (String login, String password) throws SQLException;*/
    public void save(User user);
    public User get(Integer id);
    public boolean update(User user);
    public boolean delete(Integer id);
    public User getByLoginPassword(String login, String password);
    public List<User> getAllUsers();
    public List<User> getAllClients();
    public List<User> getAllHosts();

}

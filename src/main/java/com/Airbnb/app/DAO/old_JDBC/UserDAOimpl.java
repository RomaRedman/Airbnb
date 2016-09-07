/*
package com.Airbnb.app.DAO.old_JDBC;

import com.Airbnb.app.DAO.UserDAO;
import com.Airbnb.app.jdbc.JDBCdbUtil;
import com.Airbnb.app.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * Created by romanroma on 19.11.15.
 *//*

public class UserDAOimpl {
    private String addUserQuery = "INSERT INTO user (name, surname, email, isHost, password) VALUES (?, ?, ?, ?, ?)";
    private String deleteUserQuery = "DELETE FROM user WHERE idUser = ?";
    private String getUserbyIdQuery = "Select idUser, name, surname, email, isHost FROM user WHERE idUser = ?";
    private String getUsersQuery = "SELECT * FROM user";
    private String checkExistingUserQuery = "SELECT COUNT(*) FROM user WHERE email = ? ";
    private static final String getUserByLoginQuery =
            "SELECT * FROM user WHERE email = ? and password = ?";


    public void addUser(User user) throws SQLException {

        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(addUserQuery);
            psttmnt.setString(1, user.getName());
            psttmnt.setString(2, user.getSurname());
            psttmnt.setString(3, user.getEmail());
            psttmnt.setBoolean(4, user.isHost());
            psttmnt.setString(5, user.getPassword());
            psttmnt.executeUpdate();
        }
    }


    public void deleteUser(int id) throws SQLException{

        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(deleteUserQuery);
            psttmnt.setInt(1, id);
            psttmnt.executeUpdate();
        }
    }

    public int checkExistingUser (String email) throws SQLException {
        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(checkExistingUserQuery);
            psttmnt.setString(1, email);

            ResultSet result = psttmnt.executeQuery();
            result.next();
            return result.getInt(1);
        }
    }

    @Override
    public User getUserByLogin(String login, String password) throws SQLException {

        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(getUserByLoginQuery);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            result.next();

            User user = new User(result.getString(2),result.getString(3),result.getString(4),result.getBoolean(5),
                    result.getString(6));
            user.setId(result.getInt(1));

            return user;
        }
    }

    public User getUserById(int id) throws SQLException{

        try (Connection connection = JDBCdbUtil.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(getUserbyIdQuery);
            psttmnt.setInt(1, id);

            ResultSet result = psttmnt.executeQuery();
            result.next();

            User user = new User(result.getString(2),result.getString(3),result.getString(4),result.getBoolean(5),
                    result.getString(6));
            user.setId(result.getInt(1));

            return user;
        }
    }

    public List<User> getAllUsers() throws  SQLException{

        try(Connection connection = JDBCdbUtil.getConnection()){
            List<User> clientsList = new LinkedList<>();
            PreparedStatement psttmnt = connection.prepareStatement(getUsersQuery);

            ResultSet result = psttmnt.executeQuery();
            while (result.next()){
                User user = new User(result.getString(2),result.getString(3),result.getString(4),result.getBoolean(5),
                        result.getString(6));
                user.setId(result.getInt(1));
                clientsList.add(user);
            }
            return clientsList;
        }
    }

    public List<User> getAllClients() throws  SQLException{

        try(Connection connection = JDBCdbUtil.getConnection()){
            List<User> clientsList = new LinkedList<>();
            PreparedStatement psttmnt = connection.prepareStatement(getUsersQuery + " WHERE isHost = ?");
            psttmnt.setBoolean(1, false);

            ResultSet result = psttmnt.executeQuery();
            while (result.next()){
                User user = new User(result.getString(2),result.getString(3),result.getString(4),result.getBoolean(5),
                        result.getString(6));
                user.setId(result.getInt(1));
                clientsList.add(user);
            }
            return clientsList;
        }
    }

    public List<User> getAllHosts() throws SQLException{

        try(Connection connection = JDBCdbUtil.getConnection()){
            List<User> clientsList = new LinkedList<>();
            PreparedStatement psttmnt = connection.prepareStatement(getUsersQuery + " WHERE isHost = ?");
            psttmnt.setBoolean(1, true);

            ResultSet result = psttmnt.executeQuery();
            while (result.next()){
                User user = new User(result.getString(2),result.getString(3),result.getString(4),result.getBoolean(5),
                        result.getString(6));
                user.setId(result.getInt(1));
                clientsList.add(user);
            }
            return clientsList;
        }
    }
}
*/

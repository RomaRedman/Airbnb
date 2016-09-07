package com.Airbnb.app.services;

import com.Airbnb.app.DAO.UserDAO;
import com.Airbnb.app.DAO.UserDAOHibernate;
import com.Airbnb.app.model.User;

import java.util.List;

/**
 * Created by romanroma on 18.10.15.
 */
public class UserService {

    private UserDAO userDAO = new UserDAOHibernate();

    public void save (String login, String password, String email, String name, String surname, Boolean isHost){
        /*try {
            if (userDAO.checkExistingUser(email) == 1){
                System.out.println ("User : " + email + " is already exist");
                return;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }*/
        User user = new User (login, password, email, name, surname, isHost);
        save(user);
    }

    public void save (User user){
        /*if (!user.validation()){
            System.out.println ("User : " + user.getId() + "Fail validation");
            return;
        }*/

        userDAO.save(user);
    }

    public void delete (int id){
        userDAO.delete(id);
    }

    public List<User> getAllUsers (){
        return userDAO.getAllUsers();
    }

    public List<User> getAllClients (){
        return null;
    }

    public List<User> getAllHosts (){
        return null;
    }

    public User getUserById (int id){
        return userDAO.get(id);
    }

    /*public int checkExistingUser (String email){
        try {
            return userDAO.checkExistingUser(email);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }*/

    public User getUserByLogin (String login, String password){

        return userDAO.getByLoginPassword(login, password);
    }

}

package com.Airbnb.app;
import com.Airbnb.app.model.*;
import com.Airbnb.app.services.UserService;
import com.Airbnb.app.services.ReservationService;

import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 26.09.15.
 */

public class AirbnbController {

    //private static Logger logger = LogManager.getLogger(AirbnbController.class.getName());
    private UserService userService = new UserService();
    private ReservationService reservationService = new ReservationService();

    public void registerUser (String login, String password, String email, String name, String surname, Boolean isHost){
        userService.save(login, password, email, name, surname, isHost);
    }

    public void removeUser (int id){
        userService.delete(id);
    }

    public List getAllUsers(){
        return userService.getAllUsers();
    }

    public List getAllClients(){
        return userService.getAllClients();
    }

    public List getAllHosts(){
        return userService.getAllHosts();
    }

    public User getUserById (int id){
        return userService.getUserById(id);
    }

    public void createApartment (User user, City city, ApartType apartType){
        reservationService.save(user, city, apartType);
    }

    public void deleteApartment  (int id) {
        reservationService.deleteApartment(id);
    }

    public Apartment getApartmentById (int id) {
        return reservationService.getApartmentById(id);
    }

    public List<Apartment> getAllApartment (){
        return reservationService.getAllApartment();
    }

    public List<Integer> searchPossibleApartment (String city, ApartType apartType, Date dateFrom, Date dateTo) {
        return reservationService.searchPossibleApartment(city, apartType, dateFrom, dateTo);
    }

    public void makeReservation (int apartmentId, Date dateFrom, Date dateTo) {
        reservationService.makeReservation(apartmentId,dateFrom,dateTo);
    }

    public void notifyAll (String message){
        return;
    }

    public static void main( String[] args ) {

        AirbnbController airbnbController = new AirbnbController();

        // CLIENTS
        airbnbController.registerUser("Max", "12345","email@gmail.com", "Max", "Lol", false);
        /*airbnbController.registerUser("Roman","Iovenko","e.m.a.i.l2@gmail.com", false, "23408");
        airbnbController.registerUser("Vova", "New", "email3@gmail.com", false, "aaa00");
        airbnbController.registerUser("Sasha", "New-Prime", "email4@gmail.com", false, "er111");

        airbnbController.registerUser("Katya", "N-L-P", "email4@gmail.com", false, "tyy56");*/

        System.out.println("All users :");
        List<User> userList = airbnbController.getAllUsers();
        for (User user : userList){
            System.out.println(user);
        }

        /*System.out.println("All clients :");
        userList = airbnbController.getAllClients();
        for (User user : userList){
            System.out.println(user);
        }
*/
        /*System.out.println("Get user by id : " + airbnbController.getUserById(7));*/

        //airbnbController.removeUser(8);*/

        // HOSTS
        /*airbnbController.registerUser("Andrew", "Ubn-Al-Ka", "email5@gmail.com", true, "12345");
        airbnbController.registerUser("Ali","Kuku","email6@gmail.com", true, "54321");
        airbnbController.registerUser("Zlatan", "Ibragimovich", "email7@gmail.com", true, "56788");
        airbnbController.registerUser("Paveljr", "Sergeev", "email8@gmail.com",true, "09885");*/


        /*System.out.println("All hosts :");
        userList = airbnbController.getAllHosts();
        for (User user : userList){
            System.out.println(user);
        }*/

        //APARTMENTS
        /*airbnbController.createApartment(17, "Kyiv", ApartType.ROOM);
        airbnbController.createApartment(17, "Lviv", ApartType.PLACE);
        airbnbController.createApartment(19, "London", ApartType.APARTMENT);
        airbnbController.createApartment(20, "Kyiv", ApartType.PLACE);
        airbnbController.createApartment(17, "Madrid", ApartType.ROOM);

        //airbnbController.deleteApartment(7);

        System.out.println ("Get Aaprtment by id : " + airbnbController.getApartmentById(10));
*/
        /*System.out.println("All Apartment :");
        List<Apartment> apartmentList = airbnbController.getAllApartment();
        for (Apartment apartment : apartmentList){
            System.out.println(apartment + "  " + apartment.getHost() + "  " + apartment.getApartType());
        }*/

        // RESERVATION

        /*Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.NOVEMBER, 1);
        java.util.Date dateFrom = cal.getTime();
        Calendar calTo = Calendar.getInstance();
        calTo.set(2015, Calendar.NOVEMBER, 10);
        java.util.Date dateTo = calTo.getTime();

        //airbnbController.makeReservation(4, dateFrom, dateTo);

        List<Integer> arrayList = airbnbController.searchPossibleApartment
                ("Kyiv", ApartType.PLACE, dateFrom, dateTo);
        for (Integer temp : arrayList) {
            System.out.println ("Possible apartment id : " + temp);
        }*/
    }


}

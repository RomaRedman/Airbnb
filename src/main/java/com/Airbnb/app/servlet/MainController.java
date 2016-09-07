package com.Airbnb.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.Airbnb.app.model.Apartment;
import com.Airbnb.app.model.User;
import com.Airbnb.app.services.ReservationService;
import com.Airbnb.app.services.UserService;

/**
 * Created by romanroma on 01.11.15.
 */
public class MainController extends HttpServlet {

    private UserService userService = new UserService();
    private ReservationService reservationService = new ReservationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);

        if ("/logout".equals(path)) {
            session.invalidate();

            resp.sendRedirect("/login");
            return;
        }

        if ("/".equals(path)) {
            path = "/index";
        }

        if ("/getAllApartments".equals(path)) {

            List<Apartment> apartments = reservationService.getAllApartment();
            req.setAttribute("apartmentsList", apartments);
            req.setAttribute("cityList", apartments);
            path = "/allApartment";
        }

        String url = path + ".jsp";

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        String url = path + ".jsp";

        // Registration
        if ("/registration".equals(path)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String email = req.getParameter("email");


            User user = new User(login, password, email, name, surname, false);


            userService.save(user);

            resp.sendRedirect("login.jsp");

        }
        // Login
        if ("/login".equals(path)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            User user = userService.getUserByLogin(login, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect("/");
            } else {
                req.setAttribute("loginError", "Invalid login or password");

                req.getRequestDispatcher(url).forward(req, resp);
            }
        }

    }
}

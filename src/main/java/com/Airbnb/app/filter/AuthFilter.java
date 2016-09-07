package com.Airbnb.app.filter;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by romanroma on 07.11.15.
 */
public class AuthFilter implements Filter {

    public static final String LOGIN_URL = "/";
    public static final String REGISTRATION_URL = "/registration";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);

        if (session == null) {
            if (LOGIN_URL.equals(path) || REGISTRATION_URL.equals(path)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.sendRedirect("index.jsp");
            }
        } else {
            if (LOGIN_URL.equals(path) || REGISTRATION_URL.equals(path)) {
                resp.sendRedirect("/");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
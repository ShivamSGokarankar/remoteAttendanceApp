package com.attendanceapp.controller;

import com.attendanceapp.dao.UserDAO;
import com.attendanceapp.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/api/*"})
public class ControllerServlet extends HttpServlet {
    HttpSession httpSession;
    UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String path = request.getPathInfo();
        String RequestBody = request.getReader().lines().reduce("", String::concat);
        User user = new GsonBuilder().create().fromJson(RequestBody, User.class);

        switch (path) {
            case "/userlogin":
                validateUserLogin(request, response, user);
                break;
        }
    }

    private void validateUserLogin(HttpServletRequest request, HttpServletResponse response, User u) throws IOException {
        User user = userDAO.getUser(u.getUsername());
        Gson data = new GsonBuilder().setPrettyPrinting().create();
        String jsonData = data.toJson(user);
        response.getWriter().write(jsonData);

    }
}


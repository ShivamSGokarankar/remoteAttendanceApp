package com.attendanceapp.controller;

import com.attendanceapp.dao.UserDAO;
import com.attendanceapp.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns ={"/api/*"})
public class ControllerServlet extends HttpServlet
{
    HttpSession httpSession;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        final String path = request.getPathInfo();

        switch (path) {
            case  "/userlogin":
                validateUserLogin(request,response);
                break;
        }
    }


    private void validateUserLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        UserDAO userDAO= new UserDAO();
        User user = userDAO.getUser(request.getParameter("username"));
        response.getWriter().write(user.toString());

        Gson data= new GsonBuilder().setPrettyPrinting().create();
        String jsonData= data.toJson(user);
        response.getWriter().write(jsonData);

    }
}


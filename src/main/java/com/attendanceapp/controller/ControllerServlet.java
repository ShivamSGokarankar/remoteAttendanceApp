package com.attendanceapp.controller;

import com.attendanceapp.dao.UserDAO;
import com.attendanceapp.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logger.LogFileCreator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/api/*"})
public class ControllerServlet extends HttpServlet {
    HttpSession httpSession;
    UserDAO userDAO;
    LogFileCreator logFileCreator;

    public enum InfoMessage {
        User_Logged_In,
        User_Found,
        User_Not_Found,
        Invalid_Username_OR_Password,
        Request {
            public String toString() {
                return "Request JSON";
            }
        },
        Response {
            @Override
            public String toString() {
                return "Response JSON";
            }
        };
    }

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        try {
            logFileCreator = new LogFileCreator("D:\\Logs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String path = request.getPathInfo();

        String RequestBody = (request.getReader().lines().reduce("", String::concat)).replaceAll("\\s", "");
        logFileCreator.WriteLog(InfoMessage.Request.toString() + " : " + RequestBody);
        User user = new GsonBuilder().create().fromJson(RequestBody, User.class);

        switch (path) {
            case "/userlogin":
                validateUserLogin(request, response, user);
                break;
        }
    }

    private void validateUserLogin(HttpServletRequest request, HttpServletResponse response, User u) throws IOException {
        User user = userDAO.getUser(u.getUsername());
        if(user!=null)
        {
            Gson data = new GsonBuilder().setPrettyPrinting().create();
            String jsonData = data.toJson(user);
            logFileCreator.WriteLog(InfoMessage.Response.toString() + " : " + jsonData.replaceAll("\\n", " ").replaceAll("\\s", ""));
            response.getWriter().write(jsonData);
        }
        else
        {
            logFileCreator.WriteLog(InfoMessage.User_Not_Found.name());
            response.getWriter().write(InfoMessage.User_Not_Found.name());
        }
    }
}


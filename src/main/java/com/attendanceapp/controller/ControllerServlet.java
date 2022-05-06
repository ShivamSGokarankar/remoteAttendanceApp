package com.attendanceapp.controller;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void validateUserLogin(HttpServletRequest request, HttpServletResponse response, User u) throws IOException {

    }
}


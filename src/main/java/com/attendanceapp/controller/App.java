package com.attendanceapp.controller;

import com.attendanceapp.dao.UserDAO;
import com.attendanceapp.model.User;

public class App
{
    public static void main(String[] args)
    {
        User user1= new User();
        user1.setUser_id(101);
        user1.setUsername("shivam");
        user1.setPassword("smart@123");
        user1.setUser_status(1);
        user1.setIsLoggedIn(0);


    }
}

package com.attendanceapp.dao;

public class UserDAOFactory {
    public static UserDAO getInstance() {
        return new UserDAOImpl();
    }

}

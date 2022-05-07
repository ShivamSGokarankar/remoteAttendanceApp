package com.attendanceapp.DAO;

public class UserDAOFactory
{
    public static UserDAO getInstance()
    {
        return new UserDAOImpl();
    }


}

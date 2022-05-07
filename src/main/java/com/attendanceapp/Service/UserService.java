package com.attendanceapp.Service;

import com.attendanceapp.DAO.UserDAO;
import com.attendanceapp.DAO.UserDAOFactory;
import com.attendanceapp.DAO.UserDTO;
import com.attendanceapp.model.User;

import java.util.List;

public class UserService
{
    public static UserDAO userDAO = UserDAOFactory.getInstance();

    public void _insertUser(UserDTO userDTO)
    {

    }

    public List<User> _getUser(UserDTO userDTO)
    {
        return null;
    }


    public void _updateUser(UserDTO userDTO)
    {

    }

    public void _deleteUser(UserDTO userDTO)
    {

    }
}

package com.attendanceapp.Service;

import com.attendanceapp.DAO.UserDAO;
import com.attendanceapp.DAO.UserDAOFactory;
import com.attendanceapp.DAO.UserDTO;
import com.attendanceapp.model.User;
import jakarta.validation.constraints.Null;

import java.util.List;

public class UserService
{
    public static UserDAO userDAO = UserDAOFactory.getInstance();

    public boolean _insertUser(UserDTO userDTO)
    {
    return false;
    }

    public List<UserDTO> _getUsers()
    {
        return null;
    }


    public int _updateUser(UserDTO userDTO)
    {
        return 0;
    }

    public boolean _deleteUser(UserDTO userDTO)
    {
        return false;
    }

    public boolean getUser(UserDTO userDTO) throws NullPointerException
    {
        String username =userDTO.getUsername();
        String password = userDTO.getPassword();
        User user=UserDTO.ConvertToUser(userDTO);
        User fetchedUser=null;
        fetchedUser=userDAO.getUser(user);
        if(username.equals(fetchedUser.getUsername()) && password.equals(fetchedUser.getPassword()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

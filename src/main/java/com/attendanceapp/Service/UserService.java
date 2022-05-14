package com.attendanceapp.Service;

import com.attendanceapp.Util.InfoMessage;
import com.attendanceapp.dao.UserDAO;
import com.attendanceapp.dao.UserDAOFactory;
import com.attendanceapp.model.UserDTO;
import com.attendanceapp.model.User;
import com.logger.LogFileCreator;
import com.sun.source.tree.CatchTree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserService
{
    public static UserDAO userDAO = UserDAOFactory.getInstance();
    LogFileCreator l ;
    {
        try {
                l=new LogFileCreator("D:\\logs");
            }
            catch (IOException e) {
            e.printStackTrace();
        }

    }

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

    public UserDTO getUser(UserDTO userDTO) throws NullPointerException,NoClassDefFoundError,IllegalArgumentException {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        User user = UserDTO.ConvertToUser(userDTO);
        User fetchedUser = null;
        fetchedUser = userDAO.getUser(user);
        UserDTO fetchedUserDTO =null;
        if (fetchedUser != null)
        {
            fetchedUserDTO=fetchedUser.ConvertToUserDTO(fetchedUser);
            if (username.equals(fetchedUserDTO.getUsername()) && password.equals(fetchedUserDTO.getPassword()))
            {
                return fetchedUserDTO;
            }
            return null;

        }
        l.WriteLog(InfoMessage.User_Not_Found.name());
        return null;
    }


}

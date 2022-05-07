package com.attendanceapp.DAO;
import com.attendanceapp.model.User;

import java.util.List;

public interface UserDAO {

       public void createUser(User user);
       public List<User> getUser(User user);
       public void updateUser(User user);
       public void deleteUser(User user);


    }
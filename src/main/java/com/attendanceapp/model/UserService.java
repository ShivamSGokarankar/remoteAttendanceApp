package com.attendanceapp.model;

public interface UserService
{
    public void insertUser(User u );
    public  User getUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);


}

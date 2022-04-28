package com.attendanceapp.model;

public interface UserService
{
    public void insertUser(User u );
    public  User getUser(String username);
    public void updateUser(String username);
    public void deleteUser(String username);


}

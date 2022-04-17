package com.attendanceapp.model;

public interface UserService
{
    public void insertUser(User u );
    public  User getUserById(int userid);
    public void updateUser(int userid);
    public void deleteUser(int userid);


}

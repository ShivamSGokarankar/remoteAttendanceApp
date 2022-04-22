package com.attendanceapp.model;

public interface UserService
{
    public void insertUser(User u );
    public  User getUserById(long userid);
    public void updateUser(long userid);
    public void deleteUser(long userid);


}

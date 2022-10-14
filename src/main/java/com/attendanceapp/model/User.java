package com.attendanceapp.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.*;

@Entity
@Table(name = "Usermaster")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    private long user_id;
    @Id
    private String username;
    private String password;
    private int user_status = 1;
    private int isLoggedIn = 0;

    public User() {

    }

    public User(long user_id, String username, String password, int user_status, int isLoggedIn) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.user_status = user_status;
        this.isLoggedIn = isLoggedIn;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public int getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(int isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_status=" + user_status +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }

    public UserDTO ConvertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setUser_status(user.getUser_status());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setIsLoggedIn(user.getIsLoggedIn());
        return userDTO;
    }

    public List<UserDTO> ConvertToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (Iterator<User> u = userList.iterator(); u.hasNext();) {
            System.out.println(u.getClass().getName());
            userDTOList.add(ConvertToUserDTO(u.next()));
        }
        return userDTOList;
    }

}

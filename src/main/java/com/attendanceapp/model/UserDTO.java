package com.attendanceapp.model;

public class UserDTO {
    private long user_id;
    private String username;
    private String password;
    private int user_status;
    private int isLoggedIn;

    public UserDTO() {

    }

    public UserDTO(long user_id, String username, String password, int user_status, int isLoggedIn) {
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
        return "UserDTO{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_status=" + user_status +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }

    public static User ConvertToUser(UserDTO userDTO) {
        User user = new User();
        user.setUser_id(userDTO.getUser_id());
        user.setUser_status(userDTO.getUser_status());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setIsLoggedIn(userDTO.getIsLoggedIn());
        return user;

    }

}

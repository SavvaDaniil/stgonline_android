package com.example.stgonline.DTO.User;

public class UserProfileMicroEditDTO {

    private String username;
    private String passwordNew;
    private String passwordCurrent;

    public UserProfileMicroEditDTO(String username, String passwordNew, String passwordCurrent) {
        this.username = username;
        this.passwordNew = passwordNew;
        this.passwordCurrent = passwordCurrent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getPasswordCurrent() {
        return passwordCurrent;
    }

    public void setPasswordCurrent(String passwordCurrent) {
        this.passwordCurrent = passwordCurrent;
    }
}

package com.example.stgonline.DTO.User;

public class UserForgetDTO {

    private int step;
    private String username;
    private String code;
    private int forget_id;

    public UserForgetDTO(int step, String username) {
        this.step = step;
        this.username = username;
    }

    public UserForgetDTO(int step, String code, int forget_id) {
        this.step = step;
        this.code = code;
        this.forget_id = forget_id;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getForget_id() {
        return forget_id;
    }

    public void setForget_id(int forget_id) {
        this.forget_id = forget_id;
    }
}

package com.example.foodday.dto;

/**
 * ログイン用リクエストDTO
 */
public class LoginRequest {

    private String email;
    private String password;

    // getter / setter

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.example.foodday.dto;

/**
 * 登録リクエストDTO
 */

//登録処理するときに受け取るクラス
public class RegisterRequest {

    private String nickname;
    private String email;
    private String password;
    private String passwordConfirm;

    // --- getter / setter ---

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
package com.example.foodday.dto;

import lombok.Data;

//ログイン処理するときに受け取るクラス
@Data
public class LoginRequest {

    private String email;
    private String password;
}
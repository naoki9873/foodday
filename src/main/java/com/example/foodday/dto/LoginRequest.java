package com.example.foodday.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//ログイン処理するときに受け取るクラス
@Data
public class LoginRequest {
	
	@NotBlank(message = "ユーザー名は必須です")
    private String email;
	
	@NotBlank(message = "パスワードは必須です")
    private String password;
}
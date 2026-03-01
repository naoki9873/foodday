package com.example.foodday.service;

import org.springframework.stereotype.Service;

import com.example.foodday.dto.LoginRequest;
import com.example.foodday.entity.UserEntity;
import com.example.foodday.repository.UserRepository;

@Service
public class LoginService {
	
	private final UserRepository userRepository;

    // 必須依存のためコンストラクタインジェクション
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
 // ログイン処理
    public UserEntity login(LoginRequest request) {

        // ① 一致するメアドの情報を全て格納???????????????????
    	UserEntity user = userRepository.findByEmail(request.getEmail());

        // ② 一致していない時の処理
        if (user == null) {
            throw new RuntimeException("メールアドレスまたはパスワードが間違っています");
        }

        // ③ パスワード比較（※エンコードなし）
        if (!request.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("メールアドレスまたはパスワードが間違っています");
        }

        // ④ 認証成功
        return user;
    }
}
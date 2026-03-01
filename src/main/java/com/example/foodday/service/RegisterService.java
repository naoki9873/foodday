package com.example.foodday.service;

import org.springframework.stereotype.Service;

import com.example.foodday.dto.RegisterRequest;
import com.example.foodday.entity.User;
import com.example.foodday.repository.UserRepository;

@Service
public class RegisterService {

    private final UserRepository repository;

    public RegisterService(UserRepository repository) {
        this.repository = repository;
    }
    
    //DB登録メソッド
    public void registerTemporaryUser(RegisterRequest request) {
    	
        System.out.println("!!!!!！");

    	User user = new User();
        user.setNickname(request.getNickname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); 

        repository.save(user);

        System.out.println("DB保存完了！");
    }
}
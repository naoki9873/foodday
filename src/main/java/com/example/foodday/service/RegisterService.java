package com.example.foodday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodday.dto.RegisterRequest;
import com.example.foodday.entity.UserEntity;
import com.example.foodday.repository.UserRepository;

@Service
public class RegisterService {

	//インスタンス化
	@Autowired
	private UserRepository repository;

	// DB登録メソッド
	public void registerTemporaryUser(RegisterRequest request) {
		UserEntity user = new UserEntity();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		//DB登録
		repository.save(user);
	}

	

}
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

	// DB登録メソッド（処理だけ）
	public void registerTemporaryUser(RegisterRequest request) {
		UserEntity user = new UserEntity();
		user.setUsername(request.getUsername());
		user.setUserid(request.getUserid());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());

		repository.save(user);
	}

	// ユーザーIDが既に存在するかチェック
	public boolean isUseridTaken(String userid) {
		
		//ユーザーIDが存在した場合falseを返し、存在しない場合trueを返す
		return repository.findByUserid(userid) != null;
	}

}
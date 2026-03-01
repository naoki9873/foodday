package com.example.foodday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodday.dto.RegisterRequest;
import com.example.foodday.service.RegisterService;

//アカウント登録ですよー
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	//インスタンス化
	@Autowired
    private RegisterService registerService;

	@GetMapping
	public String showRegisterPage() {
		return "register";
	}

	// 登録ボタン押下、実行（DB登録処理）
	@PostMapping("/submit")
	public String register(RegisterRequest request) {//dtoから4つの情報を受け取る

		//DB登録メソッド
		registerService.registerTemporaryUser(request);
		return "redirect:/register";
	}
}
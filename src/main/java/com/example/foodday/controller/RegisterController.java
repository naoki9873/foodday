package com.example.foodday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodday.dto.RegisterRequest;
import com.example.foodday.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	//RegisterServiceインスタンス
	private final RegisterService registerService;
	//コンストラクタ
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@GetMapping
	public String showRegisterPage() {
		return "register";
	}

	// 登録ボタン押下、実行。DB登録処理
	@PostMapping("/submit")
	public String register(RegisterRequest request) {//dtoから4つの情報を受け取る

		//DB登録メソッド
		registerService.registerTemporaryUser(request);
		return "redirect:/register";
	}
}
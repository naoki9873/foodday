package com.example.foodday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodday.dto.LoginRequest;
import com.example.foodday.entity.UserEntity;
import com.example.foodday.service.LoginService;

import jakarta.servlet.http.HttpSession;


//ログイン処理
@Controller
@RequestMapping("/login")
public class LoginController {

	//インスタンス化
	@Autowired
	private LoginService loginService;
	
	//loginにアクセスした際に実行
	@GetMapping
	public String showLoginPage() {
		// login.htmlを表示
		return "login"; 
	}

	//ログインボタン押下後、処理する
	@PostMapping("/submit")
	public String login(@ModelAttribute LoginRequest request,HttpSession session) {

		// ログイン成功したユーザー取得
		UserEntity user = loginService.login(request);

		//
		session.setAttribute("loginUser", user);

		return "redirect:/mypage";
	}
}
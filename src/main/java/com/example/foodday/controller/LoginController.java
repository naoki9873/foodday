package com.example.foodday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodday.dto.LoginRequest;
import com.example.foodday.entity.User;
import com.example.foodday.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping
	public String showLoginPage() {
		return "login"; // login.htmlを表示
	}

	//ログインボタン押下後、処理する。ログイン処理。
	@PostMapping("/submit")
	public String login(@ModelAttribute LoginRequest request,
			HttpSession session) {

		// ログイン成功したユーザー取得
		User user = loginService.login(request);

		// ★ ここが超重要
		session.setAttribute("loginUser", user);

		return "redirect:/mypage";
	}
}
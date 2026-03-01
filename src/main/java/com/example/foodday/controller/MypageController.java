package com.example.foodday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.foodday.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class MypageController {

	@GetMapping("/mypage")
	public String showMypage(HttpSession session, Model model) {

		// セッションからログインユーザー取得
		UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

		// 未ログインならログイン画面へ
		if (loginUser == null) {
			return "redirect:/login";
		}

		// 画面へ渡す
		model.addAttribute("user", loginUser);

		return "mypage";
	}

}
package com.example.foodday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.foodday.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class MypageController {

	@GetMapping("/mypage")
	public String showMypage(HttpSession session, Model model) {

		// セッションからログインユーザー取得
		User loginUser = (User) session.getAttribute("loginUser");

		// 未ログインならログイン画面へ
		if (loginUser == null) {
			return "redirect:/login";
		}

		// 画面へ渡す
		model.addAttribute("user", loginUser);

		return "mypage";
	}

}
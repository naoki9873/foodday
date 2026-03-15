package com.example.foodday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.foodday.entity.UserEntity;
import com.example.foodday.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	//インスタンス化
	@Autowired
	private UserService userService;
	
	//マイページ初期画面
	@GetMapping
	public String showMypage(HttpSession session, Model model) {

		// セッションからログインユーザー取得
		UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

		// 未ログインならログイン画面へ
		if (loginUser == null) {
			return "redirect:/login";
		}

		// 画面へ渡す
		model.addAttribute("user", loginUser);
		//画面表示
		return "mypage";
	}
	
	//編集画面
	@GetMapping("/edit")
	public String edit(HttpSession session, Model model) {

		UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "redirect:/login";
		}

		model.addAttribute("user", loginUser);

		return "mypage_edit";
	}
	
	//保存ボタン押下
	@PostMapping("/update")
	public String update(
			@RequestParam String username,
			@RequestParam String bio,
			HttpSession session) {
		
		// エンティティにセット
		UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

		// UserService で更新
		UserEntity updatedUser = userService.updateProfile(loginUser.getId(), username, bio);

		// セッション更新
		session.setAttribute("loginUser", updatedUser);

		return "redirect:/mypage";
	}

}
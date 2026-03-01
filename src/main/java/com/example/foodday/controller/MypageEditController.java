package com.example.foodday.controller;

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
public class MypageEditController {

	private final UserService userService;

	public MypageEditController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/edit")
	public String edit(HttpSession session, Model model) {

		UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "redirect:/login";
		}

		model.addAttribute("user", loginUser);

		return "mypage_edit";
	}
	@PostMapping("/update")
	public String update(@RequestParam String nickname,
	                     @RequestParam String bio,
	                     HttpSession session) {

		UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

	    if (loginUser == null) {
	        return "redirect:/login";
	    }

	    // UserService で更新
	    UserEntity updatedUser = userService.updateProfile(loginUser.getId(), nickname, bio);

	    // セッションも更新
	    session.setAttribute("loginUser", updatedUser);

	    return "redirect:/mypage";
	}
}
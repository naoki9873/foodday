package com.example.foodday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodday.dto.RegisterRequest;
import com.example.foodday.service.RegisterService;

//アカウント登録
@Controller
@RequestMapping("/register")
public class RegisterController {

	//インスタンス化
	@Autowired
	private RegisterService registerService;

	//registerにアクセス後、実行
	@GetMapping
	public String showRegisterPage() {
		//登録画面返す
		return "register";
	}

	// 登録ボタン押下、実行（DB登録処理）
	@PostMapping("/submit")
	public String register(@ModelAttribute RegisterRequest request , Model model) {//dtoから4つの情報を受け取る
		
		// ユーザーID重複チェック
	    if (registerService.isUseridTaken(request.getUserid())) {
	    	//重複の場合エラーメッセージ
	        model.addAttribute("errorMessage", "そのユーザーIDはすでに使われています");
	        return "register";
	    }
		
		// パスワード一致しているか確認
		if (!request.getPassword().equals(request.getPasswordConfirm())) {
			//一致しない場合エラーメッセージ
	        model.addAttribute("errorMessage", "パスワードが一致しません");
	        return "register";
	    }
		
		//DB登録メソッド
		registerService.registerTemporaryUser(request);

		return "redirect:/register";
	}
}
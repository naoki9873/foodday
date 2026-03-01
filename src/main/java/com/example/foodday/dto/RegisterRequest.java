
package com.example.foodday.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

//登録処理するときに受け取るクラス
@Data
public class RegisterRequest {

	@NotBlank(message = "ニックネームは必須です")
	@Size(min = 1, max = 20, message = "ニックネームは1～20文字で入力してください")
	private String username; // ユーザー名（ニックネーム）

	@NotBlank(message = "ユーザーIDは必須です")
	@Size(min = 3, max = 50, message = "ユーザーIDは3～50文字で入力してください")
	private String userid; // ユーザーID

	@NotBlank(message = "メールアドレスは必須です")
	@Email(message = "メールアドレスの形式が不正です")
	@Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
	private String email;

	@NotBlank(message = "パスワードは必須です")
	@Size(min = 8, max = 60, message = "パスワードは8～60文字で入力してください")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]+$", 
    message = "パスワードは半角英数字で、数字と英字を含めてください")
	private String password;

	@NotBlank(message = "確認用パスワードは必須です")
	private String passwordConfirm;
}
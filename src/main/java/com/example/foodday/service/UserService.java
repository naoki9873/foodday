package com.example.foodday.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.foodday.entity.User;
import com.example.foodday.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 // ニックネーム＋自己紹介更新
    public User updateProfile(Long userId, String nickname, String bio) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new RuntimeException("ユーザーが存在しません");
        }

        User user = optionalUser.get();

        user.setNickname(nickname);
        user.setBio(bio);

        return userRepository.save(user);
    }
}
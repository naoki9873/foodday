package com.example.foodday.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.foodday.entity.Photo;
import com.example.foodday.entity.User;
import com.example.foodday.repository.PhotoRepository;
import com.example.foodday.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;


 // コンストラクタで両方注入
    public UserService(UserRepository userRepository, PhotoRepository photoRepository) {
        this.userRepository = userRepository;
        this.photoRepository = photoRepository;
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
    
    public User findById(Long userId) {
        User user = userRepository.findById(userId).orElse(null); // 一旦 null で取得
        if (user == null) {
            throw new RuntimeException("ユーザーが存在しません");
        }
        return user;
    }
    
    public void savePhoto(Long userId, String imageUrl, String comment) {
        Photo photo = new Photo();
        photo.setUserId(userId);
        photo.setImageUrl(imageUrl);
        photo.setComment(comment);
        photoRepository.save(photo);
    }

    public List<Photo> getUserPhotos(Long userId) {
        return photoRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
}
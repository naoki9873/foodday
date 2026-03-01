package com.example.foodday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.foodday.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    
    // nicknameで検索
    List<User> findByNicknameContaining(String keyword);

    // フォロー中ユーザー取得
    @Query("SELECT u FROM User u JOIN Follow f ON u.id = f.followee.id WHERE f.follower.id = :followerId")
    List<User> findFollowedUsers(Long followerId);
}
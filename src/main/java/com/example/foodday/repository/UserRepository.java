package com.example.foodday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.foodday.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
    
	// username で検索
	List<UserEntity> findByUsernameContaining(String keyword);
	
	//入力されたユーザーIDと一致したらそれを返し、ない場合はnullを返す
    UserEntity findByUserid(String userid); 

    // フォロー中ユーザー取得
    @Query("SELECT f.followee FROM Follow f WHERE f.follower.id = :followerId")
    List<UserEntity> findFollowedUsers(Long followerId);
}
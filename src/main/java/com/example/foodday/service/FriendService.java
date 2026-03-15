package com.example.foodday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.foodday.entity.Follow;
import com.example.foodday.entity.UserEntity;
import com.example.foodday.repository.FollowRepository;
import com.example.foodday.repository.UserRepository;

@Service
public class FriendService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private FollowRepository followRepository;


    // フォロー中ユーザー取得
    public List<UserEntity> findFollowedUsers(Long currentUserId) {
        return userRepository.findFollowedUsers(currentUserId);
    }

    // 検索
    public List<UserEntity> searchUsers(String keyword) {
        return userRepository.findByUsernameContaining(keyword);
    }

    // フォロー処理
    @Transactional
    public void followUser(Long currentUserId, Long followUserId) {
    	UserEntity follower = userRepository.findById(currentUserId).orElseThrow();
    	UserEntity followee = userRepository.findById(followUserId).orElseThrow();

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowee(followee);

        followRepository.save(follow);
    }
    
    public boolean isFollowing(Long currentUserId, Long followUserId) {
        return followRepository.existsByFollowerIdAndFolloweeId(currentUserId, followUserId);
    }

    public void unfollowUser(Long currentUserId, Long followUserId) {
        followRepository.deleteByFollowerIdAndFolloweeId(currentUserId, followUserId);
    }
}
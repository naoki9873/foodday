package com.example.foodday.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.foodday.entity.Follow;
import com.example.foodday.entity.User;
import com.example.foodday.repository.FollowRepository;
import com.example.foodday.repository.UserRepository;

@Service
public class FriendService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public FriendService(UserRepository userRepository, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
    }

    // フォロー中ユーザー取得
    public List<User> findFollowedUsers(Long currentUserId) {
        return userRepository.findFollowedUsers(currentUserId);
    }

    // 検索
    public List<User> searchUsers(String keyword) {
        return userRepository.findByNicknameContaining(keyword);
    }

    // フォローする
    @Transactional
    public void followUser(Long currentUserId, Long followUserId) {
        User follower = userRepository.findById(currentUserId).orElseThrow();
        User followee = userRepository.findById(followUserId).orElseThrow();

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowee(followee);

        followRepository.save(follow);
    }
}
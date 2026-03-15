package com.example.foodday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodday.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByFollowerIdAndFolloweeId(Long followerId, Long followeeId);

    void deleteByFollowerIdAndFolloweeId(Long followerId, Long followeeId);

}
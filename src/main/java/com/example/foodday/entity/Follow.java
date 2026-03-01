package com.example.foodday.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "followee_id")
    private UserEntity followee;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserEntity getFollower() { return follower; }
    public void setFollower(UserEntity follower) { this.follower = follower; }

    public UserEntity getFollowee() { return followee; }
    public void setFollowee(UserEntity followee) { this.followee = followee; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
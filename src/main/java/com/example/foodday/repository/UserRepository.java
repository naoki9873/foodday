package com.example.foodday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodday.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
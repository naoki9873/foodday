package com.example.foodday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodday.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByUserIdOrderByCreatedAtDesc(Long userId);
}
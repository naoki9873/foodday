package com.example.foodday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.foodday.entity.Photo;
import com.example.foodday.entity.UserEntity;
import com.example.foodday.service.FriendService;
import com.example.foodday.service.UserService;

@Controller
public class TimelineController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private UserService userService;

    @GetMapping("/timeline")
    public String showTimeline(Model model) {
        Long currentUserId = 1L;
        List<UserEntity> followedUsers = friendService.findFollowedUsers(currentUserId);
        List<Photo> photos = userService.getUserPhotos(currentUserId);

        model.addAttribute("followedUsers", followedUsers);
        model.addAttribute("photos", photos);
        return "timeline"; // 表示専用
    }
}
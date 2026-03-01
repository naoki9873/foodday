package com.example.foodday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.foodday.entity.User;
import com.example.foodday.service.FriendService;

@Controller
public class TimelineController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/timeline")
    public String showTimeline(Model model) {
        Long currentUserId = 1L; // 仮のログインユーザー
        List<User> followedUsers = friendService.findFollowedUsers(currentUserId);
        model.addAttribute("followedUsers", followedUsers);
        return "timeline";
    }
}
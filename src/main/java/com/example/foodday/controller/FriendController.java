package com.example.foodday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.foodday.entity.UserEntity;
import com.example.foodday.service.FriendService;
import com.example.foodday.service.UserService;

@Controller
public class FriendController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;

    // 個別ユーザー追加画面
    @GetMapping("/friends/add")
    public String addFriendPage(@RequestParam Long userId, Model model) {
    	UserEntity user = userService.findById(userId);
        model.addAttribute("friend", user);
        return "friend_add";
    }

    // 検索画面
    @GetMapping("/friends/search")
    public String searchUsers(@RequestParam(required = false) String keyword, Model model) {
        List<UserEntity> users;
        if (keyword != null && !keyword.isEmpty()) {
            users = friendService.searchUsers(keyword);
        } else {
            users = List.of();
        }
        model.addAttribute("users", users);
        return "friend_search";
    }

    // フォロー処理
    @PostMapping("/friends/follow")
    public String followUser(@RequestParam Long currentUserId, @RequestParam Long followUserId) {
        friendService.followUser(currentUserId, followUserId);
        return "redirect:/timeline";
    }
}
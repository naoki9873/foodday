package com.example.foodday.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.foodday.service.UserService;

@Controller
public class TimelinePhotoController {

    @Autowired
    private UserService userService;

    @PostMapping("/timeline/photo")
    public String uploadPhoto(@RequestParam String imageData,
                              @RequestParam String comment,
                              @RequestParam Long userId) throws IOException {

        String base64Image = imageData.split(",")[1];
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Image);

        Path uploadPath = Paths.get("uploads/");
        if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);

        String fileName = "photo_" + System.currentTimeMillis() + ".png";
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, decodedBytes);

        // DB に保存
        userService.savePhoto(userId, "/uploads/" + fileName, comment);

        return "redirect:/timeline";
    }
    @GetMapping("/timeline/capture")
    public String showCapturePage() {
        return "timeline_capture"; // カメラ起動・撮影画面
    }
}
package com.automaticaply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.automaticaply.entity.Resume;
import com.automaticaply.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService service;

    @PostMapping("/upload/{userId}")
    public Resume upload(@PathVariable Long userId,
                         @RequestParam("file") MultipartFile file) throws Exception {

        return service.uploadResume(userId, file);
    }
}
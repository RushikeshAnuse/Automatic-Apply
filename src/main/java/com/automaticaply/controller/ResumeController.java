package com.automaticaply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.automaticaply.entity.Resume;
import com.automaticaply.service.ResumeService;

//@RestController
//@RequestMapping("/api/resume")
@Controller
public class ResumeController {

    @Autowired
    private ResumeService service;

//    @PostMapping("/upload/{userId}")
//    public Resume upload(@PathVariable Long userId,
//                         @RequestParam("file") MultipartFile file) throws Exception {
//
//        return service.uploadResume(userId, file);
//    }
    
    @PostMapping("/upload-resume")
    public String uploadResume(
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        System.out.println("FILE RECEIVED");

        System.out.println(file.getOriginalFilename());

        redirectAttributes.addFlashAttribute(
                "message",
                "Resume Uploaded Successfully"
        );

        return "redirect:/upload-resume";
    }
    
   
    
    
}
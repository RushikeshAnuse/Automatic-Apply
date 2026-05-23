package com.automaticaply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.automaticaply.entity.Application;
import com.automaticaply.service.ApplicationService;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Apply Job
    @PostMapping("/apply-job")
    public String applyJob(
            @RequestParam Long jobId,
            RedirectAttributes redirectAttributes) {

        Long userId = 1L;

        String message =
                applicationService.applyJob(userId, jobId);

        redirectAttributes.addFlashAttribute(
                "message",
                message
        );

        return "redirect:/jobs";
    }

    // Applied Jobs Page
    @GetMapping("/applied-jobs")
    public String appliedJobs(Model model) {

        Long userId = 1L;

        List<Application> applications =
                applicationService.getApplications(userId);

        model.addAttribute(
                "applications",
                applications
        );

        return "applied-jobs";
    }
}
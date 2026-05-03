package com.automaticaply.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.automaticaply.service.MatchService;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService service;

    @GetMapping("/{userId}")
    public List<Map<String, Object>> match(@PathVariable Long userId) {
        return service.matchJobs(userId);
    }
}
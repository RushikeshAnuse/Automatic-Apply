package com.automaticaply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.automaticaply.entity.Job;
import com.automaticaply.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return service.addJob(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return service.getAllJobs();
    }
}
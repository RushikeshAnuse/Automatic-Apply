package com.automaticaply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automaticaply.entity.Job;
import com.automaticaply.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public Job addJob(Job job) {
        return repo.save(job);
    }

    public List<Job> getAllJobs() {
        return repo.findAll();
    }
}
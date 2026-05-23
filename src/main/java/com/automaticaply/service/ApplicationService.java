package com.automaticaply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automaticaply.entity.Application;
import com.automaticaply.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Apply Job
    public String applyJob(Long userId, Long jobId) {

        boolean alreadyApplied =
                applicationRepository
                .existsByUserIdAndJobId(userId, jobId);

        if(alreadyApplied) {

            return "Already Applied";
        }

        Application application = new Application();

        application.setUserId(userId);

        application.setJobId(jobId);

        application.setStatus("APPLIED");

        applicationRepository.save(application);

        return "Applied Successfully";
    }

    // Get Applied Jobs
    public List<Application> getApplications(Long userId) {

        return applicationRepository.findByUserId(userId);
    }
}
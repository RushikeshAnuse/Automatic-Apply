package com.automaticaply.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automaticaply.entity.Job;
import com.automaticaply.entity.Resume;
import com.automaticaply.repository.JobRepository;
import com.automaticaply.repository.ResumeRepository;

@Service
public class MatchService {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private ResumeRepository resumeRepo;

    public List<Map<String, Object>> matchJobs(Long userId) {

        Resume resume = resumeRepo.findAll()
                .stream()
                .filter(r -> r.getUserId().equals(userId))
                .reduce((first, second) -> second)
                .orElse(null);

        List<Job> jobs = jobRepo.findAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Job job : jobs) {

            int score = calculateMatch(resume.getSkills(), job.getSkillsRequired());

            Map<String, Object> map = new HashMap<>();
            map.put("job", job);
            map.put("score", score);

            result.add(map);
        }

        return result;
    }

    private int calculateMatch(String userSkills, String jobSkills) {

        List<String> user = Arrays.asList(userSkills.split(","));
        List<String> job = Arrays.asList(jobSkills.split(","));

        int match = 0;

        for (String skill : job) {
            if (user.contains(skill.trim())) {
                match++;
            }
        }

        return (match * 100) / job.size();
    }
}
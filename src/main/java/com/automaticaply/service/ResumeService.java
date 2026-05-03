package com.automaticaply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.automaticaply.entity.Resume;
import com.automaticaply.repository.ResumeRepository;
import com.automaticaply.util.ResumeParser;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repo;

    public Resume uploadResume(Long userId, MultipartFile file) throws Exception {

        String content = new String(file.getBytes());
        String skills = ResumeParser.extractSkills(content);

        Resume resume = new Resume();
        resume.setUserId(userId);
        resume.setFileName(file.getOriginalFilename());
        resume.setSkills(skills);

        return repo.save(resume);
    }
}
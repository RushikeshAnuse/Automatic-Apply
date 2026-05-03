package com.automaticaply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.automaticaply.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
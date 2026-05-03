package com.automaticaply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.automaticaply.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
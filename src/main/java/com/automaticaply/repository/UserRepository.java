package com.automaticaply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.automaticaply.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

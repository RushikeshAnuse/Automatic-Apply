package com.automaticaply.entity;

import jakarta.persistence.*;

@Entity
public class Resume {

    @Override
	public String toString() {
		return "Resume [id=" + id + ", userId=" + userId + ", fileName=" + fileName + ", skills=" + skills + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String fileName;
    private String skills;
    
 // getters and setters
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

    
    
    
}

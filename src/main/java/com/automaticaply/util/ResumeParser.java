package com.automaticaply.util;

import java.util.Arrays;
import java.util.List;

public class ResumeParser {

    public static String extractSkills(String text) {

        List<String> skills = Arrays.asList(
            "Java", "Spring Boot", "Hibernate", "MySQL", "REST", "Angular"
            ,"JDBC","Data Structures","Git","C#"
        );

        StringBuilder result = new StringBuilder();

        for (String skill : skills) {
            if (text.toLowerCase().contains(skill.toLowerCase())) {
                result.append(skill).append(",");
            }
        }

        return result.toString();
    }
}
package com.rohit.student_service.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String email;
    private String rollNo;
    private String name;
    private String department;
    private Integer graduationYear;
    private String phone;
    private String status;
    private String resumeFilename;
    private String resumeContentType;
    private String resumeStoragePath;
}

package com.rohit.placement_service.dto;

import lombok.Data;

@Data
public class StudentDto {
        private Long id;
        private String name;
        private String email;
        private String rollNo;
        private String department;
        private Integer graduationYear;
        private String status;
}

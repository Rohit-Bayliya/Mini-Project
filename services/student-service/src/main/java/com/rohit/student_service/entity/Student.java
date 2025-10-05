package com.rohit.student_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@Data                       // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor          // no-args constructor
@AllArgsConstructor         // all-args constructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String rollNo;

    @NotBlank
    private String name;

    @NotBlank
    private String department;

    @NotNull
    private Integer graduationYear;

    private String phone;

    @Builder.Default
    private String status = "ACTIVE";

    // Resume fields
    private String resumeFilename;
    private String resumeContentType;
    private String resumeStoragePath;
    private LocalDateTime resumeUploadedAt;
}
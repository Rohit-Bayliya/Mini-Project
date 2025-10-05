package com.rohit.student_service.controller;


import com.rohit.student_service.entity.Student;
import com.rohit.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Admin: Create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    // Admin/Student: Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Admin: Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Admin: Update student details
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    // Student: Upload/Update Resume
    @PostMapping("/{id}/resume")
    public ResponseEntity<Student> uploadResume(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        // store locally (later can integrate with S3/minio)
        String storagePath = "uploads/" + file.getOriginalFilename();
        File dest = new File(storagePath);
        file.transferTo(dest);

        Student updated = studentService.updateResume(id, file.getOriginalFilename(), file.getContentType(), storagePath);
        return ResponseEntity.ok(updated);
    }

    // Admin: Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

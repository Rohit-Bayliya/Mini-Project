package com.rohit.student_service.service;

import com.rohit.student_service.dto.StudentDto;
import com.rohit.student_service.entity.Student;
import com.rohit.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);
        existing.setName(updated.getName());
        existing.setDepartment(updated.getDepartment());
        existing.setGraduationYear(updated.getGraduationYear());
        existing.setPhone(updated.getPhone());
        existing.setStatus(updated.getStatus());
        return studentRepository.save(existing);
    }

    public Student updateResume(Long id, String filename, String contentType, String storagePath) {
        Student student = getStudentById(id);
        student.setResumeFilename(filename);
        student.setResumeContentType(contentType);
        student.setResumeStoragePath(storagePath);
        student.setResumeUploadedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
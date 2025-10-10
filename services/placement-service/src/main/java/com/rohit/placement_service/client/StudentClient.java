package com.rohit.placement_service.client;

import com.rohit.placement_service.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/students/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);
}

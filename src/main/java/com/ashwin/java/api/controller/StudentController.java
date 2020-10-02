package com.ashwin.java.api.controller;

import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;
import com.ashwin.java.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Student> student(@PathVariable(value = "id") Long id) {
        Student student = studentService.get(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}

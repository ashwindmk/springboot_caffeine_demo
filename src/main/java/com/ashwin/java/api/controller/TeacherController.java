package com.ashwin.java.api.controller;

import com.ashwin.java.domain.model.Teacher;
import com.ashwin.java.domain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Teacher> teacher(@PathVariable(value = "id") Long id) {
        Teacher teacher = teacherService.get(id);
        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacher);
    }
}

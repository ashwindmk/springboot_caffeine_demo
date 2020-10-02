package com.ashwin.java.domain.service;

import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public Student get(Long id) {
        return studentRepository.get(id);
    }

    public void update(Student student) {

    }
}

package com.ashwin.java.domain.service;

import com.ashwin.java.domain.model.Teacher;
import com.ashwin.java.domain.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher get(Long id) {
        return teacherRepository.get(id);
    }
}

package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.Student;
import org.springframework.stereotype.Repository;

public interface StudentRepository {
    public Student get(long id);

    public void update(Student student);
}

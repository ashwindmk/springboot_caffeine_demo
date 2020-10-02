package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.TeacherSource;
import com.ashwin.java.domain.model.Teacher;
import com.ashwin.java.domain.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
    @Autowired
    private TeacherSource teacherSource;

    @Override
    public Teacher get(long id) {
        return null;
    }
}

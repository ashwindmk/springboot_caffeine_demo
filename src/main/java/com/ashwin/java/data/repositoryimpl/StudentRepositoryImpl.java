package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Repository
@CacheConfig(cacheNames = {"StudentCache"})
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    StudentSource studentSource;

    @Override
    @Cacheable(unless = "#result == null")
    public Student get(long id) {
        return studentSource.get(id);
    }

    @Override
    @CacheEvict(key = "#student.id")
    public void update(Student student) {
        // TODO
    }
}

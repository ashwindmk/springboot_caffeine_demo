package com.ashwin.java.data.source;

import com.ashwin.java.domain.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentSource {
    private List<Student> students;

    public StudentSource() {
        students = new ArrayList<>();
        students.add(new Student(1L, "Alice Williams"));
        students.add(new Student(2L, "Bob Martin"));
        students.add(new Student(3L, "Clara Nelson"));
        students.add(new Student(4L, "Daniel Jackson"));
        students.add(new Student(5L, "Eric Rodriques"));
        students.add(new Student(6L, "Fruty Fernandes"));
        students.add(new Student(7L, "Gijina Mathews"));
    }

    public Student get(long id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

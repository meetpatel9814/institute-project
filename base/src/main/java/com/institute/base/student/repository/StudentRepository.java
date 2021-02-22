package com.institute.base.student.repository;

import com.institute.base.student.entity.Student;

import java.util.Arrays;
import java.util.List;

public interface StudentRepository {
    List<Student> findStudentsByClassName(String className);

    Student saveStudent(Student student);
}

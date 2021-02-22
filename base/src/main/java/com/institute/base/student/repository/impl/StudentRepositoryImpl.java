package com.institute.base.student.repository.impl;

import com.institute.base.student.dao.StudentDao;
import com.institute.base.student.entity.Student;
import com.institute.base.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private StudentDao studentDao;

    @Autowired
    public StudentRepositoryImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public List<Student> findStudentsByClassName(@NotNull String className) {
        return studentDao.findStudentsByClassName(className);
    }

    @Override
    public Student saveStudent(@NotNull Student student) {
        return studentDao.save(student);
    }
}

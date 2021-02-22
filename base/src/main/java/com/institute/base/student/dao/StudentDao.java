package com.institute.base.student.dao;

import com.institute.base.framwork.dao.BaseDao;
import com.institute.base.student.entity.Student;

import java.util.List;

public interface StudentDao extends BaseDao<Student, Long> {

    List<Student> findStudentsByClassName(String className);
}

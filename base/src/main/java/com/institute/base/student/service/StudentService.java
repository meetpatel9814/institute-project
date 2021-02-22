package com.institute.base.student.service;

import com.institute.base.student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getStudentsByClassName(String className);

    StudentDto saveStudent(StudentDto studentDto);
}

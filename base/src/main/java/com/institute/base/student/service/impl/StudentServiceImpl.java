package com.institute.base.student.service.impl;

import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.framwork.exception.BusinessException;
import com.institute.base.student.dto.StudentDto;
import com.institute.base.student.entity.Student;
import com.institute.base.student.enums.StudentResultCode;
import com.institute.base.student.repository.StudentRepository;
import com.institute.base.student.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getStudentsByClassName(@Nullable String className) {
        if(StringUtils.hasText(className)) {
            return studentRepository.findStudentsByClassName(className).stream()
                    .map(student -> {
                        StudentDto studentDto = mapper.map(student, StudentDto.class);
                        studentDto.setStudentClassId(student.getStudentClassMapper().getId());
                        studentDto.setClassDetail(mapper.map(student.getStudentClassMapper().getClassDetail(), ClassDetailDto.class));
                        return studentDto;

                    }).collect(Collectors.toList());
        } else {
            throw new BusinessException(StudentResultCode.CLASS_NAME_REQUIRED);
        }

    }

    @Override
    public StudentDto saveStudent(@Nullable StudentDto studentDto) {
        if (studentDto != null) {
            Student student = mapper.map(studentDto, Student.class);
            student = studentRepository.saveStudent(student);
            return mapper.map(student, StudentDto.class);
        }
        return studentDto;
    }
}

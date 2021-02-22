package com.institute.base.student.controller;

import com.institute.base.framwork.controller.BaseController;
import com.institute.base.framwork.dto.ResponseDto;
import com.institute.base.student.dto.StudentDto;
import com.institute.base.student.enums.StudentResultCode;
import com.institute.base.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController extends BaseController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseDto<List<StudentDto>> getStudentsByClassName(@RequestParam String className) {
        return super.wrapperContent(StudentResultCode.INTERNAL_SERVER_ERROR, () -> studentService.getStudentsByClassName(className));
    }

    @PostMapping("/save")
    public ResponseDto<StudentDto> saveStudent(@RequestBody @Valid StudentDto studentDto, BindingResult bindingResult) {
        return super.wrapperContentWithValidation(bindingResult, StudentResultCode.ERROR_ON_SAVE_STUDENT,
                StudentResultCode.STUDENT_SAVED_SUCCESS, () -> studentService.saveStudent(studentDto));
    }
}

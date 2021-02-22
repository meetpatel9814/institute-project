package com.institute.base.classdetail.controller;

import com.institute.base.classdetail.ClassDetailsCode;
import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.classdetail.service.ClassDetailService;
import com.institute.base.framwork.controller.BaseController;
import com.institute.base.framwork.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassDetailController extends BaseController {

    private ClassDetailService classDetailService;

    @Autowired
    public ClassDetailController(ClassDetailService classDetailService) {
        this.classDetailService = classDetailService;
    }

    @GetMapping
    public List<ClassDetailDto> getAllClassDetails() {
        return classDetailService.getAllClassDetails();
    }

    @PostMapping("/save")
    public ResponseDto<ClassDetailDto> saveClassDetail(@RequestBody @Valid ClassDetailDto classDetailDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return null;
        } else {
            return super.wrapperContent(ClassDetailsCode.INTERNAL_SERVER_EXCEPTION, ClassDetailsCode.CLASS_SAVE_SUCCESSFULLY,
                () -> classDetailService.saveClassDetail(classDetailDto));
        }

    }
}

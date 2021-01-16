package com.institute.base.classdetail.service;

import com.institute.base.classdetail.dto.ClassDetailDto;

import java.util.List;

public interface ClassDetailService {


  List<ClassDetailDto> getAllClassDetails();

  ClassDetailDto saveClassDetail(ClassDetailDto classDetailDto);
}

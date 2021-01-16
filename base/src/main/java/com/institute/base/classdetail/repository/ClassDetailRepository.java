package com.institute.base.classdetail.repository;

import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.classdetail.entity.ClassDetail;

import java.util.List;

public interface ClassDetailRepository {

  List<ClassDetail> getAllClassDetails();


  ClassDetail saveClassDetail(ClassDetail classDetail);
}

package com.institute.base.classdetail.service.impl;

import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.classdetail.entity.ClassDetail;
import com.institute.base.classdetail.repository.ClassDetailRepository;
import com.institute.base.classdetail.service.ClassDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassDetailServiceImpl implements ClassDetailService {

  @Autowired
  private ClassDetailRepository classDetailRepository;

  @Autowired
  private ModelMapper mapper;

  @Override public List<ClassDetailDto> getAllClassDetails() {
    return classDetailRepository.getAllClassDetails().stream()
        .map(school ->
        {
          return mapper.map(school, ClassDetailDto.class);
        }).collect(Collectors.toList());
  }

  @Override public ClassDetailDto saveClassDetail(ClassDetailDto classDetailDto) {
    ClassDetail classDetail = mapper.map(classDetailDto, ClassDetail.class);
    classDetail.setClassName();
    ClassDetail classDetail1 = classDetailRepository.saveClassDetail(classDetail);
    return mapper.map(classDetail1, ClassDetailDto.class);
  }
}

package com.institute.base.classdetail.repository.impl;

import com.institute.base.classdetail.dao.ClassDetailDao;
import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.classdetail.entity.ClassDetail;
import com.institute.base.classdetail.repository.ClassDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDetailRepositoryImpl implements ClassDetailRepository {

  @Autowired
  private ClassDetailDao classDetailDao;


  @Override
  public List<ClassDetail> getAllClassDetails() {
    return classDetailDao.findAll();
  }

  @Override public ClassDetail saveClassDetail(ClassDetail classDetail) {
    return classDetailDao.save(classDetail);
  }
}

package com.institute.base.classdetail.dao.impl;

import com.institute.base.classdetail.dao.ClassDetailDao;
import com.institute.base.classdetail.entity.ClassDetail;
import com.institute.base.framwork.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class ClassDetailDaoImpl extends BaseDaoImpl<ClassDetail, Long> implements ClassDetailDao {
  public ClassDetailDaoImpl() {
    super(ClassDetail.class);
  }
}

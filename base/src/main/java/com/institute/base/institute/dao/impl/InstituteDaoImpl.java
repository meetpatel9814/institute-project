package com.institute.base.institute.dao.impl;

import com.institute.base.framwork.dao.impl.BaseDaoImpl;
import com.institute.base.institute.dao.InstituteDao;
import com.institute.base.institute.entity.Institute;
import org.springframework.stereotype.Service;

@Service
public class InstituteDaoImpl extends BaseDaoImpl<Institute, Long> implements InstituteDao {
  public InstituteDaoImpl() {
    super(Institute.class);
  }
}

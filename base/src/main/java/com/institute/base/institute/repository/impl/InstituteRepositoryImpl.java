package com.institute.base.institute.repository.impl;

import com.institute.base.institute.dao.InstituteDao;
import com.institute.base.institute.entity.Institute;
import com.institute.base.institute.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstituteRepositoryImpl implements InstituteRepository {

  @Autowired
  private InstituteDao instituteDao;


  @Override
  public List<Institute> getAllInstituteDetails() {
    return instituteDao.findAll();
  }
}

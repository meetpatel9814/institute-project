package com.institute.base.institute.service.impl;

import com.institute.base.framwork.enums.BaseResultCode;
import com.institute.base.framwork.exception.BusinessException;
import com.institute.base.institute.dto.InstituteDto;
import com.institute.base.institute.repository.InstituteRepository;
import com.institute.base.institute.service.InstituteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstituteServiceImpl implements InstituteService {

  @Autowired
  private InstituteRepository instituteRepository;

  @Autowired
  private ModelMapper mapper;

  @Override public List<InstituteDto> getAllInstituteDetails() {


    return instituteRepository.getAllInstituteDetails().stream()
        .map(school -> mapper.map(school, InstituteDto.class)).collect(Collectors.toList());
  }
}

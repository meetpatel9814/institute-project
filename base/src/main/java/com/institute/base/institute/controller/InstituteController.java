package com.institute.base.institute.controller;

import com.institute.base.framwork.controller.BaseController;
import com.institute.base.framwork.dto.ResponseDto;
import com.institute.base.framwork.enums.BaseResultCode;
import com.institute.base.institute.dto.InstituteDto;
import com.institute.base.institute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/institute")
public class InstituteController extends BaseController {

  @Autowired
  private InstituteService instituteService;

  @GetMapping
  public ResponseDto<List<InstituteDto>> getAllSchoolDetails() {
    return super.wrapperContent(BaseResultCode.INTERNAL_SERVER_EXCEPTION, instituteService::getAllInstituteDetails);
  }
}

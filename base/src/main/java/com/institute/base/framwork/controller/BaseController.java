package com.institute.base.framwork.controller;

import com.institute.base.framwork.dto.ResponseDto;
import com.institute.base.framwork.enums.ResponseMessageType;
import com.institute.base.framwork.enums.ResultCode;
import com.institute.base.framwork.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api")
public class BaseController {


  protected <T> ResponseDto<T> wrapperContent(ResultCode resultCode, Supplier<T> consumer) {
    try {
      ResponseDto<T> responseDto = new ResponseDto<>();
      responseDto.setContent(consumer.get());
      responseDto.setStatus(HttpStatus.OK.value());
      responseDto.setResponseMessage(ResponseMessageType.SUCCESS);
      return responseDto;
    } catch (Exception e) {
      throw new BaseException(resultCode);
    }
  }

}

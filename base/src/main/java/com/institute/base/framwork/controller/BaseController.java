package com.institute.base.framwork.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.institute.base.framwork.dto.ResponseDto;
import com.institute.base.framwork.enums.BaseResultCode;
import com.institute.base.framwork.enums.ResponseMessageType;
import com.institute.base.framwork.enums.ResultCode;
import com.institute.base.framwork.exception.BaseException;
import com.institute.base.framwork.exception.BusinessException;
import com.institute.base.framwork.exception.ExceptionConstant;
import com.institute.base.framwork.validation.ValidationCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api")
public abstract class BaseController {
  @Autowired
  private ObjectMapper objectMapper;

  private static Logger logger = LogManager.getLogger();
  protected <T> ResponseDto<T> wrapperContent(ResultCode errorResultCode, Supplier<T> consumer) {
    try {
      ResponseDto<T> responseDto = new ResponseDto<>();
      responseDto.setContent(consumer.get());
      responseDto.setStatus(HttpStatus.OK.value());
      responseDto.setResponseMessage(ResponseMessageType.SUCCESS);
      return responseDto;
    } catch (Exception e) {
      logger.error(ExceptionConstant.EXCEPTION_MSG, e);
      throw new BaseException(errorResultCode);
    }
  }

  protected <T> ResponseDto<T> wrapperContentWithValidation(BindingResult bindingResult, ResultCode errorResultCode, ResultCode successResultCode, Supplier<T> consumer) {

    if(bindingResult.hasErrors()) {
      logger.error("Dto Validation class =" + bindingResult.getTarget() + "." + bindingResult.getTarget().getClass());
      Class<?> targetDtoClass = bindingResult.getTarget().getClass();
      try {
        Field field = targetDtoClass.getDeclaredField(bindingResult.getFieldErrors().get(0).getField());
        ValidationCode validationCode = field.getAnnotation(ValidationCode.class);
        throw new BusinessException(validationCode.value());
      } catch (NoSuchFieldException e) {
        logger.error(ExceptionConstant.EXCEPTION_MSG, e);
        throw new BaseException(BaseResultCode.INTERNAL_SERVER_EXCEPTION);
      } catch (BusinessException e) {
        logger.error(e.getMessage(), e);
        throw e;
      }
    }
    return this.wrapperContent(errorResultCode, successResultCode, consumer);
  }

  protected <T> ResponseDto<T> wrapperContent(ResultCode errorResultCode,ResultCode successResultCode, Supplier<T> consumer) {
    try {
      ResponseDto<T> responseDto = new ResponseDto<>();
      responseDto.setContent(consumer.get());
      responseDto.setStatus(HttpStatus.OK.value());
      responseDto.setResponseMessage(ResponseMessageType.SUCCESS);
      responseDto.setMessage(successResultCode.getMessage());
      responseDto.setCode(successResultCode.getResultCode());
      return responseDto;
    } catch (Exception e) {
      logger.error(ExceptionConstant.EXCEPTION_MSG, e);
      throw new BaseException(errorResultCode);
    }
  }

  protected <T> T convertToPojo(String json, Class<T> tClass) {
    try {
      return objectMapper.readValue(json, tClass);
    } catch (JsonProcessingException e) {
      logger.error(ExceptionConstant.EXCEPTION_MSG, e);
      throw new BaseException(BaseResultCode.INTERNAL_SERVER_EXCEPTION);
    }
  }
}

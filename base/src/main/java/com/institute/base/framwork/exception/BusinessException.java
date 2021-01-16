package com.institute.base.framwork.exception;

import com.institute.base.framwork.enums.ResultCode;

public class BusinessException extends BaseException {

  public BusinessException(ResultCode resultCode) {
    super(resultCode);
  }
}

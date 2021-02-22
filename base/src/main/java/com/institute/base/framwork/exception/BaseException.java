package com.institute.base.framwork.exception;

import com.institute.base.framwork.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
  private ResultCode resultCode;

  public BaseException(ResultCode resultCode) {
    super(resultCode.getMessage());
    this.resultCode = resultCode;
  }
}

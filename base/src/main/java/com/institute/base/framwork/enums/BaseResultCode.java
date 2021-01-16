package com.institute.base.framwork.enums;

import org.springframework.http.HttpStatus;

public enum BaseResultCode implements ResultCode {
  INTERNAL_SERVER_EXCEPTION(10000, "Internal Server Exception", HttpStatus.INTERNAL_SERVER_ERROR.value());


  private final int httpStatus;
  private final int resultCode;
  private final String message;

  BaseResultCode(int resultCode, String message, int httpStatus) {
    this.httpStatus = httpStatus;
    this.resultCode = resultCode;
    this.message = message;
  }

  @Override
  public int getHttpStatus() {
    return this.httpStatus;
  }

  @Override
  public int getResultCode() {
    return this.resultCode;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}

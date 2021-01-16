package com.institute.base.framwork.exception;

import com.institute.base.framwork.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {
  private ResultCode resultCode;


}

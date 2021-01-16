package com.institute.base.framwork.dto;

import com.institute.base.framwork.enums.ResponseMessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T>  {
  private int status;
  private int code;
  private ResponseMessageType responseMessage;
  private String message;
  private T content;
  private ResponseDetailDto responseDetailDto;



}

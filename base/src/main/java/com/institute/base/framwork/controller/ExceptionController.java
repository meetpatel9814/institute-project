package com.institute.base.framwork.controller;

import com.institute.base.framwork.dto.ResponseDto;
import com.institute.base.framwork.enums.ResponseMessageType;
import com.institute.base.framwork.enums.ResultCode;
import com.institute.base.framwork.exception.BaseException;
import com.institute.base.framwork.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionController {

/*  @ExceptionHandler(value = NoHandlerFoundException.class)
  public Object handleStaticResourceNotFound(final NoHandlerFoundException ex, HttpServletRequest req, RedirectAttributes redirectAttributes) {
    if (req.getRequestURI().startsWith("/api"))
      return "redirect:/index.html";
    else {
      redirectAttributes.addFlashAttribute("errorMessage", "My Custom error message");
      return "redirect:/index.html";
    }
  }*/


  @ExceptionHandler(value = BaseException.class)
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody ResponseDto<String> handleBuisnessException(BaseException ex, HttpServletResponse response, WebRequest request) {
    ResultCode resultCode = ex.getResultCode();

    ResponseDto<String> responseDto = new ResponseDto<>();
    responseDto.setStatus(resultCode.getHttpStatus());
    responseDto.setMessage(resultCode.getMessage());
    responseDto.setCode(resultCode.getResultCode());
    responseDto.setResponseMessage(ResponseMessageType.ERROR);
    return responseDto;
  }
}

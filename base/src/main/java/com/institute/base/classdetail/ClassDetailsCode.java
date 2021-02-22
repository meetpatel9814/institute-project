package com.institute.base.classdetail;

import com.institute.base.framwork.enums.ResultCode;
import org.springframework.http.HttpStatus;

public enum ClassDetailsCode implements ResultCode {
    INTERNAL_SERVER_EXCEPTION(20000, "Internal Server Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    CLASS_SAVE_SUCCESSFULLY(20001, "Class details saved successfully", HttpStatus.OK.value());
    private final int httpStatus;
    private final int resultCode;
    private final String message;

    ClassDetailsCode(int resultCode, String message, int httpStatus) {
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

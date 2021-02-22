package com.institute.base.student.enums;

import com.institute.base.framwork.enums.ResultCode;
import org.springframework.http.HttpStatus;

public enum StudentResultCode implements ResultCode {
    INTERNAL_SERVER_ERROR(30000, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    CLASS_NAME_REQUIRED(30001, "Class Name Required", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ERROR_ON_SAVE_STUDENT(30002, "Error occurred while saving Students Details.", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    STUDENT_SAVED_SUCCESS(30003, "Student Details saved successfully.", HttpStatus.OK.value());

    private final int httpStatus;
    private final int resultCode;
    private final String message;

    StudentResultCode(int resultCode, String message, int httpStatus) {
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

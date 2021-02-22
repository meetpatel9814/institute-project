package com.institute.base.framwork.validation;

import com.institute.base.framwork.enums.ResultCode;
import org.springframework.http.HttpStatus;

public enum ValidationCodes implements ResultCode {
    STUDENT_FIRST_NAME_NOT_VALID(900001, "Student First name is not in valid format", HttpStatus.BAD_REQUEST.value()),
    STUDENT_LAST_NAME_NOT_VALID(900002, "Student Last name is not in valid format", HttpStatus.BAD_REQUEST.value()),
    STUDENT_GENDER_REQUIRED(900003, "Student gender required", HttpStatus.BAD_REQUEST.value()),
    STUDENT_DOB_NOT_VALID(900004, "Student Date of Birth is not in valid", HttpStatus.BAD_REQUEST.value()),
    ATTENDANCE_STUDENT_ID_NOT_VALID(900005, "Student Id is not in valid in attendance details", HttpStatus.BAD_REQUEST.value()),
    ATTENDANCE_DATE_NOT_VALID(900006, "Attendance date is not valid", HttpStatus.BAD_REQUEST.value());

    private final int httpStatus;
    private final int resultCode;
    private final String message;

    ValidationCodes(int resultCode, String message, int httpStatus) {
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

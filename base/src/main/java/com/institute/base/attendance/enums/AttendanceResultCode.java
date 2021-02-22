package com.institute.base.attendance.enums;

import com.institute.base.framwork.enums.ResultCode;
import org.springframework.http.HttpStatus;

public enum AttendanceResultCode implements ResultCode {
    INTERNAL_SERVER_ERROR(40000, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ATTENDANCE_SAVE_ERROR(40001, "Error occurred while saving attendance details", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ATTENDANCE_SAVE_SUCCESS(40002, "Attendance details saved successfully", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ATTENDANCE_STUDENT_ID_NOT_VALID(40003, "Student Id is not in valid in attendance details", HttpStatus.BAD_REQUEST.value()),
    NO_LESSON_FOUND(40004, "No lesson found for selected date", HttpStatus.NOT_FOUND.value()),
    CLASS_NAME_REQUIRED(40005, "Class Name Required", HttpStatus.NOT_FOUND.value());
    private final int httpStatus;
    private final int resultCode;
    private final String message;

    AttendanceResultCode(int resultCode, String message, int httpStatus) {
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

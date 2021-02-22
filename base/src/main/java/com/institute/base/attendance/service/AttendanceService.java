package com.institute.base.attendance.service;

import com.institute.base.attendance.dto.AttendanceDetailDto;
import com.institute.base.attendance.entity.Lesson;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AttendanceService {

    List<AttendanceDetailDto> getAttendanceByClassName(AttendanceDetailDto attendanceDetailDto);

    boolean saveAttendance(AttendanceDetailDto attendanceDetailDto);

    Lesson getLessonByDate(@NotNull String date);
}

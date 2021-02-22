package com.institute.base.attendance.repository;

import com.institute.base.attendance.entity.AttendanceDetail;
import com.institute.base.attendance.entity.Lesson;

import java.util.List;

public interface AttendanceRepository {
    List<AttendanceDetail> findAttendancesByClassName(String className);

    void saveAttendanceDetails(List<AttendanceDetail> attendanceDetails);

    Lesson getLessonByDate(String date);

    Lesson saveLesson(Lesson lesson);
}

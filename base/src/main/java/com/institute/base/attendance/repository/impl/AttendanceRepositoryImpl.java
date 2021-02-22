package com.institute.base.attendance.repository.impl;

import com.institute.base.attendance.dao.AttendanceDao;
import com.institute.base.attendance.dao.LessonDao;
import com.institute.base.attendance.entity.AttendanceDetail;
import com.institute.base.attendance.entity.Lesson;
import com.institute.base.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository {

    private AttendanceDao attendanceDao;
    private LessonDao lessonDao;

    @Autowired
    public AttendanceRepositoryImpl(AttendanceDao attendanceDao, LessonDao lessonDao) {
        this.attendanceDao = attendanceDao;
        this.lessonDao = lessonDao;
    }

    @Override
    public List<AttendanceDetail> findAttendancesByClassName(@NotNull String className) {
        return attendanceDao.findAttendancesByClassName(className);
    }

    @Override
    public void saveAttendanceDetails(@NotNull List<AttendanceDetail> attendanceDetails) {
        attendanceDao.saveAttendanceDetails(attendanceDetails);
    }

    @Override
    public Lesson getLessonByDate(@NotNull String date) {
        return lessonDao.getLessonByDate(date);
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return lessonDao.save(lesson);
    }
}

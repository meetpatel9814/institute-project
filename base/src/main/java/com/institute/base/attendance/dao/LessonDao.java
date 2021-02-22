package com.institute.base.attendance.dao;

import com.institute.base.attendance.entity.AttendanceDetail;
import com.institute.base.attendance.entity.Lesson;
import com.institute.base.framwork.dao.BaseDao;

public interface LessonDao extends BaseDao<Lesson, Long> {
    Lesson getLessonByDate(String date);
}

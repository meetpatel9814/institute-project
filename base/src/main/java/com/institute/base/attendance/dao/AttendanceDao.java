package com.institute.base.attendance.dao;

import com.institute.base.attendance.entity.AttendanceDetail;
import com.institute.base.attendance.entity.Lesson;
import com.institute.base.framwork.dao.BaseDao;

import java.util.List;

public interface AttendanceDao extends BaseDao<AttendanceDetail, Long> {

    List<AttendanceDetail> findAttendancesByClassName(String className);

    void saveAttendanceDetails(List<AttendanceDetail> attendanceDetails);


}

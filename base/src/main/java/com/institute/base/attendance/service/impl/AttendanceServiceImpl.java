package com.institute.base.attendance.service.impl;

import com.institute.base.attendance.dto.AttendanceDetailDto;
import com.institute.base.attendance.entity.AttendanceDetail;
import com.institute.base.attendance.entity.Lesson;
import com.institute.base.attendance.enums.AttendanceResultCode;
import com.institute.base.attendance.repository.AttendanceRepository;
import com.institute.base.attendance.service.AttendanceService;
import com.institute.base.framwork.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger LOGGER = LogManager.getLogger();
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ModelMapper mapper;


    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AttendanceDetailDto> getAttendanceByClassName(@Nullable AttendanceDetailDto attendanceDetailDto) {
        if (attendanceDetailDto != null && StringUtils.hasText(attendanceDetailDto.getClassName())) {
            return attendanceRepository.findAttendancesByClassName(attendanceDetailDto.getClassName()).stream()
                    .map(attendance -> mapper.map(attendance, AttendanceDetailDto.class)).collect(Collectors.toList());
        } else {
            throw new BusinessException(AttendanceResultCode.CLASS_NAME_REQUIRED);
        }

    }

    @Override
    public boolean saveAttendance(@Nullable AttendanceDetailDto attendanceDetailDto) {
        if (attendanceDetailDto != null) {
            validateAttendanceDetail(attendanceDetailDto);
            Lesson lesson = this.getLessonByDate(attendanceDetailDto.getDate());
            if (lesson == null) {   // creating new lesson if no lesson found for the selected date.
                lesson = new Lesson();
                lesson.setDate(attendanceDetailDto.getDate());
                lesson = attendanceRepository.saveLesson(lesson);
            }
            List<AttendanceDetail> attendanceDetails = new ArrayList<>();
            for (Long studentClassId : attendanceDetailDto.getStudentClassIds()) {
                AttendanceDetail attendanceDetail = new AttendanceDetail();
                attendanceDetail.setStudentClassId(studentClassId);
                attendanceDetail.setLessonId(lesson.getId());
                attendanceDetails.add(attendanceDetail);
            }
            attendanceRepository.saveAttendanceDetails(attendanceDetails);
            return true;
        }
        return false;
    }

    private void validateAttendanceDetail(@NotNull AttendanceDetailDto attendanceDetailDto) {
        attendanceDetailDto.getStudentClassIds().stream().filter(id -> id < 1).findAny().ifPresent(id -> {
            LOGGER.error("student_class_id is not valid :" + id);
            throw new BusinessException(AttendanceResultCode.ATTENDANCE_STUDENT_ID_NOT_VALID);
        });
    }

    @Override
    public Lesson getLessonByDate(@NotNull String date) {
        return attendanceRepository.getLessonByDate(date);
    }
}

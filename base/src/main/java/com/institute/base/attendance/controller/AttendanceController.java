package com.institute.base.attendance.controller;

import com.institute.base.attendance.dto.AttendanceDetailDto;
import com.institute.base.attendance.enums.AttendanceResultCode;
import com.institute.base.attendance.service.AttendanceService;
import com.institute.base.framwork.controller.BaseController;
import com.institute.base.framwork.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController extends BaseController {

    private AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseDto<List<AttendanceDetailDto>> getAttendanceByClassName(@RequestParam(value = "filter" , required = false) String filter) {
        return super.wrapperContent(AttendanceResultCode.INTERNAL_SERVER_ERROR, () ->{
                    AttendanceDetailDto attendanceDetailDto = this.convertToPojo(filter, AttendanceDetailDto.class);
                    return attendanceService.getAttendanceByClassName(attendanceDetailDto);
                }
                );
    }

    @PostMapping
    public ResponseDto<Boolean> saveAttendanceDetail(@RequestBody @Valid AttendanceDetailDto attendanceDetailDto, BindingResult bindingResult) {
        return super.wrapperContentWithValidation(bindingResult, AttendanceResultCode.ATTENDANCE_SAVE_ERROR,
                AttendanceResultCode.ATTENDANCE_SAVE_SUCCESS, () -> attendanceService.saveAttendance(attendanceDetailDto));
    }
}

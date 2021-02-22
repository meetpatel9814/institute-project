package com.institute.base.attendance.dto;

import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.framwork.dto.BaseInstituteDto;
import com.institute.base.framwork.validation.IsDate;
import com.institute.base.framwork.validation.ValidationCode;
import com.institute.base.framwork.validation.ValidationCodes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class AttendanceDetailDto extends BaseInstituteDto {
    @NotNull
    @ValidationCode(ValidationCodes.ATTENDANCE_STUDENT_ID_NOT_VALID)
    private List<Long> studentClassIds;

    @IsDate( pattern = "dd/MM/yyyy")
    @ValidationCode(ValidationCodes.ATTENDANCE_DATE_NOT_VALID)
    private String date;

    private Long studentClassId;

    private String className;
}

package com.institute.base.student.dto;

import com.institute.base.classdetail.dto.ClassDetailDto;
import com.institute.base.framwork.dto.BaseInstituteDto;
import com.institute.base.framwork.validation.IsDate;
import com.institute.base.framwork.validation.ValidationCode;
import com.institute.base.framwork.validation.ValidationCodes;
import com.institute.base.student.enums.StudentResultCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@ToString
public class StudentDto extends BaseInstituteDto {
    @NotBlank
    @ValidationCode(ValidationCodes.STUDENT_FIRST_NAME_NOT_VALID)
    private String firstName;

    private String middleName;

    @NotBlank
    @ValidationCode(ValidationCodes.STUDENT_LAST_NAME_NOT_VALID)
    private String lastName;

    @NotBlank
    @ValidationCode(ValidationCodes.STUDENT_GENDER_REQUIRED)
    private String gender;


    @IsDate( pattern = "dd/MM/yyyy")
    @ValidationCode(ValidationCodes.STUDENT_DOB_NOT_VALID)
    private String dob;

    private Long studentClassId;
    private ClassDetailDto classDetail;
}

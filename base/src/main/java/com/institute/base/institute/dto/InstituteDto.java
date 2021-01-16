package com.institute.base.institute.dto;

import com.institute.base.framwork.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@EqualsAndHashCode(callSuper = true)
@ToString
public class InstituteDto extends BaseDto {

  private String instituteName;

}

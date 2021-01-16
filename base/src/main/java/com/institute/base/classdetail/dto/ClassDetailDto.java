package com.institute.base.classdetail.dto;

import com.institute.base.framwork.dto.BaseDto;
import com.institute.base.framwork.dto.BaseInstituteDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
//@EqualsAndHashCode(callSuper = true)
@ToString
public class ClassDetailDto extends BaseInstituteDto {

  private String name;
  @NotBlank
  private String div;
  @NotBlank
  private String std;
  private String stream;

}

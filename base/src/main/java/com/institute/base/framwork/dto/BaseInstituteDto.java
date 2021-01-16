package com.institute.base.framwork.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.institute.base.institute.entity.Institute;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BaseInstituteDto extends BaseDto {
  @JsonIgnore
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Institute institute;
  @JsonIgnore
  private Long instituteKey;

  public static final long DEMO_INSTITUTE_KEY = 1;
}

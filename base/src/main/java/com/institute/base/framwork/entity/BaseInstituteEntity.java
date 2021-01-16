package com.institute.base.framwork.entity;

import com.institute.base.institute.entity.Institute;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BaseInstituteEntity extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  @JoinColumn(name = "INSTITUTE_KEY", updatable = false, insertable = false)
  private Institute institute;

  @Column(name = "INSTITUTE_KEY")
  private Long instituteKey;

  public static final long DEMO_INSTITUTE_KEY = 1;
}

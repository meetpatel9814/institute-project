package com.institute.base.institute.entity;

import com.institute.base.framwork.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "INSTITUTE_DETAILS")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Institute extends BaseEntity {

  @Column(name= "NAME")
  private String instituteName;
}

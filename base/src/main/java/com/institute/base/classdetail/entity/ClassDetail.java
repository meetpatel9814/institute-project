package com.institute.base.classdetail.entity;

import com.institute.base.framwork.entity.BaseEntity;
import com.institute.base.framwork.entity.BaseInstituteEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "CLASS_DETAILS")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class ClassDetail extends BaseInstituteEntity implements Serializable {
// impl Serializable because it is used in StudentClassMapper as non PK relation
  @Column(name= "NAME")
  private String name;
  @Column(name= "DIV")
  private String div;
  @Column(name= "STD")
  private String std;
  @Column(name= "STREAM")
  private String stream;


  public void setClassName() {
    this.name = std + "-" + div;
  }

}

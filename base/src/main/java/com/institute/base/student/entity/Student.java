package com.institute.base.student.entity;

import com.institute.base.framwork.entity.BaseInstituteEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_DETAILS")
@Getter
@Setter
public class Student extends BaseInstituteEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DOB")
    private String dob;

    @OneToOne(mappedBy ="student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    StudentClassMapper studentClassMapper;
}

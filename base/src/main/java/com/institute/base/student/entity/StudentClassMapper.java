package com.institute.base.student.entity;

import com.institute.base.classdetail.entity.ClassDetail;
import com.institute.base.framwork.entity.BaseInstituteEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_CLASS_MAPPER")
@Getter
@Setter
public class StudentClassMapper extends BaseInstituteEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, insertable = false, name = "STUDENT_ID")
    Student student;

    @Column(name = "STUDENT_ID")
    String studentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(updatable = false, insertable = false, name = "CLASS_NAME", referencedColumnName = "NAME"),
            @JoinColumn(updatable = false, insertable = false, name = "CLASS_ID", referencedColumnName = "ID")
    })
    ClassDetail classDetail;

    @Column(name = "CLASS_NAME")
    String className;

    @Column(name = "CLASS_ID")
    Long classId;

    @Column(name = "YEAR_RANGE")
    String yearRange;

    @Column(name = "IS_CURRENT_YEAR")
    Boolean isCurrentYear;

}

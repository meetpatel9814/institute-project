package com.institute.base.attendance.entity;

import com.institute.base.classdetail.entity.ClassDetail;
import com.institute.base.framwork.entity.BaseInstituteEntity;
import com.institute.base.student.entity.StudentClassMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LESSON")
@Getter
@Setter
public class Lesson extends BaseInstituteEntity {

    @Column(name="DATE")
    String date;

    @Column(name = "YEAR_RANGE")
    String yearRange;



    // in future we can add subject, time_range for college portal also

}

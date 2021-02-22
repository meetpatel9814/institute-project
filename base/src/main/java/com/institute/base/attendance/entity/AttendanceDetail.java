package com.institute.base.attendance.entity;

import com.institute.base.framwork.entity.BaseInstituteEntity;
import com.institute.base.student.entity.StudentClassMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ATTENDANCE_DETAIL", uniqueConstraints={@UniqueConstraint(columnNames={"STUDENT_CLASS_ID", "LESSON_ID"})})
@Getter
@Setter
public class AttendanceDetail extends BaseInstituteEntity {

    @OneToOne
    @JoinColumn(updatable = false, insertable = false, name = "STUDENT_CLASS_ID")
    StudentClassMapper studentClassMapper;

    @Column(name = "STUDENT_CLASS_ID")
    Long studentClassId;

    @OneToOne
    @JoinColumn(updatable = false, insertable = false, name = "LESSON_ID")
    Lesson lesson;

    @Column(name = "LESSON_ID")
    Long lessonId;
}

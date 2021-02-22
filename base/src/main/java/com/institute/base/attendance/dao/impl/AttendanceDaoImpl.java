package com.institute.base.attendance.dao.impl;

import com.institute.base.attendance.dao.AttendanceDao;
import com.institute.base.attendance.entity.AttendanceDetail;
import com.institute.base.attendance.entity.Lesson;
import com.institute.base.framwork.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collections;
import java.util.List;

@Service
public class AttendanceDaoImpl extends BaseDaoImpl<AttendanceDetail, Long> implements AttendanceDao {
    public AttendanceDaoImpl() {
        super(AttendanceDetail.class);
    }


    @Override
    public List<AttendanceDetail> findAttendancesByClassName(String className) {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<AttendanceDetail> criteriaQuery = this.getCriteriaQuery(criteriaBuilder);
        Root<AttendanceDetail> root = criteriaQuery.from(AttendanceDetail.class);
        Join<AttendanceDetail, Lesson> studentClassMapperJoin = root.join("studentClassMapper", JoinType.INNER);
        criteriaQuery.select(root);

        //final List<Predicate> predicateList = new ArrayList<>();
        //predicateList.add(criteriaBuilder.equal(studentClassMapperJoin.get("className"), className));
        criteriaQuery.where(criteriaBuilder.equal(studentClassMapperJoin.get("className"), className));
        TypedQuery<AttendanceDetail> query = this.getEntityManager().createQuery(criteriaQuery);
/*        TypedQuery<Student> query = getEntityManager().createQuery("SELECT s FROM Student s JOIN StudentClassMapper scm " +
                "ON scm.studentId = s.id AND scm.className = :className", Student.class);
        query.setParameter("className", className);*/
        return query.getResultList();
    }

    @Override
    public void saveAttendanceDetails(List<AttendanceDetail> attendanceDetails) {
        for (AttendanceDetail attendance : attendanceDetails) {
            AttendanceDetail attendanceDetail = this.save(attendance);
        }
    }


}

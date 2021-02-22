package com.institute.base.student.dao.impl;

import com.institute.base.framwork.dao.impl.BaseDaoImpl;
import com.institute.base.student.dao.StudentDao;
import com.institute.base.student.entity.Student;
import com.institute.base.student.entity.StudentClassMapper;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDaoImpl extends BaseDaoImpl<Student, Long> implements StudentDao  {
    public StudentDaoImpl() {
        super(Student.class);
    }


    @Override
    public List<Student> findStudentsByClassName(String className) {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = this.getCriteriaQuery(criteriaBuilder);
        Root<Student> root = criteriaQuery.from(Student.class);
        Join<Student, StudentClassMapper> studentClassMapperJoin = root.join("studentClassMapper", JoinType.INNER);
        criteriaQuery.select(root);

        //final List<Predicate> predicateList = new ArrayList<>();
        //predicateList.add(criteriaBuilder.equal(studentClassMapperJoin.get("className"), className));
        criteriaQuery.where(criteriaBuilder.equal(studentClassMapperJoin.get("className"), className));
        TypedQuery<Student> query = this.getEntityManager().createQuery(criteriaQuery);
/*        TypedQuery<Student> query = getEntityManager().createQuery("SELECT s FROM Student s JOIN StudentClassMapper scm " +
                "ON scm.studentId = s.id AND scm.className = :className", Student.class);
        query.setParameter("className", className);*/
        return query.getResultList();
    }
}

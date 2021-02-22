package com.institute.base.attendance.dao.impl;

import com.institute.base.attendance.dao.LessonDao;
import com.institute.base.attendance.entity.Lesson;
import com.institute.base.framwork.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class LessonDaoImpl extends BaseDaoImpl<Lesson, Long> implements LessonDao {
    public LessonDaoImpl() {
        super(Lesson.class);
    }

    @Override
    public Lesson getLessonByDate(String date) {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<Lesson> criteriaQuery = criteriaBuilder.createQuery(Lesson.class);
        Root<Lesson> root = criteriaQuery.from(Lesson.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("date"), date));
        List<Lesson> resultList = this.getEntityManager().createQuery(criteriaQuery).getResultList();
        return !CollectionUtils.isEmpty(resultList) ? resultList.get(0) : null;
    }
}

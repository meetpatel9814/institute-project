package com.institute.base.framwork.dao.impl;

import com.institute.base.framwork.dao.BaseDao;
import com.institute.base.framwork.entity.BaseEntity;
import com.institute.base.framwork.entity.BaseInstituteEntity;
import com.institute.base.framwork.wrapper.EntityManagerWrapper;
import com.institute.base.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BaseDaoImpl<T extends BaseEntity, K> implements BaseDao<T, K> {

  private EntityManager entityManager;
  private Class<T> entityClass;

  public BaseDaoImpl(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public final void setEntityClass(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager= new EntityManagerWrapper(entityManager);
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }



  public CriteriaQuery<T> getCriteriaQuery (CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.createQuery(entityClass);
  }

  public CriteriaBuilder getCriteriaBuilder () {
    return this.getEntityManager().getCriteriaBuilder();
  }

  @Override
  public List<T> findAll() {
    CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(entityClass);
    Root<T> tRoot = criteriaQuery.from(entityClass);
    criteriaQuery.select(tRoot);
    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public T findByKey(K key) {
    return null;
  }

  @Override
  public void delete(K key) {

  }

  @Override
  public T save(T entity) {
    setInstituteKey(entity);
    entityManager.persist(entity);
    return entity;
  }

  private void setInstituteKey(T entity) {
    if(entity instanceof BaseInstituteEntity) {
      ((BaseInstituteEntity) entity).setInstituteKey(BaseInstituteEntity.DEMO_INSTITUTE_KEY);
    }
  }

  @Override
  public T update(T entity) {
    return null;
  }
}

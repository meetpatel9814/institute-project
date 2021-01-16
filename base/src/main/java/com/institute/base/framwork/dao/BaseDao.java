package com.institute.base.framwork.dao;

import com.institute.base.framwork.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity, K> {



  List<T> findAll();

  T findByKey(K key);

  void delete(K key);

  T save(T entity);

  /**
   * This method is used to update entity
   *
   * @param entity
   *          {@link T} contains Entity information
   * @return T which is business Entity which is updated.
   */
  T update(T entity);
}

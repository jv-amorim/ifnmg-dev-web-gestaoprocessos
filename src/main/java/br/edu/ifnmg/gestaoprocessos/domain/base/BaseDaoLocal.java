package br.edu.ifnmg.gestaoprocessos.domain.base;

import java.util.List;

public interface BaseDaoLocal {

    void saveOrUpdate(BaseEntity entity);
    void delete(BaseEntity ent);
    Object findById(Class<?> entClass,Long id);
    <T> List<T> findListPure(String sql, Object[] params);
    <T> List<T> findListNamed(String namedQuery, Object[] params);
}

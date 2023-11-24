package br.edu.ifnmg.gestaoprocessos.domain.base;

import java.util.List;

public interface BaseDaoLocal {

    void saveOrUpdate(BaseEntity entity);

    List<BaseEntity> findListPure(String sql, Object[] params);

}

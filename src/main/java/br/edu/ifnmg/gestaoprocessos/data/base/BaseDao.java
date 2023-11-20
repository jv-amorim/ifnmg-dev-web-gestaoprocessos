package br.edu.ifnmg.gestaoprocessos.data.base;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDao implements BaseDaoLocal {

    @PersistenceContext
    protected EntityManager entityManager;

    public void saveOrUpdate(BaseEntity entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entity.refreshUpdatedAt();
            entityManager.merge(entity);
        }
    }

    /**
     * Executa um SQL puro.
     */
    public List<BaseEntity> findListPure(String sql, Object[] params) {
        Query query = entityManager.createQuery(sql);

        if (params.length > 0) {
            for (int i = 1; i <= params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        return query.getResultList();
    }

}

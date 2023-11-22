package br.edu.ifnmg.gestaoprocessos.data.base;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveOrUpdate(BaseEntity ent) {
        if (ent.getId() == null) {
            entityManager.persist(ent);
        } else {
            ent.refreshUpdatedAt();
            entityManager.merge(ent);
        }
    }
    
    public void delete(BaseEntity ent) {
    	entityManager.remove(ent);
    }

	public Object findById(Class<?> entClass,Long id) {
    	return entityManager.find(entClass, id);
    }
    
    /**
     * Executa um SQL puro.
     */
    public <T> List<T> findListPure(String sql, Object[] params) {
        Query query = entityManager.createQuery(sql);

        if (params != null && params.length > 0) {
            for (int i = 1; i <= params.length; i++) {
                query.setParameter(i, params[i-1]);
            }
        }

        return query.getResultList();
    }
    
}

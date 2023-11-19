package br.edu.ifnmg.gestaoprocessos.data.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

public class GenericDao {
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
    
    //Executa um SQL puro
    public List<BaseEntity> findListPure(String sql, Object[] params) {
    	Query query = entityManager.createQuery(sql);
    	
    	if(params.length > 0) {
    		for(int i = 1; i <= params.length; i++) {
    			query.setParameter(i, params[i]);
    		}
    	}
    	
    	return query.getResultList();
    }
}

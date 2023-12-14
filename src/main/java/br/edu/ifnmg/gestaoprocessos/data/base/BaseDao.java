package br.edu.ifnmg.gestaoprocessos.data.base;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RequestScoped
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

	public void delete(BaseEntity ent) {
		entityManager.remove(entityManager.merge(ent));
	}

	public Object findById(Class<?> entClass, Long id) {
		return entityManager.find(entClass, id);
	}

	/**
	 * Executa um SQL puro.
	 */
	public <T> List<T> findListPure(String sql, Object[] params) {
		Query query = entityManager.createQuery(sql);

		if (params != null && params.length > 0) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}

		return query.getResultList();
	}

	public <T> List<T> findListNamed(String namedQuery, Object[] params) {
		Query query = entityManager.createNamedQuery(namedQuery);
		
		if (params != null && params.length > 0) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}

		return query.getResultList();	
	}
}

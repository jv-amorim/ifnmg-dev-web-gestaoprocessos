package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;

@Stateless
public class UserDao implements UserDaoLocal {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(UserEntity user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            user.refreshUpdatedAt();
            entityManager.merge(user);
        }
    }
    
}

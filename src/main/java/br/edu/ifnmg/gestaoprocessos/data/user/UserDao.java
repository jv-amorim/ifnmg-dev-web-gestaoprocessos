package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;

@Stateless
public class UserDao extends GenericDao implements UserDaoLocal {
    
    @Override
    public void save(UserEntity user) {
        super.saveOrUpdate(user);
    }
    
}

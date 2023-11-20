package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class UserDao extends BaseDao implements UserDaoLocal {

    @Override
    public void save(UserEntity user) {
        super.saveOrUpdate(user);
    }

    @Override
    public List<UserEntity> listAll() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

}

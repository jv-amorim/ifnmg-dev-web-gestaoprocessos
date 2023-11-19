package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import javax.ejb.Stateless;

@Stateless
public class UserDao extends BaseDao implements UserDaoLocal {

    @Override
    public void save(UserEntity user) {
        super.saveOrUpdate(user);
    }

}

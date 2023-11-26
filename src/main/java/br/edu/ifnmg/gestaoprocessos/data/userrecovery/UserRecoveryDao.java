package br.edu.ifnmg.gestaoprocessos.data.userrecovery;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.userrecovery.UserRecoveryDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.userrecovery.UserRecoveryEntity;
import javax.ejb.Stateless;

public class UserRecoveryDao extends BaseDao implements UserRecoveryDaoLocal {

    @Override
    public void save(UserRecoveryEntity userRecoveryEntity) {
        super.saveOrUpdate(userRecoveryEntity);
    }

}

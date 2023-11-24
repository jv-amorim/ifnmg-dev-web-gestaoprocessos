package br.edu.ifnmg.gestaoprocessos.domain.userrecovery;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface UserRecoveryDaoLocal extends BaseDaoLocal {

    void save(UserRecoveryEntity userRecoveryEntity);

}

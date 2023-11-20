package br.edu.ifnmg.gestaoprocessos.domain.user;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;
import java.util.List;

public interface UserDaoLocal extends BaseDaoLocal {

    void save(UserEntity user);

    List<UserEntity> listAll();

}

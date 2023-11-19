package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;

public interface UserDaoLocal {
    
    void save(UserEntity user);
    
}

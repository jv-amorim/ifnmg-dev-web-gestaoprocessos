package br.edu.ifnmg.gestaoprocessos.domain.user;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;
import java.util.List;

public interface UserDaoLocal extends BaseDaoLocal {

    void save(UserEntity user);
    void delete(UserEntity user);
    UserEntity find(Long id);
    List<UserEntity> findPureList(String sql,Object[] params);
    List<UserEntity> listAll();
}

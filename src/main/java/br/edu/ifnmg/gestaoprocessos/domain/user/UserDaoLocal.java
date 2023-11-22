package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.util.List;

import javax.xml.registry.infomodel.User;

public interface UserDaoLocal {

    void save(UserEntity user);
    void delete(UserEntity user);
    UserEntity find(Long id);
    List<UserEntity> findPureList(String sql,Object[] params);
}

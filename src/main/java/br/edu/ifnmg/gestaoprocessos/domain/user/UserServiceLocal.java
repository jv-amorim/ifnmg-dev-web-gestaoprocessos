package br.edu.ifnmg.gestaoprocessos.domain.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.dtos.ReqCreateUser;

public interface UserServiceLocal {
    
    UserEntity create(ReqCreateUser req) throws Exception;
    
    UserEntity createEditor(ReqCreateUser req) throws Exception;
    
}

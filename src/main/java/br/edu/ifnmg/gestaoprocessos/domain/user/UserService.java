package br.edu.ifnmg.gestaoprocessos.domain.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.dtos.ReqCreateUser;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class UserService implements UserServiceLocal {

    @Inject private UserDaoLocal userDao;
    
    @Override
    public UserEntity create(ReqCreateUser req) throws Exception {
        validateReqCreateUser(req);
        
        UserEntity user = new UserEntity();
        user.setRole(UserRole.APPLICANT);
        user.setName(req.getName().trim());
        user.setEmail(req.getEmail().trim());
        user.setPasswordHash("123ABC");
        
        userDao.save(user);
        
        return user;
    }
    
    private void validateReqCreateUser(ReqCreateUser req) throws Exception {
        if (req == null) {
            throw new Exception("Nenhum dado informado.");
        }
        if (req.getName().trim().split("\\s+").length < 2) {
            throw new Exception("É necessário informar o nome e sobrenome.");
        }
        if (!req.getPassword().equals(req.getPasswordConfirmation())) {
            throw new Exception("A senha e a confirmação não correspondem.");
        }
        
        // TODO - Validate if exists user with same email.
    }

    @Override
    public UserEntity createEditor(ReqCreateUser req) throws Exception {
        validateReqCreateUser(req);
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

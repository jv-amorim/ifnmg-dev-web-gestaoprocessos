package br.edu.ifnmg.gestaoprocessos.data;

import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class InitialDataLoader {

    @Inject
    private UserDaoLocal userDao;

    @PostConstruct
    public void execute() {
        UserEntity user1 = new UserEntity();
        user1.setRole(UserRole.ADMIN);
        user1.setName("Admin");
        user1.setEmail("admin@ifngm.edu.br");
        user1.setPasswordHash("#$%123ABC");
        user1.setPasswordSalt("JKL369");
        userDao.save(user1);
    }

}

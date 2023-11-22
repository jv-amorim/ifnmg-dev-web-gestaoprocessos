package br.edu.ifnmg.gestaoprocessos.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;

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
        
        UserEntity user2 = new UserEntity();
        user2.setRole(UserRole.ADMIN);
        user2.setName("Admin2");
        user2.setEmail("admin2@ifngm.edu.br");
        user2.setPasswordHash("#$%123ABC");
        user2.setPasswordSalt("JKL361");
        userDao.save(user2);

        
        //Testes dos metodos de CRUD
        
        List<UserEntity> userList = userDao.findPureList("SELECT u from User u", null);
        for (UserEntity userEntity : userList) {
        	System.out.println("USUARIO ID: " + userEntity.getId() + " USUARIO NOME: " + userEntity.getName());
		}
        
        Object[] params = {new String("Admin2")};
        
        List<UserEntity> userListWithParams = userDao.findPureList("SELECT u from User u Where name = ?1", params);
        for (UserEntity userEntity : userListWithParams) {
        	System.out.println("USUARIO ID: " + userEntity.getId() + " USUARIO NOME: " + userEntity.getName());
		}       
        
        UserEntity loadUser = userDao.find(1l);
        System.out.println("USUARIO ID: " + loadUser.getId() + " USUARIO NOME: " + loadUser.getName());
        
        userDao.delete(loadUser);
        
    }

}

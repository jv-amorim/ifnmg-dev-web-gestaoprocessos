package br.edu.ifnmg.gestaoprocessos.view;

import javax.inject.Inject;

import br.edu.ifnmg.gestaoprocessos.data.user.UserDao;
import br.edu.ifnmg.gestaoprocessos.data.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;

public class PersistenceTestBean {

	
	public void popularBanco() {
		UserDao userDao = new UserDao();
		UserEntity user = new UserEntity(UserRole.ADMIN, "guisso", "guisso@ifnmg.edu.br", "123455", "554321");
		userDao.save(user);
	}
	
}

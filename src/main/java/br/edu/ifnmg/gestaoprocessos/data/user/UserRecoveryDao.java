package br.edu.ifnmg.gestaoprocessos.data.user;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRecoveryEntity;

@Stateless
public class UserRecoveryDao extends GenericDao implements UserRecoveryDaoLocal{

	@Override
	public void save(UserRecoveryEntity userRecoveryEntity) {
		super.saveOrUpdate(userRecoveryEntity);
	}

}

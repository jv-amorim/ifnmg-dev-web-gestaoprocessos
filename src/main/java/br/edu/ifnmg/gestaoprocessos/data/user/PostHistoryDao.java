package br.edu.ifnmg.gestaoprocessos.data.user;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.PostHistoryEntity;

@Stateless
public class PostHistoryDao extends GenericDao implements PostHistoryDaoLocal{

	@Override
	public void save(PostHistoryEntity postHistoryEntity) {
		super.saveOrUpdate(postHistoryEntity);
	}

}

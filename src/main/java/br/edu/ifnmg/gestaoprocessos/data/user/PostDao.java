package br.edu.ifnmg.gestaoprocessos.data.user;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.PostEntity;

@Stateless
public class PostDao extends GenericDao implements PostDaoLocal {

	@Override
	public void save(PostEntity postEntity) {
		super.saveOrUpdate(postEntity);
	}
	
}

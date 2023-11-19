package br.edu.ifnmg.gestaoprocessos.data.user;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.PostSocialEntity;

@Stateless
public class PostSocialDao extends GenericDao implements PostSocialDaoLocal {

	@Override
	public void save(PostSocialEntity postSocialEntity) {
		super.saveOrUpdate(postSocialEntity);
	}

}

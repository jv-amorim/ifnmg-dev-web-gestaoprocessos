package br.edu.ifnmg.gestaoprocessos.data.postsocial;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.postsocial.PostSocialDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.postsocial.PostSocialEntity;
import javax.ejb.Stateless;

@Stateless
public class PostSocialDao extends BaseDao implements PostSocialDaoLocal {

    @Override
    public void save(PostSocialEntity postSocialEntity) {
        super.saveOrUpdate(postSocialEntity);
    }

}

package br.edu.ifnmg.gestaoprocessos.data.post;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostEntity;
import javax.ejb.Stateless;

public class PostDao extends BaseDao implements PostDaoLocal {

    @Override
    public void save(PostEntity postEntity) {
        super.saveOrUpdate(postEntity);
    }

}

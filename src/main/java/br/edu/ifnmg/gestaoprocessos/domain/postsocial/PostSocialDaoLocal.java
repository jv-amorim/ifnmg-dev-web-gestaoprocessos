package br.edu.ifnmg.gestaoprocessos.domain.postsocial;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface PostSocialDaoLocal extends BaseDaoLocal {

    void save(PostSocialEntity postSocialEntity);

}

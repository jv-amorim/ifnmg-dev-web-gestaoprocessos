package br.edu.ifnmg.gestaoprocessos.domain.post;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface PostDaoLocal extends BaseDaoLocal {

    void save(PostEntity postEntity);

}

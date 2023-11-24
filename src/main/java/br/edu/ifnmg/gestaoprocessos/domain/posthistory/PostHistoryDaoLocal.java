package br.edu.ifnmg.gestaoprocessos.domain.posthistory;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface PostHistoryDaoLocal extends BaseDaoLocal {

    void save(PostHistoryEntity postHistoryEntity);

}

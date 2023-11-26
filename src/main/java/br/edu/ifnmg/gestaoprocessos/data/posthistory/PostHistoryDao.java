package br.edu.ifnmg.gestaoprocessos.data.posthistory;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.posthistory.PostHistoryDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.posthistory.PostHistoryEntity;
import javax.ejb.Stateless;

public class PostHistoryDao extends BaseDao implements PostHistoryDaoLocal {

    @Override
    public void save(PostHistoryEntity postHistoryEntity) {
        super.saveOrUpdate(postHistoryEntity);
    }

}

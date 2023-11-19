package br.edu.ifnmg.gestaoprocessos.data.selectionprocess;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessEntity;
import javax.ejb.Stateless;

@Stateless
public class SelectionProcessDao extends BaseDao implements SelectionProcessDaoLocal {

    @Override
    public void save(SelectionProcessEntity selectionProcessEntity) {
        super.saveOrUpdate(selectionProcessEntity);
    }

}

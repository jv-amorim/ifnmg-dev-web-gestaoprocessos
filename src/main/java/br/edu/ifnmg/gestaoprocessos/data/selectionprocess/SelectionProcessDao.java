package br.edu.ifnmg.gestaoprocessos.data.selectionprocess;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SelectionProcessDao extends BaseDao implements SelectionProcessDaoLocal {

    @Override
    public void save(SelectionProcessEntity selectionProcessEntity) {
        super.saveOrUpdate(selectionProcessEntity);
    }

    @Override
    public List<SelectionProcessEntity> listAll() {
        Query query = entityManager.createQuery("SELECT s FROM SelectionProcess s");
        return query.getResultList();
    }

}

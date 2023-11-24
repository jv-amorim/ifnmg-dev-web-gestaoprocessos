package br.edu.ifnmg.gestaoprocessos.domain.selectionprocess;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;
import java.util.List;

public interface SelectionProcessDaoLocal extends BaseDaoLocal {

    void save(SelectionProcessEntity selectionProcessEntity);

    List<SelectionProcessEntity> listAll();

}

package br.edu.ifnmg.gestaoprocessos.data.applicant;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.SelectionProcessEntity;

@Stateless
public class SelectionProcessDao extends GenericDao implements SelectionProcessDaoLocal{

	@Override
	public void save(SelectionProcessEntity selectionProcessEntity) {
		super.saveOrUpdate(selectionProcessEntity);
	}

}

package br.edu.ifnmg.gestaoprocessos.data.user;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.FileEntity;

@Stateless
public class FileDao extends GenericDao implements FileDaoLocal{

	@Override
	public void save(FileEntity fileEntity) {
		super.saveOrUpdate(fileEntity);
	}

}

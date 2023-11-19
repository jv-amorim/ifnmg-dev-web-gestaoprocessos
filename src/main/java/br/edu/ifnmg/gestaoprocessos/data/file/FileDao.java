package br.edu.ifnmg.gestaoprocessos.data.file;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.file.FileDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.file.FileEntity;
import javax.ejb.Stateless;

@Stateless
public class FileDao extends BaseDao implements FileDaoLocal {

    @Override
    public void save(FileEntity fileEntity) {
        super.saveOrUpdate(fileEntity);
    }

}

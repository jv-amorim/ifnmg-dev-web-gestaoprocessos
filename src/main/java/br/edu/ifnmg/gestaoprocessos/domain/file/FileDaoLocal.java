package br.edu.ifnmg.gestaoprocessos.domain.file;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface FileDaoLocal extends BaseDaoLocal {

    void save(FileEntity fileEntity);

}

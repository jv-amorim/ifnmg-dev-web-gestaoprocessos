package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.FileEntity;

public interface FileDaoLocal {
    void save(FileEntity fileEntity);
}

package br.edu.ifnmg.gestaoprocessos.domain.post;

import java.util.List;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface PostDaoLocal extends BaseDaoLocal {

    void save(PostEntity postEntity);
    void delete(PostEntity user);
    PostEntity find(Long id);
    List<PostEntity> findPureList(String sql, Object[] params);
    List<PostEntity> listAll();

    
}

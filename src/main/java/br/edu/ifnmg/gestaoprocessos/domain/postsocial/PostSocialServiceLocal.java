package br.edu.ifnmg.gestaoprocessos.domain.postsocial;

import br.edu.ifnmg.gestaoprocessos.domain.post.PostEntity;
import java.util.List;

public interface PostSocialServiceLocal {

    List<PostSocialEntity> publish(PostEntity post) throws Exception;

}

package br.edu.ifnmg.gestaoprocessos.data.post;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostCategoryEnum;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostEntity;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.TypedQuery;

public class PostDao extends BaseDao implements PostDaoLocal {

    @Override
    public void save(PostEntity postEntity) {
        super.saveOrUpdate(postEntity);
    }
    
	@Override
	public PostEntity find(Long id) {
		return (PostEntity) super.findById(PostEntity.class, id);
	}

	@Override
	public List<PostEntity> findPureList(String sql, Object[] params) {
		return super.findListPure(sql, params);
	}
	
	public List<PostEntity> findByCategory(PostCategoryEnum category){
		Object[] paramCategory = {category};
		return super.findListNamed("findByCategory", paramCategory);
	}

	@Override
	public void delete(PostEntity post) {
		super.delete(post);
	}

	@Override
	public List<PostEntity> listAll() {
		return super.findListPure("SELECT p FROM Post p", null);
	}


}

package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;

public class UserDao extends BaseDao implements UserDaoLocal {

    @Override
    public void save(UserEntity user) {
        super.saveOrUpdate(user);
    }
	
	@Override
	public UserEntity find(Long id) {
		return (UserEntity) super.findById(UserEntity.class, id);
	}

	@Override
	public List<UserEntity> findPureList(String sql, Object[] params) {	
		return super.findListPure(sql, params);
	}

	@Override
	public void delete(UserEntity user) {
		super.delete(user);
	}

  @Override
  public List<UserEntity> listAll() {
      return super.findListPure("SELECT u FROM User u", null);
  }

}

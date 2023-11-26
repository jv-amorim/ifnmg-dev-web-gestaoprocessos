package br.edu.ifnmg.gestaoprocessos.data.user;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    public UserEntity findByEmail(String email) {
        TypedQuery query = entityManager.createQuery("SELECT u FROM User u WHERE email = :email", UserEntity.class);
        query.setParameter("email", email);
        return (UserEntity) query.getSingleResult();
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

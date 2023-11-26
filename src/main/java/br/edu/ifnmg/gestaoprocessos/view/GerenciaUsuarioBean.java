package br.edu.ifnmg.gestaoprocessos.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifnmg.gestaoprocessos.data.user.UserDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;

@Named
@ViewScoped
public class GerenciaUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private UserEntity user = new UserEntity();
	
	@Inject
	private UserDao userDao;
	
	@PostConstruct
	public void init() {
		listUser = userDao.listAll();
	}

	private List<UserEntity> listUser = new ArrayList<UserEntity>();
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public UserRole[] getUserRoles() {
        return UserRole.values();
    }

	public List<UserEntity> getListUser() {
		
		
		return listUser;
	}

	public void setListUser(List<UserEntity> listUser) {
		this.listUser = listUser;
	}
	
	
	
	
}

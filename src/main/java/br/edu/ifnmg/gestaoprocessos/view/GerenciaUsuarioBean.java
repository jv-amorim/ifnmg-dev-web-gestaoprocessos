package br.edu.ifnmg.gestaoprocessos.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifnmg.gestaoprocessos.data.user.UserDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserServiceLocal;

@Named
@ViewScoped
public class GerenciaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserEntity user = new UserEntity();
	private Integer activeTabIndex = 0;
	private List<UserEntity> listUser = new ArrayList<UserEntity>();

	@Inject
	private UserDao userDao;
    @Inject
    private UserServiceLocal userService;
	
	@PostConstruct
	public void init() {
		listUser = userDao.listAll();
	}

	@Transactional(rollbackOn = Exception.class)
	public void registerUser() {
		user.setPasswordHash(userService.generatePasswordHash(user.getPasswordHash()));
		userDao.save(user);
		if (listUser.contains(user) == false) {
			listUser.add(user);
		}
		user = new UserEntity();
	}

	@Transactional(rollbackOn = Exception.class)
	public void deleteUser(UserEntity user) {
		userDao.delete(user);
		listUser.remove(user);
	}

	public void loadUser(UserEntity user) {
		this.user = new UserEntity();
		this.user = user;
		activeTabIndex = 0;
	}

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

	public Integer getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(Integer activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}

}

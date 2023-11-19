package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "UserRecovery")
@Table(name = "userRecovery")
public class UserRecoveryEntity extends BaseEntity implements Serializable{

	private Boolean opened;
	private Boolean used;

	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "userid", nullable = false)
	private UserEntity user;

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}

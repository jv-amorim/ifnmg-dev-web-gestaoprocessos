package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "PostHistory")
@Table(name = "postHistory")
public class PostHistoryEntity extends BaseEntity implements Serializable{
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "userid", nullable = false)
	private UserEntity user;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}

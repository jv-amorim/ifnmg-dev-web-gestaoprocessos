package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "PostSocial")
@Table(name = "postSocial")
public class PostSocialEntity extends BaseEntity implements Serializable{
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private PostSocialPlataform type;
	
	@Column(nullable = false,length = 255)
	private String url;
	
	@Column(nullable = false, length = 20)
	private String socialId;

	public PostSocialPlataform getType() {
		return type;
	}

	public void setType(PostSocialPlataform type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	
	
}

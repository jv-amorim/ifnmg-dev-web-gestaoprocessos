package br.edu.ifnmg.gestaoprocessos.domain.postsocial;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity(name = "PostSocial")
@Table(name = "postsocial")
public class PostSocialEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PostSocialPlataform type;

    @Column(nullable = false, length = 255)
    private String url;

    @Column(nullable = true, length = 20)
    private String socialId;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
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
    //</editor-fold>

}

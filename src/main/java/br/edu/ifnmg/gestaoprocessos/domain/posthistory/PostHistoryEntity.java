package br.edu.ifnmg.gestaoprocessos.domain.posthistory;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PostHistory")
@Table(name = "posthistory")
public class PostHistoryEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity user;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    //</editor-fold>

}

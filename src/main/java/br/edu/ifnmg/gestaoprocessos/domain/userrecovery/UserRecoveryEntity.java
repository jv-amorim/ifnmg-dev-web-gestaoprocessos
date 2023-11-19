package br.edu.ifnmg.gestaoprocessos.domain.userrecovery;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserRecovery")
@Table(name = "userrecovery")
public class UserRecoveryEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Boolean opened;

    @Column(nullable = false)
    private Boolean used;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity user;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
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
    //</editor-fold>

}

package br.edu.ifnmg.gestaoprocessos.applicant;

import br.edu.ifnmg.gestaoprocessos.base.BaseEntity;
import br.edu.ifnmg.gestaoprocessos.user.UserEntity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Applicant")
@Table(name = "applicants")
public class ApplicantEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate birthdate;
    
    @Column(nullable = false)
    private Boolean emailVerified;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    @JoinColumn(name = "userid", nullable = false, unique = true)
    private UserEntity user;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    //</editor-fold>
    
}

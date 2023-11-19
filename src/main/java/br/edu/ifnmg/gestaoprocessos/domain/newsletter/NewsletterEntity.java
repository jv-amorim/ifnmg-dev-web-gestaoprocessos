package br.edu.ifnmg.gestaoprocessos.domain.newsletter;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Newsletter")
@Table(name = "newsletter")
public class NewsletterEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private NewsletterStatus status;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "newsletters_applicants")
    private List<ApplicantEntity> applicants;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public NewsletterStatus getStatus() {
        return status;
    }

    public void setStatus(NewsletterStatus status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ApplicantEntity> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<ApplicantEntity> applicants) {
        this.applicants = applicants;
    }
    //</editor-fold>

}

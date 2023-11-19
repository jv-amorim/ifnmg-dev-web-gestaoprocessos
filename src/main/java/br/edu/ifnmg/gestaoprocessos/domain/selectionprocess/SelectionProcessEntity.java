package br.edu.ifnmg.gestaoprocessos.domain.selectionprocess;

import br.edu.ifnmg.gestaoprocessos.domain.applicantprocess.ApplicantProcessEntity;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "SelectionProcess")
@Table(name = "selectionprocess")
public class SelectionProcessEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SelectionProcessStatus status;

    @Column(nullable = true)
    private String openAt;

    @Column(nullable = true)
    private String closedAt;

    @OneToMany(mappedBy = "process", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicantProcessEntity> aplications;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SelectionProcessStatus getStatus() {
        return status;
    }

    public void setStatus(SelectionProcessStatus status) {
        this.status = status;
    }

    public String getOpenAt() {
        return openAt;
    }

    public void setOpenAt(String openAt) {
        this.openAt = openAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public List<ApplicantProcessEntity> getAplications() {
        return aplications;
    }

    public void setAplications(List<ApplicantProcessEntity> aplication) {
        this.aplications = aplication;
    }
    //</editor-fold>

}

package br.edu.ifnmg.gestaoprocessos.domain.applicantprocess;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessEntity;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ApplicantProcess")
@Table(name = "applicantprocess")
public class ApplicantProcessEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "result_", nullable = true)
    private Integer result;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantid", nullable = false)
    private ApplicantEntity applicant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "selectionprocessid", nullable = false)
    private SelectionProcessEntity process;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public ApplicantEntity getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantEntity applicant) {
        this.applicant = applicant;
    }

    public SelectionProcessEntity getProcess() {
        return process;
    }

    public void setProcess(SelectionProcessEntity process) {
        this.process = process;
    }
    //</editor-fold>

}

package br.edu.ifnmg.gestaoprocessos.domain.applicant;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "ApplicantProcess")
@Table(name = "applicantsProcess")
public class ApplicantProcessEntity extends BaseEntity implements Serializable {
	
	@Column(nullable = false)
	private Integer result;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "applicantid", nullable = false)
	private ApplicantEntity applicant;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "selectionProcessid", nullable = false)
	private SelectionProcessEntity process;

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
	
	
}

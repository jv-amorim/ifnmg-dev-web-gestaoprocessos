package br.edu.ifnmg.gestaoprocessos.domain.applicant;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "Newsletter")
@Table(name = "newsletter")
public class NewsletterEntity extends BaseEntity implements Serializable{
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length =20)
	private NewsletterStatus status;
	
	@Column(nullable = false, length = 500)
	private String content;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="tbl_applicants_newsletter",
				joinColumns = {@JoinColumn(name = "applicantid")},
				inverseJoinColumns = {@JoinColumn(name = "newsletterid")})
	private ArrayList<ApplicantEntity> applicants;

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

	public ArrayList<ApplicantEntity> getApplicants() {
		return applicants;
	}

	public void setApplicants(ArrayList<ApplicantEntity> applicants) {
		this.applicants = applicants;
	}
	
	
}
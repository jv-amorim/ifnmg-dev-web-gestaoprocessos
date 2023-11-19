package br.edu.ifnmg.gestaoprocessos.domain.applicant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "SelectionProcess")
@Table(name = "selectionProcess")
public class SelectionProcessEntity extends BaseEntity implements Serializable{
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private SelectionProcessStatus status;
	
	private String openAt;
	private String closedAt;
	
	@OneToMany(mappedBy = "process", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ApplicantProcessEntity> aplication;

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

	public List<ApplicantProcessEntity> getAplication() {
		return aplication;
	}

	public void setAplication(List<ApplicantProcessEntity> aplication) {
		this.aplication = aplication;
	}

	
}

package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.json.bind.annotation.JsonbTransient;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "User")
@Table(name = "user_")
public class UserEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "role_", nullable = false, length = 20)
	private UserRole role;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, unique = true, length = 255)
	private String email;

	@Column(nullable = false, length = 1024)
	private String passwordHash;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(nullable = true)
	@JsonbTransient
	private ApplicantEntity applicant;

	// <editor-fold defaultstate="collapsed" desc="Getters/Setters">
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public ApplicantEntity getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}

	// </editor-fold>

}
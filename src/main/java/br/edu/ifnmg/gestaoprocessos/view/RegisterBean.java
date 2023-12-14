package br.edu.ifnmg.gestaoprocessos.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifnmg.gestaoprocessos.data.applicant.ApplicantDao;
import br.edu.ifnmg.gestaoprocessos.data.user.UserDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserServiceLocal;

@Named
@ViewScoped
public class RegisterBean implements Serializable{

	private static final long serialVersionUID = -3714500760602455112L;

	private UserEntity novoUsuario = new UserEntity();
	private ApplicantEntity applicant = new ApplicantEntity();
	private String password = new String();
	 
	@Inject
	private UserDao userDao;
    @Inject
    private UserServiceLocal userService;
	@Inject
	private ApplicantDao applicantDao;

	@Transactional(rollbackOn = Exception.class)
	public void registrarUsuario() {
		//novoUsuario.setPasswordHash(userService.generatePasswordHash(password));
		novoUsuario.setRole(UserRole.APPLICANT);
		novoUsuario.setPasswordHash(userService.generatePasswordHash(password));
		userDao.save(novoUsuario); //Salvamento Previo para criação de ID.
				
		String formatCPF = applicant.getCpf();
		formatCPF = formatCPF.replace(".", "");
		formatCPF = formatCPF.replace("-", "");
		applicant.setCpf(formatCPF);
		applicant.setEmailVerified(true);
		applicant.setUser(novoUsuario);
		
		novoUsuario.setApplicant(applicant);
		
		applicantDao.save(applicant);
		userDao.save(novoUsuario); //Atualizar o usuario, adicionando um atributo a applicant.
	}

	public UserEntity getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(UserEntity novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public ApplicantEntity getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

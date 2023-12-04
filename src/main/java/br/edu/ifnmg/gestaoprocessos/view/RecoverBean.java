package br.edu.ifnmg.gestaoprocessos.view;

import java.io.Serializable;
import java.util.Properties;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import br.edu.ifnmg.gestaoprocessos.data.user.UserDao;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserServiceLocal;

@Named
@ViewScoped
public class RecoverBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2540948345232639048L;

	private String recoverEmail;
	private Boolean emailSended = false;
	private Integer randomcode;

	private String newPassWord;
	private Integer recovercode;

	@Inject
	UserDao userDao;
	@Inject
	private UserServiceLocal userService;
	@Inject
	private FacesContext facesContext;

	public void sendRecoverEmail() throws AddressException, MessagingException {
		if (existEmail()) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			ServletContext servletContext = (ServletContext) externalContext.getContext();
			final String email = servletContext.getInitParameter("SMTP-EMAIL");
			final String key = servletContext.getInitParameter("SMTP-KEY");

			Random randomCodeGen = new Random();
			randomcode = randomCodeGen.nextInt(999999);

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");

			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email, key);
				}
			};
			Session session = Session.getInstance(props, auth);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recoverEmail));
			message.setSubject("Recuperação de conta Gestão Porcessos Seletivos");
			message.setText("Codigo de recuperação de conta: " + randomcode);
			Transport.send(message);
			emailSended = true;
		} else {
			facesContext.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Esse email não possui cadastro", null));
		}
	}

	private Boolean existEmail() {
		try {
			UserEntity user = userDao.findByEmail(recoverEmail);
			return user != null ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(rollbackOn = Exception.class)
	public String recoverAccount() {

		if (randomcode != null && randomcode.equals(recovercode)) {
			UserEntity user = userDao.findByEmail(recoverEmail);
			user.setPasswordHash(userService.generatePasswordHash(newPassWord));
			userDao.save(user);
			return "index?faces-redirect=true";
		} else {
			facesContext.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Codigo de Recuperação invalido", null));
			return "";
		}
	}

	public String getRecoverEmail() {
		return recoverEmail;
	}

	public void setRecoverEmail(String recoverEmail) {
		this.recoverEmail = recoverEmail;
	}

	public Boolean getEmailSended() {
		return emailSended;
	}

	public void setEmailSended(Boolean emailSended) {
		this.emailSended = emailSended;
	}

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public Integer getRecovercode() {
		return recovercode;
	}

	public void setRecovercode(Integer recovercode) {
		this.recovercode = recovercode;
	}

}

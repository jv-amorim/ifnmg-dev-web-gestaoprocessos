package br.edu.ifnmg.gestaoprocessos.view;

import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserServiceLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotEmpty;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    private FacesContext facesContext;
    @Inject
    private SecurityContext securityContext;
    @Inject
    private UserServiceLocal userService;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>

    public void login() throws IOException {
        switch (processAuthentication()) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciais inválidas", null));
                break;
            case SUCCESS:
                ExternalContext ec = getExternalContext();
                String initialPage = getUserInitialPage();
                ec.redirect(ec.getRequestContextPath() + initialPage);
                break;
        }
    }

    private AuthenticationStatus processAuthentication() {
        ExternalContext ec = getExternalContext();
        return securityContext.authenticate(
                (HttpServletRequest) ec.getRequest(),
                (HttpServletResponse) ec.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(email, password)));
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }

    private String getUserInitialPage() {
        UserEntity user = userService.getByEmail(email);
        switch (user.getRole()) {
            case ADMIN:
                return "/admin/index.xhtml";
            case EDITOR:
                return "/cms/index.xhtml";
            default:
                return "/app/index.xhtml";
        }
    }

    public void logout() throws IOException {
        ExternalContext ec = getExternalContext();

        HttpServletRequest req = (HttpServletRequest) ec.getRequest();
        HttpSession session = req.getSession();
        session.invalidate();

        ec.redirect("/GestaoProcessos-1.0-SNAPSHOT/index.xhtml");
    }

}

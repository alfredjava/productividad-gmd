package com.gmd.productividad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.gmd.productividad.domain.Parametro;
import com.gmd.productividad.service.ParametroService;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Controller(value="loginActionBean")
@Scope(value = "session")
public class LoginActionBean {
    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager am;
    private String username;
    private String password;
    @Autowired
    private ParametroService parametroService;
    private List<Parametro> listaTipoProceso;
	public void login() {
		System.out.println("Login .");
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        //if(listaTipoProceso ==null)
          //  listaTipoProceso = parametroService.listarTiposProceso();
        //try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUsername(), getPassword());
            Authentication result = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            //SecurityContextHolder.getContext().getAuthentication().getDetails();
            System.out.println("Login Success! ..");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido", username));
            nav.performNavigation("ir-principal");
        /*} catch (AuthenticationException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales incorrectas", "El usuario y/o el password son incorrectos"));
        }*/
    }
    public void logout() {
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        SecurityContextHolder.getContext().setAuthentication(null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .clear();
        nav.performNavigation("ir-principal");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

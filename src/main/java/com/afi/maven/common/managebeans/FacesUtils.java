/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.common.managebeans;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author AFI
 */
@ManagedBean(name = "facesUtils")
@ApplicationScoped
public class FacesUtils {
    
    public String retrieveRequestParam(String key) {
        return FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get(key);
    }
    
    public Locale retrieveDefaultLocale() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
    
    public String retrieveRequestQueryString(String key) {        
        return retrieveActiveServletRequest().getParameter(key);
    }
    
    public String retrieveRequestHeader(String key) {        
        return retrieveActiveServletRequest().getHeader(key);
    }
    
    public String retrieveContextPath() {
        return retrieveActiveServletRequest().getContextPath();
    }

    public String retrieveRequestURI() {
        return retrieveActiveServletRequest().getRequestURI();
    }
    
    public String retrieveServerName() {
        return retrieveActiveServletRequest().getServerName();
    }
    
    public Integer retrieveServerPort() {
        return retrieveActiveServletRequest().getServerPort();
    }
    
    public HttpServletRequest retrieveActiveServletRequest() {
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    } 
    
    public String retrieveMessage(String key) {
        System.out.println("locale " + FacesContext.getCurrentInstance().getViewRoot().getLocale());
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
        return bundle.getString(key);        
    }

    public String retrieveMessage(String key, String ... values ) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
        String msg = bundle.getString(key);        
        
        for (int i = 0 ; i < values.length ; i++) {
            msg = msg.replace("{" + (i) + "}", values[i]);
        }
        
        return msg;
    }
    
    public String retrieveUserLogin() {
        return ((HttpServletRequest)FacesContext.getCurrentInstance()
                .getExternalContext().getRequest()).getRemoteUser();
    }
    
    public void addFacesMsg(
            FacesMessage.Severity severity, String forComp, String msg, String detail) {
        FacesMessage message = new FacesMessage(
                                        severity,
                                        msg,
                                        detail);
        FacesContext.getCurrentInstance().addMessage(forComp, message);
        
    }
    
    public void redirectToExternal(String externalAppUrl) throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("http://" + 
                retrieveServerName() + ":" + 
                retrieveServerPort() + externalAppUrl);
        
    }    
    
}

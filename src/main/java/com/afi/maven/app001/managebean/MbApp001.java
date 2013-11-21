/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.managebean;

import com.afi.maven.common.managebeans.MbSessionApp;
import com.afi.maven.model.AfidsbscMstuser;
import com.afi.maven.app001.service.App001ServiceInterface;
import com.afi.maven.app001.viewobject.VoAfidsbscMstuser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author AFI
 */
@ManagedBean(name = "mbApp001")
@ViewScoped
public class MbApp001 {
    
    private VoAfidsbscMstuser voAfidsbscMstuser;
                              
    @ManagedProperty(value="#{app001Service}")
    private App001ServiceInterface app001Service;
    
    @PostConstruct
    public void postConstruct() {
        voAfidsbscMstuser = new VoAfidsbscMstuser();
    }
    
    public void saveUser(){
        System.out.println("MasukSaveUser");
        AfidsbscMstuser afidsbscMstuser = new AfidsbscMstuser();
        afidsbscMstuser.setvUserName(voAfidsbscMstuser.getvUserName());
        afidsbscMstuser.setvPassword(voAfidsbscMstuser.getvPassword());
        System.out.println("userName : "+afidsbscMstuser.getvUserName());
        System.out.println("password : "+afidsbscMstuser.getvPassword());        
//        app001Service.saveUser(afidsbscMstuser);
    }

    public VoAfidsbscMstuser getVoAfidsbscMstuser() {
        return voAfidsbscMstuser;
    }
    
    public void setVoAfidsbscMstuser(VoAfidsbscMstuser voAfidsbscMstuser) {
        this.voAfidsbscMstuser = voAfidsbscMstuser;
    }   

    public App001ServiceInterface getApp001Service() {
        return app001Service;
    }

    public void setApp001Service(App001ServiceInterface app001Service) {
        this.app001Service = app001Service;
    }
    
}

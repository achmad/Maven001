/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app000.managebean.session;

import com.afi.maven.common.managebeans.MbSessionApp;
import com.afi.maven.common.service.AppCommonServiceInterface;
import com.afi.maven.model.AfidsbscMstmenu;
import com.afi.maven.model.AfidsbscMstuser;
import com.afi.maven.app001.viewobject.VoUserLogin;
import com.afi.maven.common.viewobject.VoTab;
import com.twmacinta.util.MD5;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.TabCloseEvent;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;


/**
 *
 * @author AFI
 */
@ManagedBean(name = "mbApp000")
@ViewScoped
public class MbApp000 {   
           
    @ManagedProperty(value="#{mbSessionApp}")
    private MbSessionApp mbSessionApp;
    
    @ManagedProperty(value="#{appCommonService}")
    private AppCommonServiceInterface appCommonService;
    
    private VoUserLogin voUserLogin;  
    
    @PostConstruct
    public void postConstruct() {
       voUserLogin = new VoUserLogin();
    }  
    
    public void onTabClose(TabCloseEvent event) {        
        System.out.println("ID-NYA : "+event.getTab().getId());
        mbSessionApp.getVoTabs();
    }  
    
    public void openNewTab(String urlContent){
        VoTab voTab = new VoTab();
        voTab.setTitle("Testing");
        voTab.setUrlContent("http://www.detik.com");
        mbSessionApp.getVoTabs().add(voTab);
        System.out.println("TEST : "+urlContent);
    }
    
    public void test(){
        System.out.println("TEST : ");
    }
        
    public void doLogin(){
        
        AfidsbscMstuser afidsbscMstuser = new AfidsbscMstuser();
        afidsbscMstuser.setvUserName(voUserLogin.getUserName());
        afidsbscMstuser.setvPassword(new MD5(voUserLogin.getPassword()).asHex());
        System.out.println("userName : "+afidsbscMstuser.getvUserName());
        System.out.println("Password : "+afidsbscMstuser.getvPassword());
        if(appCommonService.authentication(afidsbscMstuser)){
            mbSessionApp.setUserName(voUserLogin.getUserName());
            mbSessionApp.setPassword(new MD5(voUserLogin.getPassword()).asHex());  
            mbSessionApp.generateMenu();
            HttpServletRequest servletRequest = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());        
            String rootPath = servletRequest.getContextPath();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(rootPath+"/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(MbSessionApp.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }else{}
    }
    
    public void doLogout(){
        System.out.println("Masuk sini");
        HttpServletRequest servletRequest = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());        
        String rootPath = servletRequest.getContextPath();
        servletRequest.getSession().invalidate();
        System.out.println("rootPath "+rootPath);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(rootPath+"/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(MbSessionApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MbSessionApp getMbSessionApp() {
        return mbSessionApp;
    }

    public void setMbSessionApp(MbSessionApp mbSessionApp) {
        this.mbSessionApp = mbSessionApp;
    }

    public AppCommonServiceInterface getAppCommonService() {
        return appCommonService;
    }

    public void setAppCommonService(AppCommonServiceInterface appCommonService) {
        this.appCommonService = appCommonService;
    }

    public VoUserLogin getVoUserLogin() {
        return voUserLogin;
    }

    public void setVoUserLogin(VoUserLogin voUserLogin) {
        this.voUserLogin = voUserLogin;
    }
    
    public MenuModel getModel() {
        return mbSessionApp.getModel();
    }   
}

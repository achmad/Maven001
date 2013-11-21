/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.common.managebeans;

import com.afi.maven.common.viewobject.VoTab;
import com.afi.maven.common.service.AppCommonServiceInterface;
import com.afi.maven.model.AfidsbscMstmenu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

/**
 *
 * @author AFI
 */
@ManagedBean(name = "mbSessionApp")
@SessionScoped
public class MbSessionApp implements Serializable{
    
    private List<VoTab> voTabs;
    private MenuModel model;
    private String userName;
    private String password;
    
    @ManagedProperty(value="#{appCommonService}")
    private AppCommonServiceInterface appCommonService;
    
    @PostConstruct
    public void postConstruct() {
       model = new DefaultMenuModel();
       VoTab tempVoTab = new VoTab();
       tempVoTab.setTitle("Home");
//       tempVoTab.setUrlContent("http://www.detik.com");
       voTabs = new ArrayList<VoTab>();
       voTabs.add(tempVoTab);
    }
    
    public void generateMenu(){
        AfidsbscMstmenu afidsbscMstmenu = appCommonService.getMenuById("DIMS");
        if(afidsbscMstmenu.getChild()!=null){
            for(int i=0;i<afidsbscMstmenu.getChild().size();i++){
                Object temp = generateMenu(afidsbscMstmenu.getChild().get(i));
                Submenu submenu = (Submenu) temp;
                model.addElement(submenu);
            }
        }        
    }
    
    private Object generateMenu(AfidsbscMstmenu afidsbscMstmenu){
        Object result = null;
        if(afidsbscMstmenu.getChild().size()>0){
            DefaultSubMenu submenu = new DefaultSubMenu();
            submenu.setLabel(afidsbscMstmenu.getTitle());
            for(int i=0;i<afidsbscMstmenu.getChild().size();i++){
                Object temp = generateMenu(afidsbscMstmenu.getChild().get(i));
                if(temp instanceof DefaultMenuItem){
                    DefaultMenuItem tempMenuItem = (DefaultMenuItem) temp;
                    submenu.addElement(tempMenuItem);
                }else if(temp instanceof Submenu){
                    DefaultSubMenu tempSubmenu = (DefaultSubMenu) temp;
                    submenu.addElement(tempSubmenu);
                }
            }
            result = submenu;
        }else{
            FacesContext facesCtx = FacesContext.getCurrentInstance();
            ELContext elCtx = facesCtx.getELContext();
            ExpressionFactory expFact = facesCtx.getApplication().getExpressionFactory();

            DefaultMenuItem item = new DefaultMenuItem();
            item.setValue(afidsbscMstmenu.getTitle());
            item.setCommand("#{mbApp000.openNewTab('"+afidsbscMstmenu.getvUrl()+"')}");
            item.setUpdate(":formCentral:tabView");
            result = item;
        }
        return result;
    } 

    public AppCommonServiceInterface getAppCommonService() {
        return appCommonService;
    }

    public void setAppCommonService(AppCommonServiceInterface appCommonService) {
        this.appCommonService = appCommonService;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public List<VoTab> getVoTabs() {
        return voTabs;
    }

    public void setVoTabs(List<VoTab> voTabs) {
        this.voTabs = voTabs;
    }   
}

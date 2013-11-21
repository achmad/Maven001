/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.model;

import com.afi.maven.common.model.BaseAuditImpl;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author AFI
 */
@Entity
@Table(name="AFI_MSTMENU")
public class AfidsbscMstmenu extends BaseAuditImpl implements Serializable {
    
    @Column(name="VMENUID",length = 16,nullable = false)
    private String vMenuId;
    
    @Column(name="VTITLE",length = 24,nullable = false)
    private String vTitle;
    
    @Column(name="VURL",length = 128,nullable = true)
    private String vUrl;
    
    /*
     * Menu has parent. In database, root menu has parent = "" instead of NULL !!! 
     * Hibernate will try to find menu with id = "", resulting Entity Not Found, then throw exception.
     * Hibernate annot has @NotFound, but no equivalent annot exist in JPA.
     * either fetch set to lazy, or fix db value if want to stick with jpa annotation.
     * or use mixed hibernate/jpa annotation.
     */
    @ManyToOne(targetEntity=AfidsbscMstmenu.class, fetch= FetchType.LAZY)
    @JoinColumn(name="VPARENT", referencedColumnName="VMENUID")    
    @NotFound(action= NotFoundAction.IGNORE)    
    private AfidsbscMstmenu afidsbscMstmenu;

    @OneToMany(targetEntity = AfidsbscMstmenu.class,fetch = FetchType.LAZY)
    @JoinColumn(name="VPARENT", referencedColumnName="VMENUID",insertable = false,updatable = false)    
    @NotFound(action= NotFoundAction.IGNORE)    
    private List<AfidsbscMstmenu> child;

    public String getvUrl() {
        return vUrl;
    }

    public void setvUrl(String vUrl) {
        this.vUrl = vUrl;
    }

    public String getvMenuId() {
        return vMenuId;
    }

    public void setvMenuId(String vMenuId) {
        this.vMenuId = vMenuId;
    }

    public String getvTitle() {
        return vTitle;
    }

    public void setvTitle(String vTitle) {
        this.vTitle = vTitle;
    }

    public List<AfidsbscMstmenu> getChild() {
        return child;
    }

    public void setChild(List<AfidsbscMstmenu> child) {
        this.child = child;
    }   
    
    public String getMenuId() {
        return vMenuId;
    }

    public void setMenuId(String menuId) {
        this.vMenuId = menuId;
    }

    public String getTitle() {
        return vTitle;
    }

    public void setTitle(String title) {
        this.vTitle = title;
    }

    public AfidsbscMstmenu getAfidsbscMstmenu() {
        return afidsbscMstmenu;
    }

    public void setAfidsbscMstmenu(AfidsbscMstmenu afidsbscMstmenu) {
        this.afidsbscMstmenu = afidsbscMstmenu;
    }    
}
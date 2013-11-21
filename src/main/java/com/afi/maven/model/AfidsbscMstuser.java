/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.model;

import com.afi.maven.common.model.BaseAuditImpl;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author AFI
 */
@Entity
@Table(name="AFI_MSTUSER")
public class AfidsbscMstuser extends BaseAuditImpl implements Serializable{
        
    @Column(name="VUSERNAME",length = 30,nullable = false,unique = true)     
    private String vUserName;
    
    @Column(name="VPASSWORD")
    private String vPassword;

    public String getvUserName() {
        return vUserName;
    }

    public void setvUserName(String vUserName) {
        this.vUserName = vUserName;
    }

    public String getvPassword() {
        return vPassword;
    }

    public void setvPassword(String vPassword) {
        this.vPassword = vPassword;
    }   
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.model;

import com.afi.maven.app001.common.model.BaseAuditImpl;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author AFI
 */
@Entity
@Table(name="AFIDSBSC_MSTUSER")
public class AfidsbscMstuser extends BaseAuditImpl implements Serializable{
        
    @Column(name="VUSERNAME",length = 30,nullable = false,unique = true)     
    private String vUserName;
    
    @Column(name="VPASSWORD")
    private String vPassword;
         
    
}

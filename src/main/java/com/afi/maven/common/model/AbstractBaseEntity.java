/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.common.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDHexGenerator;

/**
 *
 * @author AFI
 */
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable{   
    
    @Id
    @Column(name="ID", length=64, unique=true)
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

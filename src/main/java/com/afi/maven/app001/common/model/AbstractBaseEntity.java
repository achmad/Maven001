/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.common.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author AFI
 */
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable{
    
    @Id
    @Column(name="ID", length=12, unique=true)
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    
}

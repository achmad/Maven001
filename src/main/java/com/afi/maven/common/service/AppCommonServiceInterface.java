/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.common.service;

import com.afi.maven.model.AfidsbscMstmenu;
import com.afi.maven.model.AfidsbscMstuser;

/**
 *
 * @author AFI
 */
public interface AppCommonServiceInterface {
    
    public boolean authentication(AfidsbscMstuser afidsbscMstuser);
    public AfidsbscMstmenu getMenuById(String vMenuId);
    public Long retrieveCountChild(String vMenuId);
    
}

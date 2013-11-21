/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.dao;

import com.afi.maven.common.dao.GenericDaoInterface;
import com.afi.maven.common.model.AbstractBaseEntity;
import com.afi.maven.model.AfidsbscMstmenu;
import com.afi.maven.model.AfidsbscMstuser;

/**
 *
 * @author AFI
 */
public interface AfidsbscMstmenuDaoInterface extends GenericDaoInterface<AfidsbscMstmenu,AbstractBaseEntity>{
    
    public AfidsbscMstmenu getMenuByMenuId(String vMenuId);   
    public Long retrieveCountChild(String vMenuId);
}

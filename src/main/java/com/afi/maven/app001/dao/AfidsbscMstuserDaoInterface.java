/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.dao;

import com.afi.maven.common.dao.GenericDaoInterface;
import com.afi.maven.common.model.AbstractBaseEntity;
import com.afi.maven.model.AfidsbscMstuser;

/**
 *
 * @author AFI
 */
public interface AfidsbscMstuserDaoInterface extends GenericDaoInterface<AfidsbscMstuser,AbstractBaseEntity>{
    
    public AfidsbscMstuser getAfidsbscMstuser(AfidsbscMstuser afidsbscMstuser);
    
    
}

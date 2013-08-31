/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.dao.impl;

import com.afi.maven.app001.common.dao.GenericHibernateDao;
import com.afi.maven.app001.common.model.AbstractBaseEntity;
import com.afi.maven.app001.dao.AfidsbscMstuserDaoInterface;
import com.afi.maven.app001.model.AfidsbscMstuser;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AFI
 */
@Repository("afidsbscMstuserDao")
public class AfidsbscMstuserDaoImpl extends GenericHibernateDao<AfidsbscMstuser, AbstractBaseEntity>
    implements AfidsbscMstuserDaoInterface{
    
    
    
}

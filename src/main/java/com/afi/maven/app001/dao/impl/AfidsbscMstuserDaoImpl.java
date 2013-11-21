/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.dao.impl;

import com.afi.maven.common.dao.GenericHibernateDao;
import com.afi.maven.common.model.AbstractBaseEntity;
import com.afi.maven.app001.dao.AfidsbscMstuserDaoInterface;
import com.afi.maven.model.AfidsbscMstuser;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AFI
 */
@Repository("afidsbscMstuserDao")
public class AfidsbscMstuserDaoImpl extends GenericHibernateDao<AfidsbscMstuser, AbstractBaseEntity>
    implements AfidsbscMstuserDaoInterface{    

    @Override
    public AfidsbscMstuser getAfidsbscMstuser(AfidsbscMstuser afidsbscMstuser) {
        AfidsbscMstuser result;
        result = (AfidsbscMstuser) getCurrentSession()
                .createQuery("from AfidsbscMstuser user "
                + "where user.vUserName = :userName "
                + "and user.vPassword = :password")
                .setParameter("userName", afidsbscMstuser.getvUserName())
                .setParameter("password", afidsbscMstuser.getvPassword())
                .uniqueResult();
        return result;
    }
}

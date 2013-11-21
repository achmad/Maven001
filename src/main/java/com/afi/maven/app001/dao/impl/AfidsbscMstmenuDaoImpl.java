/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.dao.impl;

import com.afi.maven.common.dao.GenericHibernateDao;
import com.afi.maven.common.model.AbstractBaseEntity;
import com.afi.maven.app001.dao.AfidsbscMstmenuDaoInterface;
import com.afi.maven.model.AfidsbscMstmenu;
import com.afi.maven.model.AfidsbscMstuser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AFI
 */
@Repository("afidsbscMstmenuDao")
public class AfidsbscMstmenuDaoImpl extends GenericHibernateDao<AfidsbscMstmenu, AbstractBaseEntity> 
    implements AfidsbscMstmenuDaoInterface{

    @Override
    public AfidsbscMstmenu getMenuByMenuId(String vMenuId) {
        AfidsbscMstmenu result = null;
        result = (AfidsbscMstmenu) getCurrentSession()
                .createQuery("from AfidsbscMstmenu menu "
                + "where menu.vMenuId = :vMenuId ")
                .setParameter("vMenuId", vMenuId)
                .uniqueResult();
        return result;
    }

    @Override
    public Long retrieveCountChild(String vMenuId) {
        Criteria crit = getCurrentSession().createCriteria(AfidsbscMstmenu.class);
        crit.createAlias("afidsbscMstmenu", "afidsbscMstmenu");
        crit.add(Restrictions.eq("afidsbscMstmenu.vMenuId", vMenuId));
        
        return ((Number)crit.setProjection(Projections.rowCount())
                .uniqueResult()).longValue();
    }
    
}

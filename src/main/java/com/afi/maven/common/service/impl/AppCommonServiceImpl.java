/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.common.service.impl;

import com.afi.maven.common.service.AppCommonServiceInterface;
import com.afi.maven.app001.dao.AfidsbscMstmenuDaoInterface;
import com.afi.maven.app001.dao.AfidsbscMstuserDaoInterface;
import com.afi.maven.model.AfidsbscMstmenu;
import com.afi.maven.model.AfidsbscMstuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AFI
 */
@Service("appCommonService")
@Transactional(readOnly=true)
public class AppCommonServiceImpl implements AppCommonServiceInterface{

    @Autowired
    @Qualifier("afidsbscMstuserDao")                
    private AfidsbscMstuserDaoInterface afidsbscMstuserDao;
    
    @Autowired
    @Qualifier("afidsbscMstmenuDao")                
    private AfidsbscMstmenuDaoInterface afidsbscMstmenuDao;

    public AfidsbscMstuserDaoInterface getAfidsbscMstuserDao() {
        return afidsbscMstuserDao;
    }

    public void setAfidsbscMstuserDao(AfidsbscMstuserDaoInterface afidsbscMstuserDao) {
        this.afidsbscMstuserDao = afidsbscMstuserDao;
    }
    
    @Override
    public boolean authentication(AfidsbscMstuser afidsbscMstuser) {
        boolean result = false;
        AfidsbscMstuser temp = afidsbscMstuserDao.getAfidsbscMstuser(afidsbscMstuser);
        if(temp != null){
            return true;
        }
        return result;
    }

    @Override
    public AfidsbscMstmenu getMenuById(String vMenuId) {
        return afidsbscMstmenuDao.getMenuByMenuId(vMenuId);
    }

    @Override
    public Long retrieveCountChild(String vMenuId) {
        return afidsbscMstmenuDao.retrieveCountChild(vMenuId);
    }
    
}

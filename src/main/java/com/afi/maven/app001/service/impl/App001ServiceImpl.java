/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.service.impl;

import com.afi.maven.common.service.GenericService;
import com.afi.maven.app001.dao.AfidsbscMstuserDaoInterface;
import com.afi.maven.model.AfidsbscMstuser;
import com.afi.maven.app001.service.App001ServiceInterface;
import com.twmacinta.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AFI
 */
@Service("app001Service")
@Transactional(readOnly=true)
public class App001ServiceImpl extends GenericService implements App001ServiceInterface{

    @Autowired
    @Qualifier("afidsbscMstuserDao")                
    private AfidsbscMstuserDaoInterface afidsbscMstuserDao;

    public AfidsbscMstuserDaoInterface getAfidsbscMstuserDao() {
        return afidsbscMstuserDao;
    }

    public void setAfidsbscMstuserDao(AfidsbscMstuserDaoInterface afidsbscMstuserDao) {
        this.afidsbscMstuserDao = afidsbscMstuserDao;
    }   
    
    @Override
    @Transactional(readOnly = false)
    public boolean saveUser(AfidsbscMstuser afidsbscMstuser) {
        afidsbscMstuser.setvPassword(new MD5(afidsbscMstuser.getvPassword()).asHex() );
        afidsbscMstuserDao.save(afidsbscMstuser);
        afidsbscMstuserDao.flush();
        return true;
    }
    
}

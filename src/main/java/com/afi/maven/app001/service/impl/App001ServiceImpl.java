/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.service.impl;

import com.afi.maven.app001.common.service.GenericService;
import com.afi.maven.app001.dao.AfidsbscMstuserDaoInterface;
import com.afi.maven.app001.model.AfidsbscMstuser;
import com.afi.maven.app001.service.App001ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author AFI
 */
@Service("app001Service")
public class App001ServiceImpl extends GenericService implements App001ServiceInterface{

    @Autowired
    @Qualifier("afidsbscMstuserDao")
    private AfidsbscMstuserDaoInterface afidsbscMstuserDao;
    
    @Override
    public boolean saveUser(AfidsbscMstuser afidsbscMstuser) {
        afidsbscMstuserDao.save(afidsbscMstuser);
        return true;
    }
    
}

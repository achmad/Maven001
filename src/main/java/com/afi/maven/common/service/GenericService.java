/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.common.service;

import com.afi.maven.common.model.BaseAuditInterface;
import java.util.Date;

/**
 *
 * @author AFI
 */
public class GenericService {
    protected void updateCreationInfo(BaseAuditInterface entity, String user) {
        Date currentTime = new Date();
        entity.setCreateBy(user);
        entity.setCreateDate(currentTime);
        entity.setLastModBy(user);
        entity.setLastModDate(currentTime);
    }

    protected void updateLastModInfo(BaseAuditInterface entity, String user) {
        Date currentTime = new Date();
        entity.setLastModBy(user);
        entity.setLastModDate(currentTime);
    }
}

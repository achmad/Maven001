/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.common.dao;

import java.io.Serializable;

/**
 *
 * @author AFI
 */
public interface GenericDaoInterface <T, K extends Serializable>{
    
    /**
     * might not hit db, return proxy placeholder, throw ex if no rec found
     */
    T load(K key);
        
    /**
     * always hit db, might return null if no rec found
     */
    T get(K key);
    
    void delete(K key);
    
    void save(T newEntity);
    
    void evict(Object entity);
    
    void update(T editedEntity);
    
    void flush();
    
    void clear();
    
    
}

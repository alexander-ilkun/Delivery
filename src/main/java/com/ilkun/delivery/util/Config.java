package com.ilkun.delivery.util;

/**
 *
 * @author alexander-ilkun
 */
public interface Config {
    
    public <T> Class<T> getImpl(String ifc);
}

package com.ilkun.delivery.infrastructure;

/**
 *
 * @author alexander-ilkun
 */
public interface Config {
    
    public <T> Class<T> getImpl(String ifc);
}

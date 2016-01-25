package com.ilkun.delivery.infrastructure;

/**
 *
 * @author alexander-ilkun
 */
public class ServiceLocator {
    
    private static final ServiceLocator instance = new ServiceLocator();
    private final Config javaConfig = new JavaConfig();
    
    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        return instance;
    }

    public Object createObject(String objectName) throws InstantiationException, IllegalAccessException {
        return javaConfig.getImpl(objectName).newInstance();
    }
}

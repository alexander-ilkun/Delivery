package com.ilkun.delivery.infrastructure;

/**
 *
 * @author alexander-ilkun
 */
public interface ApplicationContext {

    Object getBean(String beanName) throws Exception;
}

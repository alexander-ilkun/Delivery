package com.ilkun.delivery.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 *
 * @author alexander-ilkun
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory clbf) throws BeansException {
        BeanDefinition bd = clbf.getBeanDefinition("newCustomer");
        ConstructorArgumentValues argumentValues = bd.getConstructorArgumentValues();
        System.out.println(argumentValues.getArgumentCount());
        System.out.println(argumentValues.getArgumentValue(0, null).getValue());
        argumentValues.getArgumentValue(0, null).setValue("Nik");
        bd.setScope("sigleton");
        //<bean class="com.ilkun.delivery.infrastructure.CustomBeanFactoryPostProcessor" />
    }
    
}

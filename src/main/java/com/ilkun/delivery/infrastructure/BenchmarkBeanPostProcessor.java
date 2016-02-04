package com.ilkun.delivery.infrastructure;

import com.ilkun.delivery.infrastructure.proxy.BenchmarkProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author alexander-ilkun
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object obj, String string) throws BeansException {
        return obj;
    }

    @Override
    public Object postProcessAfterInitialization(Object obj, String string) throws BeansException {
        return BenchmarkProxy.tryCreateBenchmarkProxy(obj);
    }
    
}

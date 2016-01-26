package com.ilkun.delivery.infrastructure;

import com.ilkun.delivery.infrastructure.annotations.PostCreate;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author alexander-ilkun
 */
public class JavaConfigApplicationContext implements ApplicationContext {

    private final Config config;
    private final Map<String, Object> pool = new HashMap<>();

    public JavaConfigApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        Class<?> type = config.getImpl(beanName);
        Object bean = pool.get(beanName);

        if (bean != null) {
            return bean;
        }

        BeanBuilder builder = new BeanBuilder(type);
        builder.construct();
        builder.afterConstruct();
        builder.createProxy();
        bean = builder.build();

        pool.put(beanName, bean);

        return bean;
    }

    class BeanBuilder {

        private final Class<?> type;
        private Object bean;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }

        public void construct() throws Exception {
            Constructor<?> constructor = type.getConstructors()[0];
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length == 0) {
                bean = type.newInstance();
            } else {
                Object[] initargs = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    String typeName = parameter.getType().getSimpleName();
                    initargs[i] = getBean(Character.toLowerCase(typeName.charAt(0)) + typeName.substring(1));
                }
                bean = constructor.newInstance(initargs);
            }

        }

        public void afterConstruct() {
            Class<?> clazz = bean.getClass();
            try {
                Method initMethod = clazz.getMethod("init");
                initMethod.invoke(bean);
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
            try {
                Method[] methods = clazz.getMethods();
                for (Method curMethod : methods) {
                    if (curMethod.isAnnotationPresent(PostCreate.class) && 
                            !curMethod.getName().equals("init")) {
                        curMethod.invoke(bean);
                    }
                }
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        }

        public void createProxy() {
        }

        public Object build() {
            return bean;
        }
    }

}

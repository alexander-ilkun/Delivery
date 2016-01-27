package com.ilkun.delivery.infrastructure.proxy;

import com.ilkun.delivery.infrastructure.annotations.Benchmark;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author alexander-ilkun
 */
public class BenchmarkProxy {

    public static Object tryCreateBenchmarkProxy(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getMethods();
        for (Method curMethod : methods) {
            if (curMethod.isAnnotationPresent(Benchmark.class)) {
                return createBenchmarkProxy(obj);
            }
        }
        return obj;
    }

    private static Object createBenchmarkProxy(final Object obj) {
        Class<?> clazz = obj.getClass().getInterfaces()[0];
        InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
            method = obj.getClass().getMethod(method.getName(),
                    method.getParameterTypes());
            if (method.isAnnotationPresent(Benchmark.class)) {
                long start;
                long end;
                Object result;
                System.out.println("Method " + method.getName()
                        + " invoked.");
                start = System.nanoTime();
                result = method.invoke(obj, args);
                end = System.nanoTime();
                System.out.println("Method " + method.getName()
                        + " worked for " + (end - start) + " nanos.");
                return result;
            } else {
                return method.invoke(obj, args);
            }
        };
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                handler);
    }
}

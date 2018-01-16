package org.freemason.deepexecutor.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class ContextHolder {

    private static ConcurrentMap<String, Object> beans = Maps.newConcurrentMap();

    public static <T> T registry(T bean){
        return (T)beans.put(bean.getClass().getSimpleName(), bean);
    }

    public static <T> T getBean(Class<T> clazz){
        return (T)beans.get(clazz.getSimpleName());
    }

    public static Set<Object> getBeans(){
        return Sets.newHashSet(beans.values());
    }

    public static boolean exists(Class<?> clazz){
        return beans.containsKey(clazz.getSimpleName());
    }
}

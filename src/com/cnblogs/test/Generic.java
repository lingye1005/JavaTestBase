package com.cnblogs.test;

/**
 * Created by caoxiaohong on 17/3/5.
 * 反射实例
 */
public class Generic {
    public <T> T getObject(Class<T> c) throws InstantiationException,IllegalAccessException{
        T t=c.newInstance();
        return t;
    }
}

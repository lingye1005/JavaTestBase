package com.cnblogs.test;

/**
 * Created by caoxiaohong on 17/3/5.
 */
public class GenericTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{

        Generic generic = new Generic();
        //
        Object obj = generic.getObject(Class.forName("com.cnblogs.test.User"));
        //指出obj是否是User类的一个特定实例
        System.out.println(obj instanceof User);
    }
}

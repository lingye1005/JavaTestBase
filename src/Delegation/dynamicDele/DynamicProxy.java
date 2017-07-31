package Delegation.dynamicDele;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by caoxiaohong on 17/3/26.
 * 中介类,调用处理器
 */
public class DynamicProxy implements InvocationHandler {
    private Object obj;//obj为动态代理对象
    public DynamicProxy(Object obje){this.obj=obje;}
    //参数说明:object为代理方对象,method调用的代理方的方法,args为调用的代理方方法的参数
    @Override
    public Object invoke(Object object, Method method,Object[] args) throws Throwable{
        System.out.println("before");
        Object result=method.invoke(obj,args);
        System.out.println("after");
        return result;
    }
}

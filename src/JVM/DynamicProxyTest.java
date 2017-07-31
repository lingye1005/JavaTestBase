package JVM;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by caoxiaohong on 17/7/9.
 */
public class DynamicProxyTest {
    //final可以是局部变量,成员变量,类变量的修饰符.~~~~~对应变量值不可以改.
    //satic可以修饰成员变量,方法,但不能修饰局部变量.~~~~并且静态变量值可以多次被赋值.~~~~静态变量在静态方法,普通方法里面都可以使用.
    static int a=10;
    final  int b=10;
    final static int c=20;

    static void get(){
        a=10;
        //static int c=1;  //非法
        final int c=2;
    }
    void test(){
        a=0;
        final int c=0;

    }


    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello{
        @Override
        public void sayHello(){
            System.out.println("hello world");
        }

    }

    static class DynamicProxy implements InvocationHandler{

        Object originalObj;
        Object bind(Object originalObj){
            this.originalObj=originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this);
        }
        @Override
        public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{
            System.out.println("welcome");
            return method.invoke(originalObj,args);
        }
    }

    public static void main(String[] args) {
        IHello hello=(IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
    }
}

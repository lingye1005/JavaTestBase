package designmodel.chapter12;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 21:05
 * @ProjectName: JavaBaseTest
 * 外观类
 */
public class Facade {
    SubSystemA a;
    SubSystemB b;
    SubSystemC c;

    //构造函数
    Facade(){
        a=new SubSystemA();
        b=new SubSystemB();
        c=new SubSystemC();
    }

    //方法1
    public void method1(){
        System.out.println("method1 in facade:");
        a.methodA();
        b.methodB();
    }

    //方法2
    public void method2(){
        System.out.println("method2 in facade:");
        b.methodB();
        c.methodC();
    }
}

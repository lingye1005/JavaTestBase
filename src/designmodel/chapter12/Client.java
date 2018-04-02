package designmodel.chapter12;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 21:14
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.method1();
        facade.method2();
    }
}

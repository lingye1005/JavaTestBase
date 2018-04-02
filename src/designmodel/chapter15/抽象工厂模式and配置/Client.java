package designmodel.chapter15.抽象工厂模式and配置;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 11:22
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //获取配置文件信息
        Factory.getType();

        ProductA a=Factory.getProductA();
        ProductB b=Factory.getProductB();
        //A产品的crud操作
        a.create(a.getClass().newInstance());
        a.retrieve();
        a.update(a.getClass().newInstance());
        a.delete("1");

        System.out.println("--------分隔线-------");

        //B产品的crud操作
        b.create(b.getClass().newInstance());
        b.retrieve();
        b.update(b.getClass().newInstance());
        b.delete("1");
    }
}

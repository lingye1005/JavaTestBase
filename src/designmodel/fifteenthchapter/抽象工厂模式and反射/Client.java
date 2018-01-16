package designmodel.fifteenthchapter.抽象工厂模式and反射;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 10:27
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) throws Exception{
        ProductA productA=Factory.getProductA();
        ProductB productB=Factory.getProductB();

        //产品A的crud操作
        productA.create(productA.getClass().newInstance());
        productA.retrieve();
        productA.update(productA.getClass().newInstance());
        productA.delete("1");

        System.out.println("------分隔线----------");

        //产品B的crud操作
        productB.create(productB.getClass().newInstance());
        productB.retrieve();
        productB.update(productB.getClass().newInstance());
        productB.delete("1");
    }
}

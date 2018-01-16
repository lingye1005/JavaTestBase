package designmodel.fifteenthchapter.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:31
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        ProductA productA=Factory.getProductA("1");
        ProductB productB=Factory.getProductB("1");
        //A产品的crud操作
        productA.create(new ConcreteProductA1());
        productA.retrieve();
        productA.update(new ConcreteProductA1());
        productA.delete("1");

        System.out.println("-------分隔线---------");

        //B产品的crud操作
        productB.create(new ConcreteProductB1());
        productB.retrieve();
        productB.update(new ConcreteProductB1());
        productB.delete("1");
    }
}

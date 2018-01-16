package designmodel.fifteenthchapter.抽象工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:08
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        //使用1类型工厂,创建1类型的产品A和B(当然,也可以使用类型2,写法一致)

        //创建工厂实例和产品实例
        ConcreteFactory1 cf1=new ConcreteFactory1();
        ConcreteProductA1 a1=(ConcreteProductA1)cf1.getA();
        ConcreteProductB1 b1=(ConcreteProductB1)cf1.getB();
        //调用A1产品的crud方法
        a1.create(new ConcreteProductA1());
        a1.retrieve();
        a1.update(new ConcreteProductA1());
        a1.delete("1");
        //调用B1产品的crud方法
        b1.create(new ConcreteProductB1());
        b1.retrieve();
        b1.update(new ConcreteProductB1());
        b1.delete("1");
    }
}

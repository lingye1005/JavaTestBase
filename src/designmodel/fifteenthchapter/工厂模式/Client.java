package designmodel.fifteenthchapter.工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 21:56
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        //建立工厂A1
        ConcreteFactoryA1 cfa1=new ConcreteFactoryA1();
        //生成产品A1
        ConcreteProductA1 pa1=(ConcreteProductA1)cfa1.getProduct();
        //对产品A1的crud操作
        pa1.create(new ConcreteProductA1());
        pa1.retrieve();
        pa1.update(new ConcreteProductA1());
        pa1.delete("1");

        System.out.println("--------分隔线--------");

        //建立工厂A2
        ConcreteFactoryA2 cfa2=new ConcreteFactoryA2();
        //生成产品A2
        ConcreteProductA2 pa2=(ConcreteProductA2)cfa2.getProduct();
        //对产品A2的crud操作
        pa2.create(new ConcreteProductA2());
        pa2.retrieve();
        pa2.update(new ConcreteProductA2());
        pa2.delete("1");

    }
}

package designmodel.fifteenthchapter.抽象工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:05
 * @ProjectName: JavaBaseTest
 */
public class ConcreteFactory2 implements Factory {
    @Override
    public ProductA getA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB getB() {
        return new ConcreteProductB2();
    }
}

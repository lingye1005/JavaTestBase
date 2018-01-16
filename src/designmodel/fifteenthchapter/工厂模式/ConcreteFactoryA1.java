package designmodel.fifteenthchapter.工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 21:40
 * @ProjectName: JavaBaseTest
 */
public class ConcreteFactoryA1 implements Factory {
    @Override
    public ProductA getProduct() {
        return new ConcreteProductA1();
    }
}

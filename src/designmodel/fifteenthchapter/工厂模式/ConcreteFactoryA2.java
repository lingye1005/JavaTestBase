package designmodel.fifteenthchapter.工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 21:48
 * @ProjectName: JavaBaseTest
 */
public class ConcreteFactoryA2 implements Factory {
    @Override
    public ProductA getProduct() {
        return new ConcreteProductA2();
    }
}

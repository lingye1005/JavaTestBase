package designmodel.chapter15.抽象工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 22:48
 * @ProjectName: JavaBaseTest
 */
public interface Factory {
    ProductA getA();
    ProductB getB();
}

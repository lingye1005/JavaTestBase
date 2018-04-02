package designmodel.chapter15.抽象工厂模式and反射;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 10:27
 * @ProjectName: JavaBaseTest
 */
public interface ProductA {
    //crud
    void create(ProductA productA);
    ProductA retrieve();
    boolean update(ProductA productA);
    boolean delete(String id);
}

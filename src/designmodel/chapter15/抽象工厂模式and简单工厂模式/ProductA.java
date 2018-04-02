package designmodel.chapter15.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:34
 * @ProjectName: JavaBaseTest
 */
public interface ProductA {
    //crud
    void create(ProductA a);
    ProductA retrieve();
    boolean update(ProductA a);
    boolean delete(String id);
}

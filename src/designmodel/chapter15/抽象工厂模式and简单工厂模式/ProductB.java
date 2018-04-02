package designmodel.chapter15.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:36
 * @ProjectName: JavaBaseTest
 */
public interface ProductB {
    //crud
    void create(ProductB b);
    ProductB retrieve();
    boolean update(ProductB b);
    boolean delete(String id);
}

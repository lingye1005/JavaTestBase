package designmodel.chapter15.抽象工厂模式and配置;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 11:21
 * @ProjectName: JavaBaseTest
 */
public interface ProductB {
    //crud
    void create(ProductB productB);
    ProductB retrieve();
    boolean update(ProductB productB);
    boolean delete(String id);
}

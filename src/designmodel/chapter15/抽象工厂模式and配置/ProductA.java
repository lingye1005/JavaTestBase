package designmodel.chapter15.抽象工厂模式and配置;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 11:21
 * @ProjectName: JavaBaseTest
 */
public interface ProductA {
    //crud操作
    void create(ProductA productA);
    ProductA retrieve();
    boolean update(ProductA productA);
    boolean delete(String id);
}

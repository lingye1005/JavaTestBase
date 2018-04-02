package designmodel.chapter15.工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 21:40
 * @ProjectName: JavaBaseTest
 */
public interface ProductA {
    //crud
    void create(ProductA product);
    ProductA retrieve();
    boolean update(ProductA product);
    boolean delete(String id);
}

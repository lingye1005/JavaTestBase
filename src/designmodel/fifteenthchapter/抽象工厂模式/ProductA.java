package designmodel.fifteenthchapter.抽象工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 22:43
 * @ProjectName: JavaBaseTest
 */
public interface ProductA {
    //crud
    void create(ProductA product);
    ProductA retrieve();
    boolean update(ProductA product);
    boolean delete(String id);
}

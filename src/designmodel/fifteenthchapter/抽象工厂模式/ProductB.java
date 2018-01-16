package designmodel.fifteenthchapter.抽象工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 22:58
 * @ProjectName: JavaBaseTest
 */
public interface ProductB {
    //crud
    void create(ProductB product);
    ProductA retrieve();
    boolean update(ProductB product);
    boolean delete(String id);
}

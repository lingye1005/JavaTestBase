package designmodel.fifteenthchapter.抽象工厂模式and反射;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 10:29
 * @ProjectName: JavaBaseTest
 */
public interface ProductB {
    //crud
    void create(ProductB productB);
    ProductB retrieve();
    boolean update(ProductB productB);
    boolean delete(String id);
}

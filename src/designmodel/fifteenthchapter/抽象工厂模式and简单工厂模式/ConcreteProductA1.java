package designmodel.fifteenthchapter.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:38
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductA1 implements ProductA {
    @Override
    public void create(ProductA a) {
        System.out.println("新增一条ConcreteA1记录");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查找一条ConcreteA1记录");
        return null;
    }

    @Override
    public boolean update(ProductA a) {
        System.out.println("更新一条ConcreteA1记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ConcreteA1记录");
        return false;
    }
}

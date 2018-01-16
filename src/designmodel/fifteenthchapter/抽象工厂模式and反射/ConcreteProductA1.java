package designmodel.fifteenthchapter.抽象工厂模式and反射;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 10:32
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductA1 implements ProductA{
    @Override
    public void create(ProductA productA) {
        System.out.println("新增一条ConcreteProductA1记录");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查询一条ConcreteProductA1记录");
        return null;
    }

    @Override
    public boolean update(ProductA productA) {
        System.out.println("更新一条ConcreteProductA1记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ConcreteProductA1记录");
        return false;
    }
}

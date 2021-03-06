package designmodel.chapter15.抽象工厂模式and配置;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 11:31
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductA2 implements ProductA {
    @Override
    public void create(ProductA productA) {
        System.out.println("新增一条ConcreteProductA2记录");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查询一条ConcreteProductA2记录");
        return null;
    }

    @Override
    public boolean update(ProductA productA) {
        System.out.println("更新一条ConcreteProductA2记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ConcreteProductA2记录");
        return false;
    }
}

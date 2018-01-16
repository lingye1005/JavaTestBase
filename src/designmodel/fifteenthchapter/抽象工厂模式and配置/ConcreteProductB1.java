package designmodel.fifteenthchapter.抽象工厂模式and配置;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 11:33
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductB1 implements ProductB {
    @Override
    public void create(ProductB productB) {
        System.out.println("新增一条ConcreteProductB1记录");
    }

    @Override
    public ProductB retrieve() {
        System.out.println("查询一条ConcreteProductB1记录");
        return null;
    }

    @Override
    public boolean update(ProductB productB) {
        System.out.println("更新一条ConcreteProductB1记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ConcreteProductB1记录");
        return false;
    }
}

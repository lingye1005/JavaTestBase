package designmodel.fifteenthchapter.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:45
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductB2 implements ProductB {
    @Override
    public void create(ProductB b) {
        System.out.println("新增一条B2产品记录");
    }

    @Override
    public ProductB retrieve() {
        System.out.println("查询一条B2产品记录");
        return null;
    }

    @Override
    public boolean update(ProductB b) {
        System.out.println("更新一条B2产品记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条B2产品记录");
        return false;
    }
}

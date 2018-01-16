package designmodel.fifteenthchapter.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 23:41
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductA2 implements ProductA {

    @Override
    public void create(ProductA a) {
        System.out.println("添加一条ConcreteA2记录");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查询一条ConcreteA2记录");
        return null;
    }

    @Override
    public boolean update(ProductA a) {
        System.out.println("更新一条ConcreteA2记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ConcreteA2记录");
        return false;
    }
}

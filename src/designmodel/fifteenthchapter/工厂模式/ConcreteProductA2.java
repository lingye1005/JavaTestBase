package designmodel.fifteenthchapter.工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 21:41
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductA2 implements ProductA {
    @Override
    public void create(ProductA product) {
        System.out.println("增加一条ProductA2的信息");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查找一条ProductA2的信息");
        return null;
    }

    @Override
    public boolean update(ProductA product) {
        System.out.println("更新一条ProductA2的信息");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ProductA2的信息");
        return false;
    }
}

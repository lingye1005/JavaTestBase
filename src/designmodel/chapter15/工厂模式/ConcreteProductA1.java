package designmodel.chapter15.工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/13 21:40
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductA1 implements ProductA {
    @Override
    public void create(ProductA product) {
        System.out.println("增加一条ProductA1的信息");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查找一条ProductA1的信息");
        return null;
    }

    @Override
    public boolean update(ProductA product) {
        System.out.println("更新一条ProductA1的信息");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ProductA1的信息");
        return false;
    }
}

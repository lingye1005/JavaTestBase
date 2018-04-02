package designmodel.chapter15.抽象工厂模式;



/**
 * @Author: cxh
 * @CreateTime: 18/1/13 22:17
 * @ProjectName: JavaBaseTest
 */
public class ConcreteProductB1 implements ProductB {
    @Override
    public void create(ProductB product) {
        System.out.println("增加一条ProductB1记录");
    }

    @Override
    public ProductA retrieve() {
        System.out.println("查找一条ProductB1记录");
        return null;
    }

    @Override
    public boolean update(ProductB product) {
        System.out.println("更新一条ProductB1记录");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("删除一条ProductB1记录");
        return false;
    }
}

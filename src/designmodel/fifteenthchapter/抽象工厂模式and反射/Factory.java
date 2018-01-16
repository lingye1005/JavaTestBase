package designmodel.fifteenthchapter.抽象工厂模式and反射;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 10:32
 * @ProjectName: JavaBaseTest
 * 利用反射,去除了简单工厂模式中的switch case语句
 */
public class Factory {
    private static final String path="designmodel.fifteenthchapter.抽象工厂模式and反射";
    private static final String type="1";

    //利用反射,获取实例
    public static ProductA getProductA() throws Exception{
        return  (ProductA)Class.forName(path+".ConcreteProductA"+type).newInstance();
    }
    public static ProductB getProductB() throws Exception{
        return  (ProductB)Class.forName(path+".ConcreteProductB"+type).newInstance();
    }
}

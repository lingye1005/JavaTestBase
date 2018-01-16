package designmodel.fifteenthchapter.抽象工厂模式and简单工厂模式;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 09:52
 * @ProjectName: JavaBaseTest
 */
public class Factory {
    //获取产品A系列某一个产品
    public static ProductA getProductA(String type){
        switch (type){
            case "1":
                return new ConcreteProductA1();
            case "2":
                return new ConcreteProductA2();
        }
        return null;
    }
    //获取产品B系列某一个产品
    public static ProductB getProductB(String type){
        switch (type){
            case "1":
                return new ConcreteProductB1();
            case "2":
                return new ConcreteProductB2();
        }
        return null;
    }
}

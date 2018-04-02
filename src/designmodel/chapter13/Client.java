package designmodel.chapter13;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 23:45
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        Director director=new Director();

        ConcreteBuilder1 concreteBuilder1=new ConcreteBuilder1();
        director.build(concreteBuilder1);
        Product product1=concreteBuilder1.getProduct();

        ConcreteBuilder2 concreteBuilder2=new ConcreteBuilder2();
        director.build(concreteBuilder2);
        Product product2=concreteBuilder2.getProduct();

        //输出product1
        System.out.println("product1:");
        for(String str:product1.product)
            System.out.println(str);
        System.out.println("---------");

        //输出product2
        System.out.println("product2:");
        for(String s:product2.product)
            System.out.println(s);
    }
}

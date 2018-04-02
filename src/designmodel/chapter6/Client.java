package designmodel.chapter6;

/**
 * @Author: cxh
 * @CreateTime: 18/1/2 21:38
 * @ProjectName: JavaBaseTest
 */
public class Client  {
    //测试类
    public static void main(String[] args) {
        Person person=new Person("朱莉");
        TShirts tShirts=new TShirts();
        Pants pants=new Pants();
        Shoes shoes=new Shoes();

        tShirts.decorator(person);
        pants.decorator(tShirts);
        shoes.decorator(pants);
        shoes.operation();
    }
}

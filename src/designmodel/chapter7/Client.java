package designmodel.chapter7;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 21:07
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        SchoolGirl girl=new SchoolGirl("黎敏");
        Proxy proxy=new Proxy(girl);
        //通过调用代理方法,间接调用Persuit的方法.
        proxy.giveFlowers();
        proxy.giveDolls();
        proxy.giveChocolate();
    }
}

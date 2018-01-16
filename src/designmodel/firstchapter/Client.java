package designmodel.firstchapter;

/**
 * @Author: cxh
 * @CreateTime: 17/12/31 17:53
 * @ProjectName: JavaBaseTest
 */
public class Client {
    //客户端代码
    public static void main(String[] args) {
        //定义一种操作
        Operation ope=OperationFactory.createOperation("+");
        //定义两个操作数
        ope.setFirst(11);
        ope.setSecond(22);
        //输出计算结果
        System.out.println(ope.getResult());
    }
}

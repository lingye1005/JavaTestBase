package designmodel.chapter8;

/**
 * @Author: cxh
 * @CreateTime: 18/1/6 11:44
 * @ProjectName: JavaBaseTest
 */
public class Client{
    public static void main(String[] args) {
        CreateFactory factory;
        Operation operation;

        //加法
        factory=new AddFactory();
        operation=factory.getOperation();
        operation.setFirst(11);
        operation.setSecond(22);
        System.out.println("11+22="+operation.getResult());

        //减法
        factory=new SubFactory();
        operation=factory.getOperation();
        operation.setFirst(11);
        operation.setSecond(22);
        System.out.println("11-22="+operation.getResult());

        //乘法
        factory=new MulFactory();
        operation=factory.getOperation();
        operation.setFirst(11);
        operation.setSecond(22);
        System.out.println("11*22="+operation.getResult());

        //除法
        factory=new DivFacotry();
        operation=factory.getOperation();
        operation.setFirst(22);
        operation.setSecond(11);
        System.out.println("22/11="+operation.getResult());
    }
}
